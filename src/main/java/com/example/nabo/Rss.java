package com.example.nabo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.almasb.fxgl.core.collection.Array;
import com.rometools.rome.feed.synd.SyndContent;
import org.xml.sax.InputSource;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;



public class Rss {
private static Array< Notizia>list= new Array<>();
    public static void main(String[] args) {

        System.out.println("Esempio libreria Rome RSS: dati ANSA");

        String sourceURL = "https://www.ansa.it/sito/ansait_rss.xml";

        try {
            URL feedUrl = new URL(sourceURL);

            SyndFeedInput input = new SyndFeedInput();

            try {
                SyndFeed feed = input.build(new InputSource(feedUrl.openStream()));

                List<SyndEntry> entries = feed.getEntries();

                Iterator<SyndEntry> itEntries = entries.iterator();
                while (itEntries.hasNext()) {

                    SyndEntry entry = itEntries.next();
                    //Date tempo, String title, String link,SyndContent discrizione, String autore, SyndFeed fonte
                   Notizia notizia =new Notizia((Date) entry.getPublishedDate(),entry.getTitle(),entry.getLink(),entry.getDescription(),entry.getAuthor(), entry.getSource());
                    Gson gson4 = new GsonBuilder().setPrettyPrinting().create();
                    String jsonString = gson4.toJson(notizia);
                    FileWriter fileWriter = new FileWriter("src/main/resources/com/example/nabo/Info-Notizie.json");
                    fileWriter.println(jsonString);
                    // .write(jsonString);
                    fileWriter.close();



                }
            } catch (IllegalArgumentException | FeedException | IOException e) {
                // Errore lettura feed
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            // Errore indirizzo e accesso ai feed
            e.printStackTrace();
        }

    }

}
