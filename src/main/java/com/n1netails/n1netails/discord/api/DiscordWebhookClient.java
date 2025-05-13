package com.n1netails.n1netails.discord.api;

import com.n1netails.n1netails.discord.exception.DiscordWebhookException;
import com.n1netails.n1netails.discord.model.WebhookMessage;

/**
 * Discord Webhook Client
 * @author shahid foy
 */
public interface DiscordWebhookClient {

    /**
     * Send discord webhook message
     * @param webhookUrl discord webhook url
     * @param message discord message
     * @throws DiscordWebhookException discord webhook exception
     */
    void sendMessage(String webhookUrl, WebhookMessage message) throws DiscordWebhookException;
}
