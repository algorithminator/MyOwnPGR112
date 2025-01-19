package XtraØkter.Uke4;

import java.util.ArrayList;
import java.util.EnumSet;

public class Bibliotek {
    /*
    Utfordring : Inisialiser Biblioteksobjekt med ALLE bøker fra bestand
    https://www.baeldung.com/java-enum-values-to-list#using-the-enumsetallof-method
     */
    private ArrayList<BibliotekBestand> boekerLedig = new ArrayList<>(EnumSet.allOf(BibliotekBestand.class));
    private ArrayList<BibliotekBestand>  boekerUtlaan = new ArrayList<>();



    public ArrayList<BibliotekBestand> getBoekerLedig() {
        System.out.println("Bergen Bibliotek ledige boeker:"+ this.boekerLedig);
        return this.boekerLedig;
    }

    public void returnerBok(BibliotekBestand bibBok) {
        this.boekerLedig.add(bibBok);
        this.boekerUtlaan.remove(bibBok);
    }

    public ArrayList<BibliotekBestand> getBoekerUtlaan() {
        System.out.println("Bergen Bibliotek utlaante boeker: "  + this.boekerUtlaan);
        return this.boekerUtlaan;
    }

    public boolean laanBok(BibliotekBestand bibBok) {
        if (this.soekLedigBook(bibBok)) {
            this.boekerLedig.remove(bibBok);
            this.boekerUtlaan.add(bibBok);

        return true;
        }
        else {
            System.out.println("Bok " + bibBok + " kan ikke laanes.");
            return false;
        }
    }
    public boolean soekLedigBook(BibliotekBestand bibBok){
        boolean erLedig = false;
        for(var b: this.boekerLedig)
            if(bibBok == b) erLedig = true;
        System.out.println(bibBok + " er ledig: " + erLedig);
        return erLedig;

    }


}
