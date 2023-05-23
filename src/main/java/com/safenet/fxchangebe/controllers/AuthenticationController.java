package com.safenet.fxchangebe.controllers;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.safenet.fxchangebe.dto.TokenResponse;
import com.safenet.fxchangebe.dto.UserDTO;
import com.safenet.fxchangebe.entities.User;
import com.safenet.fxchangebe.services.AuthenticationService;
import com.safenet.fxchangebe.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authService;

    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public ResponseEntity<?> login(HttpServletResponse response, @RequestBody Map<String,Object> string) throws Exception {
        String idTokenString = (String) string.get("idToken");
        System.out.println(idTokenString);
        //verify id token with google
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory()).build();
        GoogleIdToken idToken = verifier.verify(idTokenString);

        if (idToken == null) throw new RuntimeException("Error in verify process");

        Payload payload = idToken.getPayload();
        UserDTO existUser = userService.findUserByGoogleId(payload.getSubject());

        // Get profile information from payload
        String googleId = payload.getSubject();
        String email = payload.getEmail();
        String fullname = (String) payload.get("name");
        String avatarUrl = (String) payload.get("picture");
//            String locale = (String) payload.get("locale");

        if (existUser == null) {      //User not exist
            System.out.println("null");

            // Use or store profile information
            User user = new User();
            user.getInformations().setEmail(email);
            user.getInformations().setFullname(fullname);
            user.getInformations().setAvatarUrl(avatarUrl);
            user.setGoogleId(googleId);

            existUser = userService.createUser(user);
        } else {            //User already exist
            //add attendance for day
//            existUser.getAttendanceDates().add();
            System.out.println(new Date());
        }
        //generate access and refresh tokens
        String role = existUser.getRole().getName();
        String accessToken = authService.generateToken(googleId, fullname, role);
        String refreshToken = authService.generateRefreshToken();

        Cookie accessTokenCookie = new Cookie("accessToken", accessToken);
        accessTokenCookie.setHttpOnly(true);
        accessTokenCookie.setMaxAge(60 * 30);
        Cookie refreshTokenCookie = new Cookie("refreshToken", refreshToken);
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setMaxAge(60 * 60 * 24 * 30); // 30 day

        response.addCookie(accessTokenCookie);
        response.addCookie(refreshTokenCookie);

        return ResponseEntity.ok("Login success");
    }

    @GetMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(HttpServletRequest request, HttpServletResponse response, String refreshToken) {
        String newToken = authService.refreshToken(refreshToken);

        Cookie accessTokenCookie = new Cookie("accessToken", newToken);
        accessTokenCookie.setHttpOnly(true);
        accessTokenCookie.setMaxAge(60 * 30);
        response.addCookie(accessTokenCookie);

        return ResponseEntity.ok(newToken);
    }

    @GetMapping("/logout")
    public void logout() {

    }
}
