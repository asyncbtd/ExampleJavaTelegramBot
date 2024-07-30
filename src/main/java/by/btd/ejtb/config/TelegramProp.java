package by.btd.ejtb.config;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "telegram.bot")
public class TelegramProp {

    @NotNull
    private String token;

    @NotNull
    private String name;
}
