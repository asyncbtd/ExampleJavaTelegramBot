package by.btd.ejtb.services;

import by.btd.ejtb.BotHandlers;
import by.btd.ejtb.config.TelegramProp;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;

@RequiredArgsConstructor
public class UnprocessedMessagesService {

    private final TelegramProp telegramProp;
    private static int counter;

    @SneakyThrows
    public void unprocessedMessage(Update update) {
        var botHandlers = new BotHandlers(telegramProp);
        long chatId = update.getMessage().getChatId();
        counter++;

        if (counter == 3) {
            var sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);
            sendMessage.setText("Чмо заебёшь");

            botHandlers.anyExecute(sendMessage, update);
        } else if (counter == 5) {
            var sendAnimation = new SendAnimation();
            var file = new File("src/main/resources/gif/fucked up monster.gif");
            var inputFile = new InputFile(file);

            sendAnimation.setHasSpoiler(true);
            sendAnimation.setChatId(chatId);
            sendAnimation.setAnimation(inputFile);
            counter = 0;

            botHandlers.anyExecute(sendAnimation, update);
        } else {
            var sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);
            sendMessage.setText("Я не розумію.");

            botHandlers.anyExecute(sendMessage, update);
        }
    }
}
