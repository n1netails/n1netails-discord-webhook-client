package com.n1ne.n1netails.discord.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.n1ne.n1netails.discord.exception.DiscordWebhookDeliveryException;
import com.n1ne.n1netails.discord.exception.DiscordWebhookException;
import com.n1ne.n1netails.discord.exception.DiscordWebhookSerializationException;
import com.n1ne.n1netails.discord.model.WebhookMessage;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebhookService {

    private final ObjectMapper objectMapper = new ObjectMapper(); // Jackson

    public void send(String webhookUrl, WebhookMessage message) throws DiscordWebhookException {
        try {
            URL url = new URL(webhookUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            String payload;
            try {
                payload = objectMapper.writeValueAsString(message);
            } catch (Exception e) {
                throw new DiscordWebhookSerializationException("Failed to serialize webhook message", e);
            }

            try (OutputStream os = connection.getOutputStream()) {
                os.write(payload.getBytes());
                os.flush();
            }

            int responseCode = connection.getResponseCode();
            if (responseCode != 204 && responseCode != 200) {
                throw new DiscordWebhookDeliveryException("Discord webhook responded with HTTP status: " + responseCode, responseCode);
            }
        } catch (DiscordWebhookException e) {
            throw e; // Re-throw custom exceptions
        } catch (Exception e) {
            throw new DiscordWebhookException("Unexpected error while sending webhook", e);
        }
    }
}
