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

        int fpointsAttacker = this.calculateFightPoints();
        int fpointsDefender = opponent.calculateFightPoints();
        System.out.println("Fightpoints " +character.getName() + " : " + fpointsAttacker);
        System.out.println("Fightpoints opponent: " + fpointsDefender);
        if(fpointsAttacker  > fpointsDefender){
            changeHP(1);
            changeXP(1);
            opponent.changeHP(-1);
            opponent.changeXP(-1);
        }
        if(fpointsAttacker  < fpointsDefender){
            changeHP(-1);
            changeXP(-1);
            opponent.changeHP(1);
            opponent.changeXP(1);
        }

        return  fpointsAttacker  >= fpointsDefender;

    }

    /**
     * @param i
     */
    @Override
    public void changeHP(int i) {
        character.changeHealth(i);
    }

    /**
     * @param i
     */
    @Override
    public void changeXP(int i) {
        character.changeXP(i);

    }

}
