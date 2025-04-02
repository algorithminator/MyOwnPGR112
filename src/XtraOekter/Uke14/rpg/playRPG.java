package XtraOekter.Uke14.rpg;






import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.*;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class playRPG {
    public static void main(String[] args) throws SQLException {
        System.out.println("Antall characters in play: " + Character.getCharacterCount());

        RPGcharacters rp = new RPGcharacters();
        // insert en ny character med auto increment
        Wizard w = new Wizard("Turdor", 3,3,3,2);
        rp.addRPGCharacter(w, "WIZARD");

        // last inn character fra db
        List<Character> allPlayers =  rp.loadFromSQL();

        Collection<Character> party1 = new HashSet<>();
        Collection<Character> party2 = new HashSet<>();

        //del opp i to lag oddetall og partall
        for(int i=0;i<allPlayers.size();i++) {
            if(i%2==0){party1.add(allPlayers.get(i)); }

            else{party2.add(allPlayers.get(i));}

        }


        System.out.println("Antall characters in play: " + Character.getCharacterCount());

        System.out.println("PARTY 1 has size: " +party1.size());



        BattleField bf = new BattleField();

        System.out.println("Party 1 members:");
        bf.printPartStrength_Alt1(party1);
        System.out.println("Party 2 members:");
        bf.printPartStrength_Alt2(party2);

        // bruk transakjoner - commit , rollback
        MysqlDataSource rpgDS = rp.getRpgDS();
        Connection con = rpgDS.getConnection();
        boolean autoCommit = con.getAutoCommit();
        con.setAutoCommit(false);

        try {
            boolean fightLoop = true;
            while (fightLoop) {
                if (party1.size() == 0) fightLoop = false;
                if (party2.size() == 0) fightLoop = false;
                System.out.println("Party 1 members:");
                bf.printPartStrength_Alt1(party1);
                System.out.println("Party 2 members:");
                bf.printPartStrength_Alt2(party2);
                System.out.println("PARTY 1 wins this fight: " + bf.battle(party1, party2));

                for (Character c : allPlayers) rp.updateRPGCharacters(c, con);

                for (Character c : allPlayers) {
                    if (c.getHealth() <= 0) {
                        System.out.println("RIP " + c.getName());
                        rp.deleteRPGCharacter(c, con);

                        party1.remove(c);
                        party2.remove(c);
                        fightLoop = false;

                    }

                }
            }
            con.commit();
        }
        catch (SQLException sqle){
            System.out.println("Exception caught. Rolling back transaction.");
            con.rollback();
            throw sqle;
        } finally {
            // Setting the commit mode to what it was originally.
            con.setAutoCommit(autoCommit);
        }



        System.out.println("the end");






    }
}
