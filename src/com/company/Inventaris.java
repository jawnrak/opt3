package com.company;

import java.util.ArrayList;

public class Inventaris {
    private String naam;
    private String merk;
    public static ArrayList<Inventaris> opslag = new ArrayList<>();

    public Inventaris(String naam, String merk){
        this.naam = naam;
        this.merk = merk;
        opslag.add(this);
    }

    public String getNaam(){return this.naam;}
    public String getMerk(){return this.merk;}

}
