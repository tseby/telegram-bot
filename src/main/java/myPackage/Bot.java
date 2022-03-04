package myPackage;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi my_telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            my_telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }

    }

    public void sendMsg(Message function_message, String text_message) throws TelegramApiException {
        SendMessage send_message = new SendMessage();
        send_message.enableMarkdown(true);
        send_message.setChatId(function_message.getChatId().toString());
        send_message.setReplyToMessageId(function_message.getMessageId());
        send_message.setText(text_message);
        setBunttons(send_message);
        execute(send_message);
    }

    public void giveQuote(Message function_message) throws TelegramApiException {
        SendMessage send_quote = new SendMessage();
        Motivation motivational_quote = new Motivation();
        send_quote.setChatId(function_message.getChatId().toString());
        send_quote.setReplyToMessageId(function_message.getMessageId());
        send_quote.setText(motivational_quote.quote_randomizer());
        execute(send_quote);
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message incoming_message = update.getMessage();
        if (incoming_message != null && incoming_message.hasText()) {
            switch (incoming_message.getText()) {
                case "/help":
                    try {
                        sendMsg(incoming_message, "Я пока ничего не умею, но Лев сделает из меня" +
                                "что-то, чтобы сдать предмет Цифровой Практикум. А еще я написан на джава, использую Maven для зависимостей. ");
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case "/start":
                    try {
                        sendMsg(incoming_message, "I am a bot");
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case "/quote":
                    try {
                        giveQuote(incoming_message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                default:


            }
        }
    }

    public void setBunttons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardRow = new KeyboardRow();

        keyboardRow.add(new KeyboardButton("/help"));
        keyboardRow.add(new KeyboardButton("/start"));
        keyboardRow.add(new KeyboardButton("/quote"));

        keyboardRowList.add(keyboardRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

    }

    @Override
    public String getBotUsername() {
        return "why_do_you_care111Bot";
    }

    @Override
    public String getBotToken() {
        return "5228497619:AAEFc90zUxizF2kyTmdLTf2hOcG2REowKK8";
        //ha-ha whoops. 
    }
}
