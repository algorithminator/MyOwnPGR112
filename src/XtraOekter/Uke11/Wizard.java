package XtraOekter.Uke11;


import java.util.Random;

public class Wizard extends Character {
    private int mp;

    public Wizard(String name, int strength, int health, int xp) {
        super(name, strength, health, xp);

    }

    public Wizard(String name, int strength, int health, int xp, int mp) {
        this(name, strength, health, xp);
        this.mp = mp;
    }

    @Override
    public int calculateFp() {
        Random randGen = new Random();
        int myExtraStrength =  super.getStrength() *    randGen.nextInt(super.getXp()) ;
        int myExtraMagic =  this.mp *    randGen.nextInt(super.getXp()) ;

        return  myExtraStrength+myExtraMagic;
    }

    @Override
    public boolean battle(Character opponent) {

        return this.calculateFp() >= opponent.calculateFp();

    }
}
