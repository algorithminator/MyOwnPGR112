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

            // getOneCone either has the amount of ice cream as Integer OR is empty
            Optional<Integer> getOneCone = Optional.ofNullable(this.iceStash.get(iceSort));
            if (getOneCone.isEmpty() ) {

                System.out.println("We don't have any, sorry.");
                return 0;
            } else if (getOneCone.isPresent()) {
                System.out.println("Here you are!");
            }

        if (getOneCone.get() == 1) {
            // ouch, last cone..
            this.iceStash.remove(iceSort);
        }
        else {
            // get lesser and lesser..
            this.iceStash.replace(iceSort, getOneCone.get() - 1);
        }

                
           return 1;
    }
}
