package XtraOekter.Uke9.RPG;

public class Ork extends Character{
    public Ork( String name, int strength, int health, int experiencePoints) {
        super(name, strength, health, experiencePoints);
    }

    public Ork(String name){
        this(name, 100, 100, 100)  ;
    }

    @Override
    public boolean battle(Character opponent) {

        return this.calculateFightPoints()  >= opponent.calculateFightPoints();

    }
}
