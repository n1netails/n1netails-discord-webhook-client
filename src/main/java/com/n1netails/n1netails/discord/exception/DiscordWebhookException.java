package com.n1netails.n1netails.discord.exception;

/**
 * Discord Webhook Exception (Base Exception)
 * @author shahid foy
 */
public class DiscordWebhookException extends Exception {

    /**
     * Discord Webhook Exception Constructor
     * @param message message
     */
    public DiscordWebhookException(String message) {
        super(message);
    }

    /**
     * Discord Webhook Exception Constructor
     * @param message message
     * @param cause cause
     */
    public DiscordWebhookException(String message, Throwable cause) {
        super(message, cause);
    }
}
