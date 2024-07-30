package by.btd.ejtb.handlers;

import by.btd.ejtb.BotHandlers;
import by.btd.ejtb.config.TelegramProp;
import by.btd.ejtb.services.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommandHandler {

    private final TelegramProp telegramProp;

    public void handler(Update update) {
        var unprocessedMessagesService = new UnprocessedMessagesService(telegramProp);
        String command = update.getMessage().getText().toLowerCase();

        switch (command) {
            case "/start" -> startCommand(update);
            case "/help" -> helpCommand(update);
            case "/test" -> testCommand(update);
            case "/exit" -> exitCommand(update);
            default -> unprocessedMessagesService.unprocessedMessage(update);
        }
    }

    private void startCommand(Update update) {
        var botHandlers = new BotHandlers(telegramProp);
        var sendMessage = new SendMessage();
        long chatId = update.getMessage().getChatId();

        sendMessage.enableMarkdownV2(true);
        sendMessage.setText(LocalService.getString("ru", "START_COMMAND"));
        sendMessage.setChatId(chatId);

        botHandlers.anyExecute(sendMessage, update);
    }

    private void helpCommand(Update update) {
        var botHandlers = new BotHandlers(telegramProp);
        var sendMessage = new SendMessage();
        long chatId = update.getMessage().getChatId();

        sendMessage.enableMarkdownV2(true);
        sendMessage.setText(LocalService.getString("ru", "HELP_COMMAND"));
        sendMessage.setChatId(chatId);

        var file = new InputFile(new File("src/main/resources/gif/fucked up monster.gif"));
        var sendDocument = new SendPhoto();

        sendDocument.setCaption("||ХУЙ||");
        sendDocument.setHasSpoiler(true);
        sendDocument.setChatId(chatId);
        sendDocument.setPhoto(file);

        botHandlers.anyExecute(sendDocument, update);
        botHandlers.anyExecute(sendMessage, update);
    }

    private void testCommand(Update update) {
        var botHandlers = new BotHandlers(telegramProp);
        var sendMessage = new SendMessage();
        long chatId = update.getMessage().getChatId();

        sendMessage.setText(LocalService.getString("test", "EXIT_TEXT"));
        sendMessage.setChatId(chatId);

        botHandlers.anyExecute(sendMessage, update);
    }

    private void exitCommand(Update update) {
        var botHandlers = new BotHandlers(telegramProp);
        var sendMessage = new SendMessage();
        long chatId = update.getMessage().getChatId();

        sendMessage.setChatId(chatId);
        sendMessage.setText(LocalService.getString("ru", "EXIT_COMMAND"));
        botHandlers.anyExecute(sendMessage, update);

        System.exit(0);
    }
}
