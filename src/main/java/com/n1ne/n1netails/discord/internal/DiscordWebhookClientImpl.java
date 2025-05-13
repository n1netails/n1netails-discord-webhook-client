package com.n1ne.n1netails.discord.internal;

import com.n1ne.n1netails.discord.api.DiscordWebhookClient;
import com.n1ne.n1netails.discord.exception.DiscordWebhookException;
import com.n1ne.n1netails.discord.model.WebhookMessage;
import com.n1ne.n1netails.discord.service.WebhookService;

public class DiscordWebhookClientImpl implements DiscordWebhookClient {

    private final WebhookService webhookService;

    public DiscordWebhookClientImpl(WebhookService webhookService) {
        this.webhookService = webhookService;
    }

    @Override
    public void sendMessage(String webhookUrl, WebhookMessage message) throws DiscordWebhookException {
        webhookService.send(webhookUrl, message);
    }
}
