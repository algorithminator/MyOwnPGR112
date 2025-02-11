package XtraOekter.Uke7.codeAlong;

import java.io.FileNotFoundException;

public class MainReader {
    public static void main(String[] args) {
        FileReader myReader = new FileReader();
        myReader.dummyMethod();
        try {
            myReader.otherDummyMethod();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
