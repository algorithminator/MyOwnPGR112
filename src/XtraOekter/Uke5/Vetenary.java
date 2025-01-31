package XtraOekter.Uke5;

public class Vetenary {

    int korrigerSize (int x){

        int newX;
        newX= x + 2;

        return newX;
    }

    void maalStoerrelse (Dog d){
        int stoerrelse = d.getSize();
        d.setSize(stoerrelse+2);
        //return newX;
    }
}
