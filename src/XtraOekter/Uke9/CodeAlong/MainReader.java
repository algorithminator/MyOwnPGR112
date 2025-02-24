package XtraOekter.Uke9.CodeAlong;

import XtraOekter.Uke7.codeAlong.FileReader;

import java.io.FileNotFoundException;

public class MainReader {
    public static void main(String[] args) {
        MyFileReader myReader = new MyFileReader();
        // 1) try - catch -finally
        myReader.readWithTryCatchFinally();
        // 2) try - with ressources
        myReader.readWithTryWithRessources();
        // 3) throw -- BUT try -with ressources !!
        try {
            myReader.readWithThrow();
        } catch (FileNotFoundException e) {

            System.out.println("Finner ikke filen. Vennligst sjekk stien + fil");
        }


    }
}
