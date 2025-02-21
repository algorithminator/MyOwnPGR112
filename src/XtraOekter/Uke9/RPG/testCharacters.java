package XtraOekter.Uke9.RPG;

public class testCharacters {

    public static void main(String[] args) {
        Character gandalf = new Wizard("Gandalf", 5, 3, 8, 9);
        Character saruman = new Wizard("Saruman", 3, 2, 9, 10);
        Attacker gandalfAttacks = new Attacker(gandalf);
        System.out.println("Gandalf fights Saruman. Gandalf wins: " + gandalfAttacks.battle(saruman));

        Character borimir = new Warrior("Borimir", 10, 8, 4, 0);
        Character snaga = new Ork("Snaga", 3, 2, 3, 1);
        Attacker borimirAttacks = new Attacker(borimir);
        System.out.println("Borimir fights Snaga. Borimir wins: " + borimirAttacks.battle(snaga));

    }
}
