package by.btd.ejtb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Slf4j
@Component
public class BotInitializer {

    final BotHandlers botHandlers;

    public BotInitializer(BotHandlers botHandlers) {
        this.botHandlers = botHandlers;
    }

    @EventListener({ContextRefreshedEvent.class})
    public void initializer() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot((LongPollingBot) botHandlers);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }
    }
}