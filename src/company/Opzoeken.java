package company;

public class Opzoeken {
    private boolean inventaris;
    private String merk;
    private boolean winstVerlies;

    public Opzoeken(boolean inventaris, String merk, boolean winstVerlies) {
        this.inventaris = inventaris;
        this.merk = merk;
        this.winstVerlies = winstVerlies;
    }

//    public boolean kenmerkopzoeken(boolean inventaris, String merk, boolean winstVerlies){
//        for (Inventaris inv : Inventaris.opslag){
//            if (merk.equalsIgnoreCase(inv.getMerk())){
//                return inventaris ^ winstVerlies;
//            }
//        }
//        return false;
//    }
}



