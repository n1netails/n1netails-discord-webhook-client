package com.n1netails.n1netails.discord.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Discord Webhook File
 * @author shahid foy
 */
@Getter
@Setter
public class WebhookFile {

    private String filename;
    private byte[] data;

    /**
     * Webhook File Constructor
     */
    public WebhookFile() {}

    /**
     * Webhook File Constructor
     * @param filename file name
     * @param data file data
     */
    public WebhookFile(String filename, byte[] data) {
        this.filename = filename;
        this.data = data;
    }
}
