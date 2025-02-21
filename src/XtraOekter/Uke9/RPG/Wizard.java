package XtraOekter.Uke9.RPG;

import java.util.Random;

public class Wizard extends Character{


    public Wizard( String name, int strength, int health, int experiencePoints, int magicPoints) {
        super(name, strength, health, experiencePoints, magicPoints);
    }

    @Override
    public boolean battle(Character opponent) {

        return this.calculateFightPoints() >= opponent.calculateFightPoints();

    }
}
