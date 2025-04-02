package XtraOekter.Uke14.iceCream;

import java.util.HashMap;
import java.util.Map;

public class IceCream {
    Map<String, Integer> iceStash = new HashMap<>();

    public IceCream(String iceSort, int iceAmount){
        this.iceStash.put(iceSort,iceAmount);
    }

    public void getIceCream(String iceSort) {
            System.out.println(iceSort +" ice cream , please!");
            int getOneCone = this.iceStash.get(iceSort);
            if(getOneCone == 1) this.iceStash.remove(iceSort);
            else this.iceStash.replace(iceSort, getOneCone-1) ;
            System.out.println("Here you are!");

    }
}
