package com.example.nabo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Prova {
    public   static Scanner Scan= new Scanner(System.in);
    public static void main(String[] args)  throws JsonIOException, IOException {
      /* ArrayList<String> tipo= new ArrayList<>();
       tipo.add("lettore");
       tipo.add("scrittore");
       tipo.add("abbonato");

          Utente utente= new Utente("Carlos","Carlos12",tipo);
            Gson gson = new Gson();
        String jsonParser =gson.toJson(utente);
                 System.out.println(jsonParser);
                 */
      Gson gson= new Gson();
        JsonReader leggi = new JsonReader(new FileReader("src/main/resources/com/example/nabo/Dati.json"));
        List<Utente> Utenti = gson.fromJson(leggi, (new TypeToken<List<Utente>>() {}).getType());

        System.out.println("inserisce username e password");
          String n= Scan.nextLine();
            for (Utente i: Utenti){

                   if( i.getUsername().equals(n) && i.getPassword().equals("Carlos12")  ){
                System.out.println("Giusto");
            } else System.out.println(" username sbagliata");


        }
    }
}
