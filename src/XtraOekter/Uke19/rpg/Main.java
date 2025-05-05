package XtraOekter.Uke19.rpg;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        RPG rpg = new RPG();
        rpg.playGame();
        System.out.println("the end");

    }
}
