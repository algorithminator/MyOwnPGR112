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

    public void returnerBok(BibliotekBestand bibBok) {
        this.boekerLedig.add(bibBok);
        this.boekerUtlaan.remove(bibBok);
    }

    public ArrayList<BibliotekBestand> getBoekerUtlaan() {
        return boekerUtlaan;
    }

    public boolean laanBok(BibliotekBestand bibBok) {
        if (this.boekerLedig.contains(bibBok)) {
            this.boekerLedig.remove(bibBok);
            this.boekerUtlaan.add(bibBok);
        return true;
        }
        else {
            System.out.println("Bok " + bibBok + " er ikke ledig.");
            return false;
        }
    }

    public static void main(String[] args) {

        Bibliotek bergenFolkeBib = new Bibliotek();

        System.out.println("Bergen Bibliotek ledige boeker:"+ bergenFolkeBib.getBoekerLedig());
        System.out.println("Bergen Bibliotek utlaante boeker: "+bergenFolkeBib.getBoekerUtlaan());
        bergenFolkeBib.laanBok(BibliotekBestand.MOMO);
        System.out.println("Bergen Bibliotek utlaante boeker: "+bergenFolkeBib.getBoekerUtlaan());
        bergenFolkeBib.laanBok(BibliotekBestand.KARDEMOMMEBY);
        System.out.println("Bergen Bibliotek utlaante boeker: "+bergenFolkeBib.getBoekerUtlaan());
        bergenFolkeBib.laanBok(BibliotekBestand.MOMO);
        System.out.println("Bergen Bibliotek utlaante boeker: "+bergenFolkeBib.getBoekerUtlaan());



        //for(var ledig: bergenFolkeBib.getBoekerUtlaan())
        //    System.out.print(" " + ledig);


    }
}
