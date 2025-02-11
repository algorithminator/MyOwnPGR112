package XtraOekter.Uke7.codeAlong;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public void dummyMethod(){
        File myFile = new File("files/artister.txt");
        System.out.println(myFile.getAbsolutePath());
        Scanner myScanner = null;
        try {
            myScanner = new Scanner(myFile);
            while (myScanner.hasNextLine()){
                System.out.println(myScanner.nextLine());

            }

        } catch (FileNotFoundException e) {
            //System.out.println(e);
            System.out.println("Finner ikke filen. Vennligst sjekk stien + fil");
        }
        finally {
            if (myScanner != null) myScanner.close();
        }
    }
    public void otherDummyMethod() throws FileNotFoundException {
        File myFile = new File("fils/artister.txt");

        Scanner myScanner = new Scanner(myFile);
    }
}
