package XtraOekter.Uke9.RPG;

import java.util.Random;

public class Defender implements Battle{
    private Character character;

    public Defender(Character character) {this.character = character;}
    /**
     * defender always weaker
     * @return fightpoints
     */
    @Override
    public int calculateFightPoints() {
        Random randGen = new Random();
        int myExtraStrength =  character.getStrength() *    randGen.nextInt(character.getExperiencePoints()) ;
        int myExtraMagic =  character.getMagicPoints() *    randGen.nextInt(character.getExperiencePoints()) ;

        return myExtraMagic + myExtraStrength -2;
    }

    /**
     * @param opponent
     * @return
     * Defenders dont battle
     */
    @Override
    public boolean battle(Battle opponent) {
        return false;
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
