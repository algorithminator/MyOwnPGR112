package XtraOekter.Uke9.RPG;

public class testCharacters {

    public static void main(String[] args) {
        System.out.println("Antall Characters: " + Character.characterCount);
        Character char1 = new Wizard("Gandalf", 5, 3, 8, 9);
        System.out.println("Antall Characters: "+ Character.characterCount);
        Character char2 = new Wizard("Saruman", 3, 2, 9, 10);
        System.out.println("Antall Characters: " + Character.characterCount);
        System.out.println("Gandalf fights Saruman. Gandalf wins: " + char1.battle(char2));
        Character char3 = new Warrior("Borimir", 10, 8, 4);
        Character char4 = new Ork("Snaga", 3, 2, 3);
        System.out.println("Borimir fights Snaga. Borimir wins: " + char3.battle(char4));

        Character char5 = new Wizard("WizardApprentice", 5, 3, 8);
        System.out.println("Antall Characters: " + Character.characterCount);
        Character char6 = new Ork("CheaterOrk");
        System.out.println("Borimir fights Snaga. Borimir wins: " + char3.battle(char6));

    }
}
