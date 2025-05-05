package XtraOekter.Uke14.rpg;

import XtraOekter.Uke19.rpg.PlayRPG;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        PlayRPG rpg = new PlayRPG();
        rpg.playGame();
        System.out.println("the end");

    }
}
