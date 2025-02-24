package XtraOekter.Uke9.CodeAlong;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyFileReader {

    public void readWithTryCatchFinally(){
        File myFile = new File("files/australia.txt");
        System.out.println(myFile.getAbsolutePath());
        Scanner myScanner = null;
        try {
            myScanner = new Scanner(myFile);
            while (myScanner.hasNextLine()){
                System.out.println(myScanner.nextLine());

            }


        } catch (FileNotFoundException e) {

            System.out.println("Finner ikke filen. Vennligst sjekk stien + fil");
        }
        finally {
           if (myScanner != null) myScanner.close();
        }
    }

    public void readWithTryWithRessources(){
        File myFile = new File("files/australia.txt");
        System.out.println(myFile.getAbsolutePath());

        try(Scanner myScanner = new Scanner(myFile);) {

            while (myScanner.hasNextLine()){
                System.out.println(myScanner.nextLine());

            }


        } catch (FileNotFoundException e) {

            System.out.println("Finner ikke filen. Vennligst sjekk stien + fil");
        }

    }
    public void readWithThrow() throws FileNotFoundException{
        File myFile = new File("files/australia.txt");
        System.out.println(myFile.getAbsolutePath());

        try(Scanner myScanner = new Scanner(myFile);) {

            while (myScanner.hasNextLine()){
                System.out.println(myScanner.nextLine());

            }


        }

    }

}
