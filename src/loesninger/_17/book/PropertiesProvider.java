package loesninger._17.book;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider {
    public static final Properties PROPS;

    static{
        PROPS = new Properties();
        try {
            PROPS.load(new FileInputStream("files/books.properties"));
        } catch (IOException e) {
            System.out.println("Unable to load properties:"+e.getMessage());
        }
    }
}
