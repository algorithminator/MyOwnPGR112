package XtraOekter.Uke7.codeAlong;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public void dummyMethod(){
        File myFile = new File("artister.txt");
        System.out.println(myFile.getAbsolutePath());
        try {
            Scanner myScanner = new Scanner(myFile);
            while (myScanner.hasNextLine()){
                System.out.println(myScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            //System.out.println(e);
            System.out.println("Finner ikke filen. Vennligst sjekk stien + fil");
        }
    }
}
