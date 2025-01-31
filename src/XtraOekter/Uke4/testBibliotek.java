package XtraOekter.Uke4;

import java.util.ArrayList;

public class testBibliotek {

    public static void main(String[] args) {
        //1 init
        Bibliotek bergenFolkeBib = new Bibliotek();
        bergenFolkeBib.setBibNavn("Bergen Folkebibliotek");
        System.out.println(bergenFolkeBib.getBibNavn());
        bergenFolkeBib.getBoekerLedig();
        bergenFolkeBib.initBibliotek();
        bergenFolkeBib.getBoekerLedig();

        //2 testing
        assert bergenFolkeBib.getBibNavn().equalsIgnoreCase("Bergen Folkebibliotek") : "Nokke rart med navn setter/getter";

        //3 foerst test then code
        assert bergenFolkeBib.laanBok(BibliotekBestand.MOMO) == true : "Bok burde vaere ledig";
        assert bergenFolkeBib.laanBok(BibliotekBestand.MOMO) == false : "Bok burde vaere utlaant";

        //4 koded laanbok
        bergenFolkeBib.laanBok(BibliotekBestand.KARDEMOMMEBY);

        //5 test har vi utlaant boeke?
        ArrayList<BibliotekBestand> testUtlaant = new ArrayList<>();
        testUtlaant.add(BibliotekBestand.MOMO);
        testUtlaant.add(BibliotekBestand.KARDEMOMMEBY);
        assert bergenFolkeBib.getBoekerUtlaan().equals(testUtlaant) : "Feil i utlaan i Bergen bib";

        //6 foerst test then code
        assert bergenFolkeBib.returnerBok(BibliotekBestand.MOMO, "Bergen Folkebibliotek") == true : "Bok kan ikke leveres tilbake";


        //7 ny bib
        Bibliotek fyllingsdalenBib = new Bibliotek();
        fyllingsdalenBib.initBibliotek();
        fyllingsdalenBib.setBibNavn("Fyllingsdalen Bibliotek");
        fyllingsdalenBib.laanBok(BibliotekBestand.HOBBITEN);
        fyllingsdalenBib.returnerBok(BibliotekBestand.MOMO, "Fyllingsdalen Bibliotek");

        System.out.println(fyllingsdalenBib.getBibNavn());

        BibOmdoeper daNuBib = new BibOmdoeper();
        daNuBib.renameBib(fyllingsdalenBib);
        System.out.println(fyllingsdalenBib.getBibNavn());

        var x = 4;
        System.out.println(daNuBib.myBibMath(x));
        System.out.println(x);

    }
}
