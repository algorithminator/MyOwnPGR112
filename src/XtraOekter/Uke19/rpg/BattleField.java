package XtraOekter.Uke19.rpg;

import java.util.Collection;

public interface BattleField {
    public void printPartyStrength(Collection<Character>party);
    public int calculateFightPointsParty(Collection<Character> party);
    public boolean battle(Collection<Character> party1, Collection<Character> party2);
}
