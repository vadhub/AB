package com.backend.athletica.entity.chat;


public class ChatMessage {
    private String senderName;
    private String content;
    private MessageStatus status;

    public ChatMessage(MessageStatus status, String senderName, String content) {
        this.senderName = senderName;
        this.content = content;
        this.status = status;
    }

    public ChatMessage(MessageStatus status, String senderName) {
        this.senderName = senderName;
        this.status = status;
    }

    public ChatMessage() {
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }
}