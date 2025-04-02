package XtraOekter.Uke14.iceCream;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class IceCream {
    Map<String, Integer> iceStash = new HashMap<>();

    public IceCream(String iceSort, int iceAmount){
        this.iceStash.put(iceSort,iceAmount);
    }

    public int getIceCream(String iceSort) {
            System.out.println(iceSort +" ice cream , please!");

            // getOneCone har enten NULL verdi eller int
            Optional<Integer> getOneCone = Optional.ofNullable(this.iceStash.get(iceSort));
            if (getOneCone.isEmpty() ) {

                System.out.println("We don't have any, sorry.");
                return 0;
            }

            if (getOneCone.get() == 1) this.iceStash.remove(iceSort);
            else this.iceStash.replace(iceSort, getOneCone.get() - 1);

            System.out.println("Here you are!");
                
           return 1;
    }
}
