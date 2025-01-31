package XtraOekter.Uke5;
import java.util.Random;
class Dog {

  private int size;
  private String breed;
  private String name;

  //1 getter setter
  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getBreed() {
    return breed;
  }

  public void setBreed(String breed) {
    this.breed = breed;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /*

  public Dog(int stoerrelse, String rase, String navn){
      this.name = navn;
      this.breed= rase;
      this.size= stoerrelse;

    }
    */

  boolean bark() {

    Random randGen = new Random();
    boolean toByteOrNotToByte =  randGen.nextBoolean();
    if (toByteOrNotToByte) System.out.println("Ruff! Ruff!");
    return toByteOrNotToByte;
  }

  boolean bite() {
    if
    (this.bark() //== true
    )
            return false;
    else return true;
  }
}