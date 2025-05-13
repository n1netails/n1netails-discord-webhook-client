package com.n1netails.n1netails.discord.internal;

import com.n1netails.n1netails.discord.api.DiscordWebhookClient;
import com.n1netails.n1netails.discord.exception.DiscordWebhookException;
import com.n1netails.n1netails.discord.model.WebhookMessage;
import com.n1netails.n1netails.discord.service.WebhookService;

/**
 * Discord Webhook Client Implementation
 * @author shahid foy
 */
public class DiscordWebhookClientImpl implements DiscordWebhookClient {

    private final WebhookService webhookService;

    /**
     * Discord Webhook Client Implementation Constructor
     * @param webhookService discord webhook service
     */
    public DiscordWebhookClientImpl(WebhookService webhookService) {
        this.webhookService = webhookService;
    }

    /**
     * Send discord webhook message
     * @param webhookUrl discord webhook url
     * @param message discord message
     * @throws DiscordWebhookException discord webhook exception
     */
    @Override
    public void sendMessage(String webhookUrl, WebhookMessage message) throws DiscordWebhookException {
        webhookService.send(webhookUrl, message);
    }
}
