package XtraOekter.Uke19.rpg;


import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class RPG implements BattleField {

    public void printPartyStrength(Collection<Character>party) {
        //alternative 2: use functional interface with lambda-expression
        party.forEach(m -> System.out.println(m.getName() + " has health points: " + m.getHealth()));


    }

    //new battle-mechanics: calculate total fight points of party . who has most , wins.
    public int calculateFightPointsParty(Collection<Character> party) {
        // alt 1:
        int totalFP = 0;
        for (Character m : party) {

            int fP = m.calculateFp();
            totalFP += fP;
        }
        return totalFP;
    }


    public boolean battle(Collection<Character> party1, Collection<Character> party2){

        int totalFp1 = this.calculateFightPointsParty(party1);
        int totalFp2 = this.calculateFightPointsParty(party2);
        System.out.println("TOTAL FIGHT POWER PARTY 1: " + totalFp1);
        System.out.println("TOTAL FIGHT POWER PARTY 2: " + totalFp2);

        int pointsFp1 = 0;
        int pointsFp2 = 0;


        if(totalFp1  > totalFp2) {
            pointsFp1 = 1;
            pointsFp2 = -1;
        }

        if(totalFp1  < totalFp2) {
            pointsFp1 = -1;
            pointsFp2 = 1;
        }


        for (Character rpgChar : party1){
            rpgChar.changeHP(pointsFp1);
            //rpgChar.changeXP(pointsFp1);

        }
        for (Character rpgChar : party2){
            rpgChar.changeHP(pointsFp2);
            //rpgChar.changeXP(pointsFp2);

        }

        return  totalFp1  >= totalFp2;

    }

    public void playGame() throws SQLException{




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



        //BattleField bf = new BattleField();

        System.out.println("Party 1 members:");
        this.printPartyStrength(party1);
        System.out.println("Party 2 members:");
        this.printPartyStrength(party2);

        // bruk transakjoner - commit , rollback
        MysqlDataSource rpgDS = rp.getRpgDS();
        Connection con = rpgDS.getConnection();
        boolean autoCommit = con.getAutoCommit();
        con.setAutoCommit(false);

        try {
            boolean fightLoop = true;
            while (fightLoop) {
                if (party1.isEmpty()) fightLoop = false;
                if (party2.isEmpty()) fightLoop = false;
                System.out.println("Party 1 members:");
                this.printPartyStrength(party1);
                System.out.println("Party 2 members:");
                this.printPartyStrength(party2);
                System.out.println("PARTY 1 wins this fight: " + this.battle(party1, party2));

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










    }
}
