package com.backend.athletica.config;

import com.backend.athletica.entity.chat.ChatMessage;
import com.backend.athletica.entity.chat.MessageStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messageSendingTemplate;

    @Autowired
    public WebSocketEventListener(SimpMessageSendingOperations messageSendingTemplate) {
        this.messageSendingTemplate = messageSendingTemplate;
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) accessor.getSessionAttributes().get("username");
        if (username != null) {
            System.out.println("User disconected");
            var chatMessage = new ChatMessage(MessageStatus.LEAVE, username);
            messageSendingTemplate.convertAndSend("/chat/spot", chatMessage);
        }
    }
}
