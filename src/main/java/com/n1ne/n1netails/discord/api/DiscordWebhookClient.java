package com.n1ne.n1netails.discord.api;

import com.n1ne.n1netails.discord.exception.DiscordWebhookException;
import com.n1ne.n1netails.discord.model.WebhookMessage;

public interface DiscordWebhookClient {
    void sendMessage(String webhookUrl, WebhookMessage message) throws DiscordWebhookException;
}
