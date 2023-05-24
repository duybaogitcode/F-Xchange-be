package com.safenet.fxchangebe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {
    private SimpMessageSendingOperations messagingTemplate;

    public void sendMessage(Object payload, String destination) {
        this.messagingTemplate.convertAndSend(destination, payload);
    }
}
