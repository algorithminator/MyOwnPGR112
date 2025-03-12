package XtraOekter.Uke11;


import java.util.Collection;
import java.util.HashSet;

public class playRPG {
    public static void main(String[] args) {
        System.out.println("Antall characters in play: " + Character.getCharacterCount());
        Character char1 = new Warrior("Borirmir",10,10,3) ;
        System.out.println("Antall characters in play: " + Character.getCharacterCount());
        Character char2 = new Ork("Snaga");
        System.out.println("Antall characters in play: " + Character.getCharacterCount());
        System.out.println("Borimir fights Snaga. Borimir wins: " + char1.battle(char2));
        //char2 = new Warrior("Sauron",100,100,100) ;
        System.out.println("Borimir fights Sauron. Borimir wins: " + char1.battle(char2));


        Character char3 = new Wizard("Gandalf", 5, 3, 8, 9);
        Character char4 = new Wizard("Saruman", 3, 2, 9, 10);
        System.out.println("Antall characters in play: " + Character.getCharacterCount());

        Collection<Character> party1 = new HashSet<>();
        party1.add(char1);
        party1.add(char3);


        Collection<Character> party2 = new HashSet<>();
        party2.add(char2);
        party2.add(char4);

        // HashSets dont have duplicates
        party1.add(char1);
        System.out.println("PARTY 1 has size: " +party1.size());



        BattleField battle = new BattleField();

        System.out.println("Party 1 members:");
        battle.printPartStrength_Alt1(party1);
        System.out.println("Party 2 members:");
        battle.printPartStrength_Alt2(party2);

        int totalFp1 = battle.calulateFpParty_Alt1(party1);

        System.out.println("TOTAL FIGHT POWER PARTY 1: " + totalFp1);


        int totalFp2 = battle.calulateFpParty_Alt2(party2);

        System.out.println("TOTAL FIGHT POWER PARTY 2: " + totalFp2);

        System.out.println("PARTY 1 wins: "+ (totalFp1>= totalFp2));

        int totalFp3 = battle.calulateFpParty_Alt3(party2);

        System.out.println("TOTAL FIGHT POWER PARTY 2: " + totalFp3);

        System.out.println("PARTY 1 wins: "+ (totalFp1>= totalFp3));







        //System.out.println(party1.stream().map(Character::calculateFp)); //.collect(Collectors.toList()));
        System.out.println("the end");






    }
}
