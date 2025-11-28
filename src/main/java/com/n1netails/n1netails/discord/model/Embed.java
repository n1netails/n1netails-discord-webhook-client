package com.n1netails.n1netails.discord.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Discord Webhook Embed
 * @author shahid foy
 */
@Getter
@Setter
public class Embed {

    private String title;
    private String description;
    private String url;
    private String color;
    private Author author;
    private List<EmbedField> fields;
    private Footer footer;
    private Image image;
    private Thumbnail thumbnail;
    private String timestamp;

    /**
     * Discord Webhook Embed Constructor
     */
    public Embed() {}

    /**
     * Discord Webhook Author
     */
    @Getter
    @Setter
    public static class Author {
        private String name;
        private String url;
        private String icon_url;

        /**
         * Discord Webhook Author Constructor
         */
        public Author() {}
    }

    /**
     * Discord Webhook Footer
     */
    @Getter
    @Setter
    public static class Footer {
        private String text;
        private String icon_url;

        /**
         * Discord Webhook Footer Constructor
         */
        public Footer() {}
    }

    /**
     * Discord Webhook Embed Field
     */
    @Getter
    @Setter
    public static class EmbedField {
        private String name;
        private String value;
        private boolean inline;

        /**
         * Discord Webhook Embed Field Constructor
         */
        public EmbedField() {}
    }

    /**
     * Discord Webhook Image
     */
    @Getter
    @Setter
    public static class Image {
        private String url;

        /**
         * Discord Webhook Image Constructor
         */
        public Image() {}
    }

    /**
     * Discord Webhook Thumbnail
     */
    @Getter
    @Setter
    public static class Thumbnail {
        private String url;

        /**
         * Discord Webhook Thumbnail Constructor
         */
        public Thumbnail() {}
    }
}
