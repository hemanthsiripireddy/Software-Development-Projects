package com.hemanth.model;

public class Message {
    private int from;
    private int to;
    private int messageId;
    private String message;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Message(int from, int to, int messageId, String message) {
        this.from = from;
        this.to = to;
        this.messageId = messageId;
        this.message = message;
    }
}
