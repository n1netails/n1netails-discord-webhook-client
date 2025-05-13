package com.n1netails.n1netails.discord.exception;

/**
 * Discord Webhook Serialization Exception
 * @author shahid foy
 */
public class DiscordWebhookSerializationException extends DiscordWebhookException {

    /**
     * Discord Webhook Serialization Exception Constructor
     * @param message message
     * @param cause cause
     */
    public DiscordWebhookSerializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
