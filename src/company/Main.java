package company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Systeem systeem = new Systeem();
        systeem.getAccounts().add(new Account("Medewerker", "ToegangInventaris69"));
        systeem.getAccounts().add(new Account("Administrator", "GeheimWachtwoord22"));
        systeem.getAccounts().add(new Account("BoekhouderWerker", "WachtwoordBoekhouder44"));
        systeem.getFromLocatie("Woonkamer").getOpslag().add(new Product("Air jordan 1 mid black red", "Air Jordan", "Zwart rood", "55232", 2, 160.00));
        Scanner s = new Scanner(System.in);
        System.out.println("Gebruikersnaam: ");
        String gebruikersnaam = s.nextLine();
        System.out.println("Wachtwoord: ");
        String wachtwoord = s.nextLine();
        try {
            while (true) {
                if (systeem.toegangInventaris(gebruikersnaam,wachtwoord)){
                    loop(systeem, systeem.toegangWinstVerlies(gebruikersnaam, wachtwoord));
                }
            }
        } catch (InputMismatchException i) {
            System.out.println("Invalide input");
        }
    }

    public static void loop(Systeem systeem, boolean toegangWL){
        System.out.println("Selecteer een optie?");
        System.out.println("1) Voeg een product toe");
        System.out.println("2) Print inventaris van een locatie");
        System.out.println("3) Winst-verlies schema per maand");
        System.out.println("4) Winst-verlies schema per jaar");
        System.out.println("5) Verkocht product");
        System.out.println("6) Kenmerk opzoeken");
        System.out.print("Uw keuze: ");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()){
            case 1 :
                productToevoegen(systeem);
                break;
            case 2 :
                locatieInventaris(systeem);
                break;
            case 3 :
                if(toegangWL) {
                    winstVerliesMaand();
                }
                else System.out.println("geen toegang");
                break;
            case 4 :
                if (toegangWL) {
                    winstVerliesJaar();
                }else System.out.println("geen toegang");
                break;
            case 5 :
                verkochtProduct(systeem);
                break;
            case 6 :
                kenmerkOpzoeken(systeem);
                break;
        }
    }


    private static void productToevoegen(Systeem systeem) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Typ de naam van het product in: ");
        String naam = sc.nextLine();
        System.out.print("Typ het merk van het product in: ");
        String merk = sc.nextLine();
        System.out.print("Typ de kleur van het product in: ");
        String kleur = sc.nextLine();
        System.out.print("Typ de productcode van het product in: ");
        String productcode = sc.nextLine();
        System.out.print("Voer de aantal in: ");
        Integer aantal = sc.nextInt();
        System.out.print("Wat is de inkoopprijs: ");
        Double inkoopprijs = sc.nextDouble();
        System.out.print("Kies op welk locatie het product is: \n" +
                "1) Zolder \n" +
                "2) Woonkamer \n" +
                "3) Slaapkamer \n");
         Integer getal = sc.nextInt();
         String locatie = getal==1? "Zolder": getal==2? "Woonkamer": getal==3? "Slaapkamer": null;
         if(locatie != null) {
             Inventaris inventaris = systeem.getFromLocatie(locatie);
             inventaris.getOpslag().add(new Product(naam, merk, kleur, productcode, aantal, inkoopprijs));
         }


    }
    private static void locatieInventaris(Systeem systeem) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Kies op welk locatie het product is: \n" +
                "1) Zolder \n" +
                "2) Woonkamer \n" +
                "3) Slaapkamer \n");
        Integer getal = sc.nextInt();
        String locatie = getal == 1 ? "Zolder" : getal == 2 ? "Woonkamer" : getal == 3 ? "Slaapkamer" : null;
        if (locatie != null) {
            Inventaris inventaris = systeem.getFromLocatie(locatie);
            for(Product pro : inventaris.getOpslag()){
                if (pro != null) {
                    System.out.println(pro.toString());
                }
            }
        }
    }

    private static void winstVerliesMaand(){

    }

    private static void winstVerliesJaar(){

    }

    private static void verkochtProduct(Systeem systeem){
        Scanner sc = new Scanner(System.in);
        System.out.print("Kies op welk locatie het product is: \n" +
                "1) Zolder \n" +
                "2) Woonkamer \n" +
                "3) Slaapkamer \n");
        Integer getal = sc.nextInt();
        String locatie = getal == 1 ? "zolder" : getal == 2 ? "woonkamer" : getal == 3 ? "slaapkamer" : null;
        if (locatie != null) {
            Inventaris inventaris = systeem.getFromLocatie(locatie);
            for(Product pro : inventaris.getOpslag()){
                if (pro != null) {
                    System.out.println(pro.toString());
                }
            }
            sc.nextLine();
            System.out.println("Geef productcode op: ");
            String productZoek = sc.nextLine();
            System.out.println("Geef verkoopprijs in format xx.x : ");
            Double verkoopprijs = sc.nextDouble();
            try {
                inventaris.verkoop(productZoek, verkoopprijs);
            }catch(Exception e){
                System.out.println("Ongeldige waarde voor prijs");
            }
                //voor meer , voor hvl verkocht
        }
    }

    private static void kenmerkOpzoeken(Systeem systeem){
        System.out.println("Welk kenmerk wil je opzoeken?\n" +
                "1) Naam\n" +
                "2) Merk\n" +
                "3) Kleur\n" +
                "4) Productcode\n" +
                "Invoer: ");
        Scanner sc = new Scanner(System.in);
        int keuze = sc.nextInt();
        System.out.println("Waarde: ");
        String waarde = sc.nextLine();
        ArrayList<Product> result = new ArrayList<>();
        for (Inventaris inventaris : systeem.getInventarises()) {
            for (Product product : inventaris.getOpslag()) {
                switch ((keuze)){
                    case 1:
                        if (product.getNaam().equals(waarde)){
                            result.add(product);
                        }
                    case 2:
                        if (product.getMerk().equals(waarde)){
                            result.add(product);
                        }
                    case 3:
                        if (product.getKleur().equals(waarde)){
                            result.add(product);
                        }
                    case 4:
                        if (product.getProductcode().equals(waarde)){
                            result.add(product);
                        }
                }
            }

        }

        for(Product pro : result){
            System.out.println(pro.toString());
        }


    }

}
