package com.example.nabo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NabooBot  extends  TelegramLongPollingBot{

    @Override
    public String getBotUsername() {
        return "SuperNaboobot";
    }

    @Override
    public String getBotToken() {
        return "5360815513:AAGzt5UB9mG7_b6sdp6KDOBXkJ5KLIEiYMU";
    }
    private List<Notizia> notizias;
    @Override
    public void onUpdateReceived(Update update) {
        if( update.hasMessage() && update.getMessage().hasText()){
            Message message= new Message();
            SendMessage sendmessage = new SendMessage(); // Create a SendMessage object with mandatory fields
            sendmessage.setChatId(update.getMessage().getChatId().toString());
            Gson gson= new Gson();
            try {
                JsonReader leggi = new JsonReader(new FileReader("src/main/resources/com/example/nabo/Info-Notizie.json"));
                notizias = gson.fromJson(leggi, (new TypeToken<List<Notizia>>() {}).getType());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            for( Notizia i: notizias )
                message.setText(i.getLink());

            try {
                execute(sendmessage); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
