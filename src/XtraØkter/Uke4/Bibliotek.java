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
        return boekerLedig;
    }

    public void setBoekerLedig(ArrayList<BibliotekBestand> boekerLedig) {
        this.boekerLedig = boekerLedig;
    }

    public ArrayList<BibliotekBestand> getBoekerUtlaan() {
        return boekerUtlaan;
    }

    public void setBoekerUtlaan(ArrayList<BibliotekBestand> boekerUtlaan) {
        this.boekerUtlaan = boekerUtlaan;
    }

    public static void main(String[] args) {
        BibliotekBestand bibBok;
        Bibliotek bergenFolkeBib = new Bibliotek();

        //System.out.println("Bergen Bibliotek total bestand: ");
        //for( var bestand : BibliotekBestand.values())
        //    System.out.print(" "+bestand);
        System.out.println(" ");
        System.out.println("Bergen Bibliotek ledige boeker:"+ bergenFolkeBib.getBoekerLedig());
        System.out.println("Bergen Bibliotek utlaante boeker: "+bergenFolkeBib.getBoekerUtlaan());


        //for(var ledig: bergenFolkeBib.getBoekerUtlaan())
        //    System.out.print(" " + ledig);


    }
}
