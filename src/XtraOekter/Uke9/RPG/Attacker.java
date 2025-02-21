package XtraOekter.Uke9.RPG;

public class Attacker implements Battle{
    private Character character;

    public Attacker(Character character) {this.character = character;}
    public boolean battle(Character opponent){
        // ork fight dirty
        return  character.calculateFightPoints()  >= opponent.calculateFightPoints();

    }

}
