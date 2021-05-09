package com.company;
import org.junit.Assert;
import org.junit.Test;

public class ToegangTests {
    @Test
    public void toegang () {
        //medewerken , toegang inventaris
        //financeteam , toegang inventaris en winst-verlies overzicht.

        String inlognaamMedewerker = "MedewerkerJan";
        String wachtwoordMedewerker = "ToegangInventaris69";
        String inlognaamSanderBV = "SanderBV";
        String wachtwoordSanderBV = "SanderBVinlogWachtwoord2";
        String inlognaamAdmin = "administrator";
        String wachtwoordAdmin = "GeheimWachtwoord22";
        String inlognaamBoekhouder = "BoekhouderWerker";
        String wachtwoordBoekhouder = "WachtwoordBoekhouder44";

        Toegang to = new Toegang("MedewerkerJan", "ToegangInventaris69");
        new Toegang("administrator", "GeheimWachtwoord22");
        new Toegang("BoekhouderWerker", "WachtwoordBoekhouder44");

        Assert.assertTrue(to.toegangInventaris(inlognaamMedewerker, wachtwoordMedewerker));
        Assert.assertFalse(to.toegangInventaris(inlognaamSanderBV,wachtwoordSanderBV));
        Assert.assertTrue(to.toegangInventaris(inlognaamAdmin, wachtwoordAdmin));
        Assert.assertTrue(to.toegangInventaris(inlognaamBoekhouder, wachtwoordBoekhouder));
        Assert.assertTrue(to.toegangWinstVerlies(inlognaamAdmin, wachtwoordAdmin));
        Assert.assertTrue(to.toegangWinstVerlies(inlognaamBoekhouder, wachtwoordBoekhouder));
//test of het toegang heeft tot inventaris en dan nog een test voor winstverlies overzicht
        //     Assert.assertTrue();
    }
}

