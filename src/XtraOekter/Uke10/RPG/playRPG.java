package XtraOekter.Uke10.RPG;

public class playRPG {
    public static void main(String[] args) {
        System.out.println("Antall characters in play: " + Character.getCharacterCount());
        Character char1 = new Warrior("Borirmir",10,10,3) ;
        System.out.println("Antall characters in play: " + Character.getCharacterCount());
        Character char2 = new Ork("Snaga");
        System.out.println("Antall characters in play: " + Character.getCharacterCount());
        System.out.println("Borimir fights Snaga. Borimir wins: " + char1.battle(char2));
        char2 = new Warrior("Sauron",100,100,100) ;
        System.out.println("Borimir fights Sauron. Borimir wins: " + char1.battle(char2));
    }
}
