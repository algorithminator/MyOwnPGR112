package XtraOekter.Uke5;

class DogTestDrive {
  public static void main(String[] args) {
    /*Dog d = new Dog(42, "Border Collie","Frøya");*/

    Dog d = new Dog();
    d.setSize(40);
    d.setBreed("Border Collie");
    d.setName("Frøya");
    //d.bark();

    Vetenary vet = new Vetenary();
    int x = d.getSize();
    System.out.printf("Opprinnelige størrelse: %s \n" ,x );
    System.out.printf("Veterinären skriver uten å se på hunden: %s \n", vet.korrigerSize(x));
    System.out.printf("Hva er x nå? 40 eller 42?: %s \n" ,x );


    System.out.printf("Opprinnelige størrelse: %s \n" ,d.getSize() );
    // pass by value
    vet.maalStoerrelse(d);
    System.out.printf("Etter veterinären har målt hunden? %s \n", d.getSize());
    //d.bark();
    var myReaction = d.bite();
    if (myReaction) System.out.println("AUA");

  }
}