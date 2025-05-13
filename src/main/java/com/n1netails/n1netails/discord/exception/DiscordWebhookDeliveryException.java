package com.n1netails.n1netails.discord.exception;

/**
 * Discord Webhook Delivery Exception
 * @author shahid foy
 */
public class DiscordWebhookDeliveryException extends DiscordWebhookException {

    /**
     * Http status code
     */
    private final int statusCode;

    /**
     * Discord Webhook Delivery Exception Constructor
     * @param message error message
     * @param statusCode status code
     */
    public DiscordWebhookDeliveryException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    /**
     * Get exception status code
     * @return status code
     */
    public int getStatusCode() {
        return statusCode;
    }
}
