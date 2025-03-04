package XtraOekter.Uke9.RPG;



public class Warrior extends Character{

    public Warrior( String name, int strength, int health, int experiencePoints) {
        super(name, strength, health, experiencePoints);
    }

    public Warrior( String name) {

        super(name);
    }


    @Override
    public boolean battle(Character opponent) {

        return this.calculateFightPoints() >= opponent.calculateFightPoints();

    }
}
