package XtraOekter.Uke9.RPG;

import java.util.Random;
//https://en.wikipedia.org/wiki/Visitor_pattern

public abstract class Character {

    private String characterType;
    private String name;
    private int strength;
    private int health;
    private int experiencePoints;
    private int magicPoints;

    public Character(String name, int strength, int health, int experiencePoints, int magicPoints){
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.experiencePoints = experiencePoints;
        this.magicPoints = magicPoints;
    }

    public int calculateFightPoints() {
        Random randGen = new Random();
        int myExtraStrength =  this.strength *    randGen.nextInt(this.experiencePoints) ;
        int myExtraMagic =  this.magicPoints *    randGen.nextInt(this.experiencePoints) ;

        return myExtraMagic + myExtraStrength;
    }



    public abstract boolean battle(Character opponent);
}
