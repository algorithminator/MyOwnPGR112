package XtraOekter.Uke10.RPG;

public class Warrior extends Character{
    public Warrior(String name, int strength, int health, int xp){
        super(name,strength,health,xp);
    }

    @Override
    public boolean battle(Character opponent) {
        return this.calculateFP() >= opponent.calculateFP();
    }
}
