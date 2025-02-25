package XtraOekter.Uke9.RPG;

import java.util.ArrayList;

import static java.lang.Math.min;

public class testCharacters {

    public static void main(String[] args) {
        Character gandalf = new Wizard("Gandalf", 5, 3, 8, 9);
        Character saruman = new Wizard("Saruman", 3, 2, 9, 10);
        Character borimir = new Warrior("Borimir", 7, 8, 4, 0);
        Character snaga = new Ork("Snaga", 5, 2, 3, 1);
        ArrayList<Character> myParty = new ArrayList<>();
        ArrayList<Character> enemyParty = new ArrayList<>();
        myParty.add(gandalf);
        myParty.add(borimir);
        enemyParty.add(saruman);
        enemyParty.add(snaga);

        for (int i = 0 ; i < min(myParty.size(),enemyParty.size()); i++){
            System.out.println("New round:");
                           Character myCharacter = myParty.get(i);
                           Character opponentCharacter = enemyParty.get(i);
                           Attacker myAttacker = new Attacker(myCharacter);
                           Defender defenders = new Defender(opponentCharacter);
                           System.out.printf("%s attacks %s. ", myCharacter,opponentCharacter);
                           boolean battleOutcome =   myAttacker.battle(defenders);
                           System.out.printf("%s wins: %b \n", myCharacter,opponentCharacter,myCharacter, battleOutcome);


        }


    }
}
