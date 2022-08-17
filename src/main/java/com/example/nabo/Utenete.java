package com.example.nabo;

import com.almasb.fxgl.core.collection.Array;

import java.util.ArrayList;

public class Utenete {
private String  Username;
private  String Password;
private ArrayList< String> tipo= new ArrayList<>();

    public Utenete(String username, String password, ArrayList<String> tipo) {
        Username = username;
        Password = password;
        this.tipo = tipo;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public ArrayList<String> getTipo() {
        return tipo;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setTipo(ArrayList<String> tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Utenete{" +
                "Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
