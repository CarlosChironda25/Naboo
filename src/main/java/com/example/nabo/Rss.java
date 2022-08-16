package com.example.nabo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.xml.sax.InputSource;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;

public class Rss {

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
                    System.out.println("\n[" + entry.getPublishedDate() + "] ");
                    System.out.println(entry.getTitle());
                    System.out.println(entry.getLink());

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
