package com.n1netails.n1netails.discord;

/**
 * Discord Color Enum
 * @author shahid foy
 */
public enum DiscordColor {
    /**
     * Represents the RED color (hex: 15158332) used in Discord embeds.
     */
    RED("15158332"),
    /**
     * Represents the GREEN color (hex: 3066993) used in Discord embeds.
     */
    GREEN("3066993"),
    /**
     * Represents the BLUE color (hex: 3447003) used in Discord embeds.
     */
    BLUE("3447003"),
    /**
     * Represents the PURPLE color (hex: 10181046) used in Discord embeds.
     */
    PURPLE("10181046"),
    /**
     * Represents the ORANGE color (hex: 15105570) used in Discord embeds.
     */
    ORANGE("15105570"),
    /**
     * Represents the GOLD color (hex: 15844367) used in Discord embeds.
     */
    GOLD("15844367"),
    /**
     * Represents the GREY color (hex: 9807270) used in Discord embeds.
     */
    GREY("9807270"),
    /**
     * Represents the DARK_RED color (hex: 10038562) used in Discord embeds.
     */
    DARK_RED("10038562"),
    /**
     * Represents the DARK_GREEN color (hex: 5763719) used in Discord embeds.
     */
    DARK_GREEN("5763719"),
    /**
     * Represents the DARK_BLUE color (hex: 5793266) used in Discord embeds.
     */
    DARK_BLUE("5793266"),
    /**
     * Represents the BLACK color (hex: 2303786) used in Discord embeds.
     */
    BLACK("2303786"),
    /**
     * Represents the WHITE color (hex: 16777215) used in Discord embeds.
     */
    WHITE("16777215");

    private final String value;

    DiscordColor(String value) {
        this.value = value;
    }

    /**
     * Used to get the discord color value
     * @return return discord color value
     */
    public String getValue() {
        return value;
    }
}