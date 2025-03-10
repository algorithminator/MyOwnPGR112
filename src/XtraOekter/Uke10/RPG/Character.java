package XtraOekter.Uke10.RPG;

import java.util.Random;

public abstract class Character {

    private String name;
    private int strength;
    private int health;
    private int xp;
    private static int characterCount;



    public Character(String name, int strength, int health, int xp) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.xp= xp;
        Character.characterCount++;

    }

    public Character(String name){
        this.name = name;
        this.strength = 3;
        this.health = 3;
        this.xp= 1;
        Character.characterCount++;

    }
    public int calculateFP(){
        Random randGen = new Random();
        int myFightPower = this.strength * randGen.nextInt(this.xp);

        return myFightPower;

    }
    public abstract boolean battle(Character opponent);

    public static int getCharacterCount() {
        return characterCount;
    }

}
