package XtraOekter.Uke6;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Book b = new Book();
        b.setAuthor("Knut Hamsun");
        b.setTitle("Sult");
        b.setNumberOfPages(111);
        b.setGenre(Genre.CLASSIC);
        b.setChapters(new ArrayList<>());
        b.printMe();


        BookRegister br = new BookRegister();
        br.addBook(b);
        System.out.println("Antall books in my Bookregister:" + br.countRegisteredBooks());

        b = new Book();
        b.setAuthor("Isaac Asimov");
        b.setTitle("Foundation Trilogy");
        b.setNumberOfPages(605);
        b.setGenre(Genre.OTHER);
        Chapter chapter1 = new Chapter();
        chapter1.setTitle("Title1");
        chapter1.setNumPages(20);
        chapter1.setTimeReading(4);
        Chapter chapter2 = new Chapter();
        chapter2.setTitle("Title2");
        chapter2.setNumPages(25);
        chapter2.setTimeReading(5);
        ArrayList<Chapter> chapters = new ArrayList<>();
        chapters.add(chapter1);
        chapters.add(chapter2);
        b.setChapters(chapters);
        b.printMe();
        br.addBook(b);
        System.out.println("Antall books in my Bookregister:" + br.countRegisteredBooks());
        //F
        br.allBooksInRegister();
        br.booksByGenre(Genre.CLASSIC);
        System.out.println("Testing by FANTASY");
        br.booksByGenre(Genre.FANTASY);
        System.out.println("Books by Hamsun:");
        br.booksByAuthor("Knut Hamsun");
        System.out.println("Books by blabla:");
        br.booksByAuthor("blabla");


        System.out.println( "Short books: "+ br.getBooksWithLessTimeToRead(10));
        System.out.println( "Short books: "+ br.getBooksWithLessTimeToRead(9));










    }
}
