package com.n1netails.n1netails.discord.model;

import java.util.List;

public class ComponentBuilder {
    private int type;
    private Integer style;
    private String label;
    private Component.Emoji emoji;
    private String customId;
    private String url;
    private Boolean disabled;
    private List<Component> components;

    public ComponentBuilder withType(int type) {
        this.type = type;
        return this;
    }

    public ComponentBuilder withStyle(Integer style) {
        this.style = style;
        return this;
    }

    public ComponentBuilder withLabel(String label) {
        this.label = label;
        return this;
    }

    public ComponentBuilder withEmoji(Component.Emoji emoji) {
        this.emoji = emoji;
        return this;
    }

    public ComponentBuilder withCustomId(String customId) {
        this.customId = customId;
        return this;
    }

    public ComponentBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public ComponentBuilder withDisabled(Boolean disabled) {
        this.disabled = disabled;
        return this;
    }

    public ComponentBuilder withComponents(List<Component> components) {
        this.components = components;
        return this;
    }

    public Component build() {
        Component component = new Component();
        component.setType(type);
        component.setStyle(style);
        component.setLabel(label);
        component.setEmoji(emoji);
        component.setCustom_id(customId);
        component.setUrl(url);
        component.setDisabled(disabled);
        component.setComponents(components);
        return component;
    }
}
