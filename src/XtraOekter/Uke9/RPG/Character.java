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

    public int getStrength() {
        return strength;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }
    public void changeXP(int i){
        experiencePoints = experiencePoints + i;
    }

    public int getMagicPoints() {
        return magicPoints;
    }

    public int getHealth() {
        return health;
    }

    public void changeHealth(int i){
        health = health + i;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName()+ "/health " + getHealth();
    }
}
