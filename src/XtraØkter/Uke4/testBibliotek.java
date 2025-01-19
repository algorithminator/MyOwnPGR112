package XtraØkter.Uke4;

public class testBibliotek {

    public static void main(String[] args) {

        Bibliotek bergenFolkeBib = new Bibliotek();
        bergenFolkeBib.getBoekerLedig();
        bergenFolkeBib.laanBok(BibliotekBestand.MOMO);
        bergenFolkeBib.laanBok(BibliotekBestand.KARDEMOMMEBY);
        bergenFolkeBib.laanBok(BibliotekBestand.MOMO);
        bergenFolkeBib.getBoekerUtlaan();

        boolean b = bergenFolkeBib.soekLedigBook(BibliotekBestand.BERLINERPOPLENE);
        //System.out.println("Bok er ledig: " + b);
        //b = bergenFolkeBib.soekLedigBook(BibliotekBestand.MOMO);
        //System.out.println("Bok er ledig: " + b);


        Bibliotek fyllingsdalenBib = new Bibliotek();

        fyllingsdalenBib.laanBok(BibliotekBestand.MOMO);
        fyllingsdalenBib.laanBok(BibliotekBestand.MOMO);



    }
}
