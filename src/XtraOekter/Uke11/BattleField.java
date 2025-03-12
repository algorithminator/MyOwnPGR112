package XtraOekter.Uke11;

import java.util.Collection;

public class BattleField {


    public void printPartStrength_Alt1(Collection<Character> party) {

        // alternative 1 enhanced for-loop
        for (Character m : party) System.out.println(m.getName() + " has stength: " + m.getStrength());
    }

    public void printPartStrength_Alt2(Collection<Character>party) {
        //alternative 2: use functional interface with lambda-expression
        party.forEach(m -> System.out.println(m.getName() + " has stength: " + m.getStrength()));


    }

    //new battle-mechanics: calculate total fight points of party . who has most , wins.
    public int calulateFpParty_Alt1(Collection<Character> party) {
        // alt 1:
        int totalFP = 0;
        for (Character m : party) {

            int fP = m.calculateFp();
            totalFP += fP;
        }
        return totalFP;
    }

    //alt 2;: stream + lambda expression + autoboxing
    public int calulateFpParty_Alt2(Collection<Character> party) {
        int totalFP = 0;
        totalFP = party.stream()
                .map(m -> m.calculateFp())
                .mapToInt(i -> i)
                .sum();

        return totalFP;
    }



    //alt 3: stream + method referencing
    public  int calulateFpParty_Alt3(Collection<Character> party) {
       int totalFP = 0;
        totalFP = party.stream()
                .map(Character::calculateFp)
                .mapToInt(Integer::intValue)
                .sum();


          return totalFP;
      }
}
