package com.n1ne.n1netails.discord.exception;

// Base exception
public class DiscordWebhookException extends Exception {
    public DiscordWebhookException(String message) {
        super(message);
    }

    public DiscordWebhookException(String message, Throwable cause) {
        super(message, cause);
    }
}
