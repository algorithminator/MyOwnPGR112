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
                var x = 4 /0;
            }

        } catch (FileNotFoundException e) {
            //System.out.println(e);
            System.out.println("Finner ikke filen. Vennligst sjekk stien + fil");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (myScanner != null) myScanner.close();
        }
    }
}
