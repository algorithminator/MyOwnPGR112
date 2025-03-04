package XtraOekter.Uke9.RPG;

import java.util.Random;

public class Wizard extends Character{
    private int magicPoints;

    public Wizard( String name, int strength, int health, int experiencePoints) {
        super(name, strength, health, experiencePoints);

    }

    public Wizard( String name, int strength, int health, int experiencePoints, int magicPoints) {
        this(name, strength, health, experiencePoints);
        this.magicPoints = magicPoints;
    }

    @Override
    public int calculateFightPoints() {
        Random randGen = new Random();
        int myExtraStrength =  super.getStrength() *    randGen.nextInt(super.getExperiencePoints()) ;
        int myExtraMagic =  this.magicPoints *    randGen.nextInt(super.getExperiencePoints()) ;

        return  myExtraStrength+myExtraMagic;
    }

    @Override
    public boolean battle(Character opponent) {

        return this.calculateFightPoints() >= opponent.calculateFightPoints();

    }
}
