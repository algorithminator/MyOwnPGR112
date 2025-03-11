package XtraOekter.Uke11;


import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        Collection<Character> party1 = new HashSet<Character>();
        party1.add(char1);
        party1.add(char3);


        Collection<Character> party2 = new HashSet<Character>();
        party2.add(char2);
        party2.add(char4);

        // HashSets dont have duplicates
        party1.add(char1);
        System.out.println("PARTY 1 has size: " +party1.size() + " and " + " members: ");

        // alternative 1 enhanced for-loop
        for (Character m : party1) System.out.println(m.getName()+ " has stength: "+ m.getStrength());

        //alternative 2: use functional interface with lambda-expression
        party1.forEach(m -> System.out.println(m.getName()+ " has stength: "+ m.getStrength()));

        System.out.println("PARTY 1 has size: " +party1.size() + " and " + " members: ");

        //new battle-mechanics: calculate total fight points of party . who has most , wins.

        // alt 1:
        int totalFP1 = 0;
        for (Character m : party1){

            int fP = m.calculateFp();
            totalFP1 += fP;
        }

        System.out.println("TOTAL FIGHT POWER PARTY1: " + totalFP1);

        //alt 2;: stream + lambda expression + autoboxing
        totalFP1 = party1.stream().map(m -> m.calculateFp()).mapToInt(i->i.intValue()).sum();
        System.out.println("TOTAL FIGHT POWER PARTY1: " + totalFP1);


        //alt 3: stream + method referencing
        totalFP1 = party1.stream().map(Character::calculateFp).mapToInt(Integer::intValue).sum();
        System.out.println("TOTAL FIGHT POWER PARTY1: " + totalFP1);


        int totalFP2 = party2.stream().map(Character::calculateFp).mapToInt(Integer::intValue).sum();
        System.out.println("TOTAL FIGHT POWER PARTY2: " + totalFP2);

        System.out.println("PARTY 1 wins: " + (totalFP1 >=totalFP2));
        //System.out.println(party1.stream().map(Character::calculateFp)); //.collect(Collectors.toList()));
        System.out.println("the end");






    }
}
