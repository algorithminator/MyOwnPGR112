package XtraOekter.Uke9.RPG;

import java.util.Random;
//https://en.wikipedia.org/wiki/Visitor_pattern

public abstract class Character {

    private String characterType;
    private String name;
    private int strength;
    private int health;
    private int experiencePoints;
    public static int characterCount;

    static{
        System.out.println("Vellkommen til mini-RPG");
    }


    public Character(String name, int strength, int health, int experiencePoints){
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.experiencePoints = experiencePoints;
        Character.characterCount++;

    }

    public Character(String name){
        Random randGen = new Random();
        this.name = name;
        this.strength = randGen.nextInt(1,5);
        this.health = randGen.nextInt(1,5);
        this.experiencePoints = randGen.nextInt(1,5);
        Character.characterCount++;

    }




    public int calculateFightPoints() {
        Random randGen = new Random();
        int myExtraStrength =  this.strength *    randGen.nextInt(this.experiencePoints) ;
        //int myExtraMagic =  this.magicPoints *    randGen.nextInt(this.experiencePoints) ;

        return  myExtraStrength;
    }



    public abstract boolean battle(Character opponent);

    public int getStrength() {
        return strength;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }
}
