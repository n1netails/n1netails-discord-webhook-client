package com.n1netails.n1netails.discord.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Discord Webhook Message
 * @author shahid foy
 */
@Getter
@Setter
public class WebhookMessage {

    private String content;
    private String username;
    private String avatar_url;
    private boolean tts;
    private List<Embed> embeds;

    /**
     * Webhook Message Constructor
     */
    public WebhookMessage() {}

    /**
     * Webhook Message Constructor
     * @param content webhook content
     */
    public WebhookMessage(String content) {
        this.content = content;
    }
}



