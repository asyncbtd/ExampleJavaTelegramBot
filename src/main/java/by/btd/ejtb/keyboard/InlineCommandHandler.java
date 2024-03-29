package by.btd.ejtb.keyboard;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class InlineCommandHandler {

    public static void addTets(SendMessage sendMessage) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("tyjgrf 1");
        inlineKeyboardButton1.setUrl("https://www.youtube.com/");
        inlineKeyboardButton1.setCallbackData("Button \"Тык\" has been pressed");

        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("tyjgrf 2");
//        inlineKeyboardButton2.setUrl("https://habr.com/ru/articles/418905/");
        inlineKeyboardButton2.setCallbackData("testcallbackmessage");

        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton3.setText("tyjgrf 3");
        inlineKeyboardButton3.setSwitchInlineQuery("X~~~~E@EASDZXCX");
        inlineKeyboardButton3.setCallbackData("CallFi4a");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();

        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow1.add(inlineKeyboardButton3);
        keyboardButtonsRow2.add(inlineKeyboardButton2);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);

        inlineKeyboardMarkup.setKeyboard(rowList);

        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
    }
}
