package XtraOekter.Uke9.RPG;

public class testCharacters {

    public static void main(String[] args) {
        Character char1 = new Wizard("Gandalf", 5, 3, 8, 9);
        Character char2 = new Wizard("Saruman", 3, 2, 9, 10);
        System.out.println("Gandalf fights Saruman. Gandalf wins: " + char1.battle(char2));
    }
}
