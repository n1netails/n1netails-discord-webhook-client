package com.n1ne.n1netails.discord.exception;

public class DiscordWebhookDeliveryException extends DiscordWebhookException {
    private final int statusCode;

    public DiscordWebhookDeliveryException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
