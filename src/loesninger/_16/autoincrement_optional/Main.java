package loesninger._16.autoincrement_optional;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Program p = new Program();
        try {
            p.run();
        } catch (SQLException e) {
            System.out.println("SQL exception caught:"+e.getMessage());
            e.printStackTrace();
        }
    }
}
