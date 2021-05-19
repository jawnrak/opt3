package company;

import java.util.ArrayList;

public class Systeem {
    private ArrayList<Inventaris> inventarises;
    private ArrayList<Account> accounts;

    public Systeem() {
        this.inventarises = new ArrayList<>();
        inventarises.add(new Inventaris("Zolder"));
        inventarises.add(new Inventaris("Woonkamer"));
        inventarises.add(new Inventaris("Slaapkamer"));
        this.accounts = new ArrayList<>();
    }

    public ArrayList<Inventaris> getInventarises() {
        return inventarises;
    }

    public Inventaris getFromLocatie(String naam){
        for (Inventaris inventaris : inventarises) {
            if (inventaris.getLocatie().toLowerCase().equals(naam.toLowerCase())){
                return inventaris;
            }
        }
        return null;
    }

    public boolean toegangInventaris(String inlog, String wachtwo) {
        for (Account toe : accounts) {
            if (inlog.equals(toe.getInlognaam()) && wachtwo.equals(toe.getWachtwoord())) {
                return true;
            }
        }
        return false;
    }
    public boolean toegangWinstVerlies (String inlog, String wachtwo){
        for (Account toe : accounts) {
            if (inlog.equals(toe.getInlognaam()) && wachtwo.equals(toe.getWachtwoord())) {
                if (inlog.equals("Administrator") || inlog.equals("BoekhouderWerker")) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

//    public static Systeem getInstance(){
//
//    }
}
