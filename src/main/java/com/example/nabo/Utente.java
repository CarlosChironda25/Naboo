package com.example.nabo;

import java.util.ArrayList;

public class Utente {
public String  Username;
public   String Password;

    public boolean isAdmin() {
        return Admin;
    }

    public void setAdmin(boolean admin) {
        Admin = admin;
    }

    public  boolean Admin;
public ArrayList< String> tipo= new ArrayList<>();

    public Utente(String username, String password, ArrayList<String> tipo) {
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
                ", Admi='" + Admin + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
