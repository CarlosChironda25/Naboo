package com.example.nabo;

import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import com.almasb.fxgl.core.collection.Array;
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
                for (Notizia i : list) {
                while (itEntries.hasNext()) {

                    SyndEntry entry = itEntries.next();
                    Notizia notizia =new Notizia(entry.getPublishedDate(),entry.getTitle(),entry.getLink(),
                              entry.getDescription(), entry.getAuthor(), entry.getSource());

                        // i.seNtTempo(entry.getPublishedDate());
                        //fileWriter.write(i.getTitle() );
                        System.out.println(i.toString());

                    }

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
