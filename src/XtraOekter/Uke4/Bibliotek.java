package XtraOekter.Uke4;

import java.util.ArrayList;


public class Bibliotek {
    /*
    Utfordring : Inisialiser Biblioteksobjekt med ALLE bøker fra bestand
    https://www.baeldung.com/java-enum-values-to-list#using-the-enumsetallof-method
     */
    private  String bibNavn;

    public String getBibNavn() {
        return bibNavn;
    }

    public void setBibNavn(String bibNavn) {
        this.bibNavn = bibNavn;
    }

    private ArrayList<BibliotekBestand> boekerLedig = new ArrayList<>();
    private ArrayList<BibliotekBestand>  boekerUtlaan = new ArrayList<>();

    public void initBibliotek(){
        for (var boeker : BibliotekBestand.values())
            this.boekerLedig.add(boeker);

    }



    public ArrayList<BibliotekBestand> getBoekerLedig() {
        System.out.println("Bergen Bibliotek ledige boeker:"+ this.boekerLedig);
        return this.boekerLedig;
    }


    public ArrayList<BibliotekBestand> getBoekerUtlaan() {
        System.out.println("Bergen Bibliotek utlaante boeker: "  + this.boekerUtlaan);
        return this.boekerUtlaan;
    }


    public boolean laanBok(BibliotekBestand bibBok) {
        //if (this.soekLedigBook(bibBok)) {
        if(this.boekerLedig.contains(bibBok)){
            this.boekerLedig.remove(bibBok);
            this.boekerUtlaan.add(bibBok);

        return true;
        }
        else {
            System.out.printf("Bok %s kan ikke laanes.\n", bibBok);
            return false;
        }
    }
    public boolean returnerBok(BibliotekBestand bibBok, String navnArg) {
        if(this.boekerUtlaan.contains(bibBok) && this.getBibNavn().equals(navnArg)){
            this.boekerLedig.add(bibBok);
            this.boekerUtlaan.remove(bibBok);

            return true;
        }
        else {
            System.out.printf("Bok %s kan ikke returneres til bibliotek %s.\n", bibBok, navnArg);
            return false;
        }
    }
    //public boolean laanBok2(BibliotekBestand bibBok) {
    //return false;
    //}
    public boolean soekLedigBook(BibliotekBestand bibBok){
        boolean erLedig = false;
        for(var b: this.boekerLedig)
            if(bibBok == b) erLedig = true;
        System.out.println(bibBok + " er ledig: " + erLedig);
        return erLedig;

    }


}
