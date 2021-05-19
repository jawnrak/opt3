package company;

public class Account {
    private String inlognaam;
    private String wachtwoord;


    public Account(String inlognaam, String wachtwoord) {
        this.inlognaam = inlognaam;
        this.wachtwoord = wachtwoord;
    }

    public String getInlognaam() { return this.inlognaam; }

    public String getWachtwoord() { return this.wachtwoord; }


}



