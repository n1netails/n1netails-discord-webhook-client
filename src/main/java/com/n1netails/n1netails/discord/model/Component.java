package com.n1netails.n1netails.discord.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Discord Message Component
 * @author shahid foy
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Component {

    // Component Types
    public static final int ACTION_ROW = 1;
    public static final int BUTTON = 2;

    // Button Styles
    public static final int PRIMARY = 1;
    public static final int SECONDARY = 2;
    public static final int SUCCESS = 3;
    public static final int DANGER = 4;
    public static final int LINK = 5;

    private int type;
    private Integer style;
    private String label;
    private Emoji emoji;
    private String custom_id;
    private String url;
    private Boolean disabled;
    private List<Component> components;

    /**
     * Discord Message Component Constructor
     */
    public Component() {}

    /**
     * Discord Webhook Emoji
     */
    @Getter
    @Setter
    public static class Emoji {
        private String id;
        private String name;
        private boolean animated;

        /**
         * Discord Webhook Emoji Constructor
         */
        public Emoji() {}
    }
}
