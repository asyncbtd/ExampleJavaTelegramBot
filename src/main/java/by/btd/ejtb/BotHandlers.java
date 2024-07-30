package by.btd.ejtb;

import by.btd.ejtb.config.TelegramProp;
import by.btd.ejtb.handlers.CommandHandler;
import by.btd.ejtb.handlers.TextHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class BotHandlers extends TelegramLongPollingBot {

    private final TelegramProp telegramProp;

    @Override
    public String getBotToken() {
        return telegramProp.getToken();
    }

    @Override
    public String getBotUsername() {
        return telegramProp.getName();
    }

    @Override
    public void onUpdateReceived(Update update) {
        var commandHandler = new CommandHandler(telegramProp);
        var textHandler = new TextHandler(telegramProp);

        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (messageText.startsWith("/")) {
                log.info("Bot take message [{}] type: command [{}] from chatId [{}]", update.getMessage().getMessageId(), messageText, chatId);
                commandHandler.handler(update);
            } else {
                log.info("Bot take message [{}] type: text [{}] from chatId [{}]", update.getMessage().getMessageId(), messageText, chatId);
                textHandler.handler(update);
            }
        }
    }

    public synchronized void anyExecute(SendMessage sendMessage, Update update) {
        long chatId = update.getMessage().getChatId();

        CompletableFuture.runAsync(() -> {
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                log.error("Error when trying to send SendMessage to chat [{}], details: [{}]", chatId, e.getMessage());
            }
        });
    }

    public synchronized void anyExecute(SendPhoto sendPhoto, Update update) {
        long chatId = update.getMessage().getChatId();

        CompletableFuture.runAsync(() -> {
            try {
                execute(sendPhoto);
            } catch (TelegramApiException e) {
                log.error("Error when trying to send SendPhoto to chat [{}], details: [{}]", chatId, e.getMessage());
            }
        });
    }

    public synchronized void anyExecute(SendAnimation sendAnimation, Update update) {
        long chatId = update.getMessage().getChatId();

        CompletableFuture.runAsync(() -> {
            try {
                execute(sendAnimation);
            } catch (TelegramApiException e) {
                log.error("Error when trying to send SendAnimation to chat [{}], details: [{}]", chatId, e.getMessage());
            }
        });
    }
}
