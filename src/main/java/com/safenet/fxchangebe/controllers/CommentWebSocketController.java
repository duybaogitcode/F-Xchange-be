//package com.safenet.fxchangebe.controllers;
//
//import com.safenet.fxchangebe.entities.Comment;
//import com.safenet.fxchangebe.repositories.CommentRepository;
//import com.safenet.fxchangebe.services.CommentService;
//import com.safenet.fxchangebe.services.UserService;
//import com.safenet.fxchangebe.services.WebSocketService;
//import org.bson.types.ObjectId;
//import org.json.JSONObject;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.socket.WebSocketSession;
//
//import java.sql.Timestamp;
//
//@Controller
//@MessageMapping("/comments")
//public class CommentWebSocketController {
//    WebSocketService socketService = new WebSocketService();
//
//    UserService userService = new UserService();
//
//    CommentService commentService = new CommentService();
//
//    @MessageMapping("/new")
//    public void createComments(WebSocketSession session, Message<JSONObject> message) {
//        JSONObject payload = message.getPayload();
//        String content = payload.getString("content");
//        String author = payload.getString("author");
//        String stuffId = payload.getString("stuffId");
//        long createAt = Long.parseLong(payload.get("timestamp").toString());
//
//        Comment comment = new Comment();
//        try {
//            comment.setAuthor(userService.findUserByGoogleId(author));
//            comment.setContent(content);
//            comment.setStuffId(new ObjectId(stuffId));
//            comment.setCreateAt(new Timestamp(createAt));
//            comment.setUpdateAt(null);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        commentService.createComment(comment);
//        // Broadcast new comment to all clients
//        socketService.sendMessage(comment, "/ws/comments");
//    }
//
//    @MessageMapping("/update")
//    public void updateComment(WebSocketSession session, Comment updatedComment) {
//        Comment saved = commentService.updateComment(updatedComment);
//
//        // Broadcast updated comment to clients
//        socketService.sendMessage(saved, "/ws/comments");
//    }
//}

//continue when stuff feature complete
