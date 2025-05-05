package XtraOekter.Uke19.rpg;

import java.util.Collection;

public class BattleField {

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

}
