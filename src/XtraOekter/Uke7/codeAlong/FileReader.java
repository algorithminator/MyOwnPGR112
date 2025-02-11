package XtraOekter.Uke7.codeAlong;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public void dummyMethod(){
        File myFile = new File("eksempel.txt");
        try {
            Scanner myScanner = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
