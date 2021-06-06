package company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Opslaglocatie {
    private String locatie;
    private ArrayList<Product> opslag = new ArrayList<>();
    private ArrayList<Product> verkocht = new ArrayList<>();

    public ArrayList<Product> getOpslag() {
        return opslag;
    }
    
    public Opslaglocatie(String locatie) {
        this.locatie = locatie;
    }
    public String getLocatie(){return this.locatie;}

    public Product getProductBijCode(String productcode, ArrayList <Product> lijst){
        for (Product product : lijst) {
            if (product.getProductcode().equals(productcode)){
                return product;
            }
        }
        return null;
    }

    public void verkoop(String productZoek, Double verkoopprijs, LocalDate date){
        Product p = this.getProductBijCode(productZoek, opslag);
        p.setDate(date);
        p.EentjeVerkocht();

        if (p.getAantal()== 0) {
            this.getOpslag().remove(p);
        }

        p.setVerkoopprijs(verkoopprijs);
        for(Product pr : verkocht){
            if(pr.getProductcode().equals(productZoek)){
                return;
            }
        }
        verkocht.add(p);
    }

    public Double berekenWinstMaand(int maand, int jaar){
        Double result = 0D;

        for(Product p : verkocht){
            if(p.getMaand()==maand && p.getJaar() == jaar){
                result += p.getVerkoopprijs() - p.getInkoopprijs();
            }
        }
        return result;
    }

    public Double berekenWinstJaar(int jaar){
        Double result = 0D;
        for(Product p : verkocht){
            if(p.getJaar()==jaar){
                result += p.getVerkoopprijs() - p.getInkoopprijs();
            }
        }
        return result;
    }


}
