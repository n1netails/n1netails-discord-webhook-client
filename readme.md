# N1ne Tails 
***
<div align="center">
  <img src="https://raw.githubusercontent.com/n1netails/n1netails/refs/heads/main/n1netails_icon_transparent.png" alt="N1ne Tails" width="500" style="display: block; margin: auto;"/>
</div>

[![License: AGPL v3](https://img.shields.io/badge/License-AGPL%20v3-blue.svg)](LICENSE)

# Discord Webhook Client
***
N1ne Tails is an open-source project that provides practical alerts and monitoring for applications. 
Use the N1ne Tails Discord Webhook Client to easily send webhook messages to a discord server.

## How to set up a discord server
Use the following documents to create a discord server and discord webhooks. N1ne Tails Discord Webhook Client will 
utilize the discord webhook to the target discord server.

### Create discord server
https://support.discord.com/hc/en-us/articles/204849977-How-do-I-create-a-server

### Create discord webhook
https://support.discord.com/hc/en-us/articles/228383668-Intro-to-Webhooks

## Install
***
Install the discord webhook client by adding the following dependency:
```xml
<dependency>
    <groupId>com.n1ne</groupId>
    <artifactId>n1netails-discord-webhook-client</artifactId>
    <version>{input version}</version>
</dependency>
```

## Configure
***
Here is how you can configure the project for different frameworks

### Spring Boot
Add the following beans to your spring boot application:

```java
import api.discord.n1netails.com.n1ne.n1netails.discord.DiscordWebhookClient;
import internal.discord.n1netails.com.n1ne.n1netails.discord.DiscordWebhookClientImpl;
import service.discord.n1netails.com.n1ne.n1netails.discord.WebhookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiscordWebhookConfig {

    @Bean
    public WebhookService webhookService() {
        return new WebhookService();
    }

    @Bean
    public DiscordWebhookClient discordWebhookClient(WebhookService service) {
        return new DiscordWebhookClientImpl(service);
    }
}
```

### Java

```java
import internal.discord.n1netails.com.n1ne.n1netails.discord.DiscordWebhookClientImpl;
import service.discord.n1netails.com.n1ne.n1netails.discord.WebhookService;

WebhookService service = new WebhookService();
DiscordWebhookClient client = new DiscordWebhookClientImpl(service);
```

## Use
***
```java
import api.discord.n1netails.com.n1ne.n1netails.discord.DiscordWebhookClient;
import com.n1ne.n1netails.discord.dto.WebhookMessage;
import internal.discord.n1netails.com.n1ne.n1netails.discord.DiscordWebhookClientImpl;
import service.discord.n1netails.com.n1ne.n1netails.discord.WebhookService;

public class ExampleService {
    private final DiscordWebhookClient webhookClient;

    public ExampleService() {
        this.webhookClient = new DiscordWebhookClientImpl(new WebhookService());
    }

    public void webhookExample(String content) {
        WebhookMessage message = new WebhookMessage(content);
        // replace with your discord webhook url
        String webhookUrl = "https://discord.com/api/webhooks/xxx/yyy";
        webhookClient.sendMessage(webhookUrl, message);
    }
}
```

## Customize Webhook Message
***
Discord webhook resource:
https://discord.com/developers/docs/resources/webhook

Send customized webhooks by utilizing the n1netails Pojo's 
- `WebhookMessage`
- `Embed`
  - `Footer`
  - List of `EmbedField`

Example:
```java
import api.discord.n1netails.com.n1ne.n1netails.discord.DiscordWebhookClient;
import com.n1ne.n1netails.discord.dto.WebhookMessage;
import internal.discord.n1netails.com.n1ne.n1netails.discord.DiscordWebhookClientImpl;
import service.discord.n1netails.com.n1ne.n1netails.discord.WebhookService;

public class ExampleService {
    private final DiscordWebhookClient webhookClient;

    public ExampleService() {
        this.webhookClient = new DiscordWebhookClientImpl(new WebhookService());
    }

    public void webhookExample(String content) {
        Embed embed = new Embed();
        embed.setTitle("Build Notification");
        embed.setDescription("The build has succeeded ✅");
        embed.setColor("65280");

        WebhookMessage msg = new WebhookMessage();
        msg.setUsername("CI Bot");
        msg.setContent("Deployment update");
        msg.setEmbeds(List.of(embed));

        // replace with your discord webhook url
        String webhookUrl = "https://discord.com/api/webhooks/xxx/yyy";
        webhookClient.sendMessage(webhookUrl, msg);
    }
}
```

# Develop
***
## Build
Build the project using the following command
```bash
mvn clean install
```
