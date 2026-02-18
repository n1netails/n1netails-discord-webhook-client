package com.n1netails.n1netails.discord.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.n1netails.n1netails.discord.exception.DiscordWebhookDeliveryException;
import com.n1netails.n1netails.discord.exception.DiscordWebhookException;
import com.n1netails.n1netails.discord.exception.DiscordWebhookSerializationException;
import com.n1netails.n1netails.discord.model.WebhookFile;
import com.n1netails.n1netails.discord.model.WebhookMessage;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Discord Webhook Service
 * @author shahid foy
 */
public class WebhookService {

    private final ObjectMapper objectMapper = new ObjectMapper(); // Jackson

    /**
     * Webhook Service Constructor
     */
    public WebhookService() {}

    /**
     * Send discord webhook message
     * @param webhookUrl discord webhook url
     * @param message discord message
     * @throws DiscordWebhookException discord webhook exception
     */
    public void send(String webhookUrl, WebhookMessage message) throws DiscordWebhookException {
        try {
            URL url = new URL(webhookUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            String payload;
            try {
                payload = objectMapper.writeValueAsString(message);
            } catch (Exception e) {
                throw new DiscordWebhookSerializationException("Failed to serialize webhook message", e);
            }

            if (message.getFiles() != null && !message.getFiles().isEmpty()) {
                String boundary = "===" + System.currentTimeMillis() + "===";
                connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

                try (OutputStream os = connection.getOutputStream();
                     PrintWriter writer = new PrintWriter(os, true)) {

                    // payload_json part
                    writer.append("--").append(boundary).append("\r\n");
                    writer.append("Content-Disposition: form-data; name=\"payload_json\"\r\n");
                    writer.append("Content-Type: application/json; charset=UTF-8\r\n\r\n");
                    writer.append(payload).append("\r\n");
                    writer.flush();

                    // files parts
                    for (int i = 0; i < message.getFiles().size(); i++) {
                        WebhookFile file = message.getFiles().get(i);
                        writer.append("--").append(boundary).append("\r\n");
                        writer.append("Content-Disposition: form-data; name=\"files[").append(String.valueOf(i)).append("]\"; filename=\"").append(file.getFilename()).append("\"\r\n");
                        writer.append("Content-Type: application/octet-stream\r\n\r\n");
                        writer.flush();
                        os.write(file.getData());
                        os.flush();
                        writer.append("\r\n");
                        writer.flush();
                    }

                    writer.append("--").append(boundary).append("--\r\n");
                    writer.flush();
                }
            } else {
                connection.setRequestProperty("Content-Type", "application/json");
                try (OutputStream os = connection.getOutputStream()) {
                    os.write(payload.getBytes());
                    os.flush();
                }
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
