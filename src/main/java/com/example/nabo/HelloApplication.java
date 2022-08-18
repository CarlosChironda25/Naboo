package com.example.nabo;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("NABOO");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
/*
echo "# Naboo" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/CarlosChironda25/Naboo.git
git push -u origin main
////
git remote add origin https://github.com/CarlosChironda25/Naboo.git
git branch -M main
 ssh-keygen -t ed25519 -C "carlosvasco.chironda@studio.unibo.it"


//
[{
  "Utente": [
    {
      "Username": " Davide ",
      "Password": "  Davide12",
      "Categoria": [
        {
          "Tipo": "Leitore"
        }
      ],
      "Username": " Carlos ",
      "Password": "  Carlos12",
      "Categoria": [
        {
          "Tipo": "Commetattore"
        }
      ],
      "Username": " Elena ",
      "Password": "  Elena12",
      "Categoria": [
        {
          "Tipo": "Generale"
        }
      ]
    }
  ],
  "Ammistrattore": [
    {
      "Username": "Elena",
      "Username": "Donatelli"
    }
  ],
  "Ammistrattore": [
    {
      "Username": "Davide",
      "Username": "Davide"
    }
  ]
}
  ]




 */