package XtraOekter.Uke9.RPG;

public class Ork extends Character{
    public Ork( String name, int strength, int health, int experiencePoints, int magicPoints) {
        super(name, strength, health, experiencePoints, magicPoints);
    }

    @Override
    public boolean battle(Character opponent) {

        return this.calculateFightPoints()  >= opponent.calculateFightPoints();

    }
}
