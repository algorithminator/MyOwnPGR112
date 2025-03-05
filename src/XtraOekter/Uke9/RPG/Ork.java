package XtraOekter.Uke9.RPG;

public class Ork extends Character{

    static{
        System.out.println("ORKS!");
    }
    public Ork( String name, int strength, int health, int experiencePoints) {
        super(name, strength, health, experiencePoints);
    }

    public Ork(String name, int cheat){
        this(name, cheat, cheat, cheat)  ;
    }

    public Ork(String name){
        super(name);
    }


    @Override
    public boolean battle(Character opponent) {

        return this.calculateFightPoints()  >= opponent.calculateFightPoints();

    }
}
