package com.n1netails.n1netails.discord.model;

import java.util.List;

public class WebhookMessageBuilder {
    private String content;
    private String username;
    private String avatarUrl;
    private boolean tts;
    private List<Embed> embeds;
    private List<Component> components;
    private List<WebhookFile> files;

    public WebhookMessageBuilder withContent(String content) {
        this.content = content;
        return this;
    }

    public WebhookMessageBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public WebhookMessageBuilder withAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    public WebhookMessageBuilder withTts(boolean tts) {
        this.tts = tts;
        return this;
    }

    public WebhookMessageBuilder withEmbeds(List<Embed> embeds) {
        this.embeds = embeds;
        return this;
    }

    public WebhookMessageBuilder withComponents(List<Component> components) {
        this.components = components;
        return this;
    }

    public WebhookMessageBuilder withFiles(List<WebhookFile> files) {
        this.files = files;
        return this;
    }

    public WebhookMessage build() {
        WebhookMessage message = new WebhookMessage();
        message.setContent(content);
        message.setUsername(username);
        message.setAvatar_url(avatarUrl);
        message.setTts(tts);
        message.setEmbeds(embeds);
        message.setComponents(components);
        message.setFiles(files);
        return message;
    }
}
