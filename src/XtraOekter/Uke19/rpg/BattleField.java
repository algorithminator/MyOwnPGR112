package XtraOekter.Uke19.rpg;

import java.util.Collection;

public interface BattleField {

    public void printPartStrength_Alt1(Collection<Character> party);
    public void printPartStrength_Alt2(Collection<Character>party);
    public int calulateFpParty_Alt1(Collection<Character> party);
    public boolean battle(Collection<Character> party1, Collection<Character> party2);





}
