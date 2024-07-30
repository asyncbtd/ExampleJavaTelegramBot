package by.btd.ejtb.keyboard.reply;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CommandRK {

    public static void addKeyboardToStartCommand(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();

        row.add("1");
        row.add("2");
        row.add("3");

        keyboard.add(row);

        replyKeyboardMarkup.setKeyboard(keyboard);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
    }
}
