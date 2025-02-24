package XtraOekter.Uke9.RPG;

public interface Battle {
    public int calculateFightPoints();
    public boolean battle(Battle opponent);
    public void changeHP(int i);
    public void changeXP(int i);
}
