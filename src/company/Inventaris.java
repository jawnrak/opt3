package company;

import java.util.ArrayList;

public class Inventaris {
    private String locatie;
    private ArrayList<Product> opslag = new ArrayList<>();
    private ArrayList<Product> verkocht = new ArrayList<>();

    public ArrayList<Product> getOpslag() {
        return opslag;
    }
    
    public Inventaris(String locatie) {
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

    public void verkoop(String productZoek, Double verkoopprijs){
        Product p = this.getProductBijCode(productZoek, opslag);
        if (p.getAantal()== 1) {
            this.getOpslag().remove(p);

        } else p.setAantal(p.getAantal() - 1);

        Product p2 = this.getProductBijCode(productZoek, verkocht);
        p2.setVerkoopprijs(verkoopprijs);
        if (p2 == null) {
            this.getOpslag().add(p2);
        } else p2.setAantal(p2.getAantal() + 1);
    }

    public Double berekenWinstMaand(Inventaris inventaris, int maand, int jaar){
        Double result = 0D;

        for(Product p : verkocht){
            if(p.getMaand()==maand && p.getJaar() == jaar){
                result += p.getVerkoopprijs() - p.getVerkoopprijs();
            }
        }
        return result;
    }

    public Double berekenWinstJaar(Inventaris inventaris, int jaar){
        Double result = 0D;
        for(Product p : verkocht){
            if(p.getJaar()==jaar){
                result += p.getVerkoopprijs() - p.getVerkoopprijs();
            }
        }
        return result;
    }


}
