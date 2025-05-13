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
    private Footer footer;
    private List<EmbedField> fields;

    /**
     * Discord Webhook Embed Constructor
     */
    public Embed() {}

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
}
