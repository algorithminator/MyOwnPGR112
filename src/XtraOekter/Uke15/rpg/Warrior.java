package XtraOekter.Uke15.rpg;

public class Warrior extends Character {
    public Warrior(String name, int strength, int health, int xp){
        super(name,strength,health,xp);
    }

    @Override
    public boolean battle(Character opponent) {
        return this.calculateFp() >= opponent.calculateFp();
    }
}
