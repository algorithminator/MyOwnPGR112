package XtraOekter.Uke9.RPG;
import java.util.Random;

public class Attacker implements Battle{
    private Character character;

    public Attacker(Character character) {this.character = character;}

    public int calculateFightPoints() {
        Random randGen = new Random();
        int myExtraStrength =  character.getStrength() *    randGen.nextInt(character.getExperiencePoints()) ;
        int myExtraMagic =  character.getMagicPoints() *    randGen.nextInt(character.getExperiencePoints()) ;

        return myExtraMagic + myExtraStrength;
    }

    public boolean battle(Battle opponent){
        // ork fight dirty
        int fpointsAttacker = this.calculateFightPoints();
        int fpointsDefender = opponent.calculateFightPoints();
        System.out.println("Fightpoints " +character.getName() + " : " + fpointsAttacker);
        System.out.println("Fightpoints opponent: " + fpointsDefender);
        return  fpointsAttacker  >= fpointsDefender;

    }

}
