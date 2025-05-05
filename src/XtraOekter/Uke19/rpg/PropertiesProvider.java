package XtraOekter.Uke19.rpg;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class PropertiesProvider {
    public static final Properties PROPS;
    private PropertiesProvider(){}

    static{
        PROPS = new Properties();
        try {
            PROPS.load(new FileInputStream("files/rpg.properties"));
        } catch (IOException e) {
            System.out.println("Unable to load properties:"+e.getMessage());
        }
    }

    public static class Main {

        public static void main(String[] args) throws SQLException {

            RPG rpg = new RPG();
            rpg.playGame();
            System.out.println("the end");

        }
    }
}
