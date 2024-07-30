package by.btd.ejtb.handlers;

import by.btd.ejtb.BotHandlers;
import by.btd.ejtb.config.TelegramProp;
import by.btd.ejtb.services.UnprocessedMessagesService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;

@Slf4j
@Component
@RequiredArgsConstructor
public class TextHandler {

    private final TelegramProp telegramProp;

    public void handler(Update update) {
        var botHandlers = new BotHandlers(telegramProp);
        var unprocessedMessagesService = new UnprocessedMessagesService(telegramProp);
        String text = update.getMessage().getText().toLowerCase();

        switch (text) {
            case "sigma" -> sigmaText(update);
            case "женщина" -> womenText(update);
            default -> unprocessedMessagesService.unprocessedMessage(update);
        }
    }

    private void sigmaText(Update update) {
        var botHandlers = new BotHandlers(telegramProp);
        var sendPhoto = new SendPhoto();
        long chatId = update.getMessage().getChatId();

        var inputFile = new InputFile(new File(""));

        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(inputFile);
        sendPhoto.setHasSpoiler(true);

        botHandlers.anyExecute(sendPhoto, update);
    }

    private void womenText(Update update) {

    }
}
