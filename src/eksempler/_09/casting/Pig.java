package eksempler._09.casting;

public class Pig implements Animal {
    @Override
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says wee wee");
    }

    @Override
    public void sleep() {
        // The body of sleep() is provided here
        System.out.println("Zzz");
    }

    public void exclusivePigMethod(){
        System.out.println("aaaaaaaaaaa");
    }
}
