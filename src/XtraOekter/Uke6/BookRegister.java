package XtraOekter.Uke6;

import java.util.ArrayList;

public class BookRegister {
    private ArrayList<Book> registeredBooks = new ArrayList<>();

    public void addBook(Book b){
        this.registeredBooks.add(b);
    }

    int countRegisteredBooks(){
        return this.registeredBooks.size();
    }

     public void allBooksInRegister(){
             for (Book b :
                     this.registeredBooks) {
                 System.out.println(b.toString());
             }
     }
     public void booksByGenre(Genre genre){
             for (Book b :
                     this.registeredBooks) {
                 if(b.getGenre() == genre){
                     System.out.println(b.toString());
                 }
             }
     }
     public void booksByAuthor(String author){
             for (Book b :
                     this.registeredBooks) {
                 if(b.getAuthor().equals(author)){
                     System.out.println(b.toString());
                 }
             }
     }

     public ArrayList<Book> getBooksWithLessTimeToRead (int maxTime){

        ArrayList<Book> shortBooks = new ArrayList<>();
        for(var b : this.registeredBooks){
                int totalTimeReading = 0;
                for (var c : b.getChapters()){
                    totalTimeReading += c.getTimeReading();
                }

                if (totalTimeReading > 0 && totalTimeReading < maxTime)
                    shortBooks.add(b);
        }

        return shortBooks ;
     }

}
