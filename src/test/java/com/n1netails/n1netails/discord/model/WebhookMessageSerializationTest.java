package com.n1netails.n1netails.discord.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebhookMessageSerializationTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testSerializationWithComponentsAndVideo() throws JsonProcessingException {
        Embed.Video video = new Embed.Video();
        video.setUrl("http://example.com/video.mp4");

        Embed embed = new EmbedBuilder()
                .withTitle("Test Title")
                .withVideo(video)
                .build();

        Component button = new ComponentBuilder()
                .withType(Component.BUTTON)
                .withStyle(Component.LINK)
                .withLabel("Click Me")
                .withUrl("http://example.com")
                .build();

        Component actionRow = new ComponentBuilder()
                .withType(Component.ACTION_ROW)
                .withComponents(Collections.singletonList(button))
                .build();

        WebhookMessage message = new WebhookMessageBuilder()
                .withContent("Test Content")
                .withEmbeds(Collections.singletonList(embed))
                .withComponents(Collections.singletonList(actionRow))
                .build();

        String json = objectMapper.writeValueAsString(message);

        assertTrue(json.contains("\"content\":\"Test Content\""));
        assertTrue(json.contains("\"video\":{\"url\":\"http://example.com/video.mp4\"}"));
        assertTrue(json.contains("\"components\":[{\"type\":1"));
        assertTrue(json.contains("\"type\":2"));
        assertTrue(json.contains("\"label\":\"Click Me\""));
        assertTrue(json.contains("\"style\":5"));
        assertTrue(json.contains("\"url\":\"http://example.com\""));
    }
}
