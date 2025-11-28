package com.n1netails.n1netails.discord.model;

import java.util.List;

public class EmbedBuilder {
    private String title;
    private String description;
    private String url;
    private String color;
    private Embed.Author author;
    private List<Embed.EmbedField> fields;
    private Embed.Footer footer;
    private Embed.Image image;
    private Embed.Thumbnail thumbnail;
    private String timestamp;

    public EmbedBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public EmbedBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public EmbedBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public EmbedBuilder withColor(String color) {
        this.color = color;
        return this;
    }

    public EmbedBuilder withAuthor(Embed.Author author) {
        this.author = author;
        return this;
    }

    public EmbedBuilder withFields(List<Embed.EmbedField> fields) {
        this.fields = fields;
        return this;
    }

    public EmbedBuilder withFooter(Embed.Footer footer) {
        this.footer = footer;
        return this;
    }

    public EmbedBuilder withImage(Embed.Image image) {
        this.image = image;
        return this;
    }

    public EmbedBuilder withThumbnail(Embed.Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public EmbedBuilder withTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Embed build() {
        Embed embed = new Embed();
        embed.setTitle(title);
        embed.setDescription(description);
        embed.setUrl(url);
        embed.setColor(color);
        embed.setAuthor(author);
        embed.setFields(fields);
        embed.setFooter(footer);
        embed.setImage(image);
        embed.setThumbnail(thumbnail);
        embed.setTimestamp(timestamp);
        return embed;
    }
}
