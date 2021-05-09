package com.company;
import java.util.ArrayList;

public class Toegang {
    public static ArrayList<Toegang> accounts = new ArrayList<>();
    private String inlognaam;
    private String wachtwoord;


    public Toegang(String inlognaam, String wachtwoord) {
        this.inlognaam = inlognaam;
        this.wachtwoord = wachtwoord;
        accounts.add(this);
    }

    public String getInlognaam() { return this.inlognaam; }

    public String getWachtwoord() { return this.wachtwoord; }

    public boolean toegangInventaris(String inlog, String wachtwo) {
        for (Toegang toe : Toegang.accounts) {
            if (inlog.equals(toe.getInlognaam()) && wachtwo.equals(toe.getWachtwoord())) {
                return true;
            }
        }
        return false;
    }
    public boolean toegangWinstVerlies (String inlog, String wachtwo){
        for (Toegang toe : Toegang.accounts) {
            if (inlog.equals(toe.getInlognaam()) && wachtwo.equals(toe.getWachtwoord())) {
                if (inlog.equals("administrator") || inlog.equals("BoekhouderWerker")) {
                    return true;
                }
            }
        }
        return false;
    }
}



