package XtraOekter.Uke15.rpg;

public class Ork extends Character {

    public Ork(String name){
        super(name);
    }

    @Override
    public boolean battle(Character opponent) {
        return false;
    }
}
