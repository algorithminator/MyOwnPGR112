package XtraOekter.Uke6;

import java.util.ArrayList;

public class BookRegister {
    private ArrayList<Book> registeredBooks = new ArrayList<>();

    public void addBook(Book b){
        this.registeredBooks.add(b);
    }

}
