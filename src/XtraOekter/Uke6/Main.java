package XtraOekter.Uke6;

public class Main {
    public static void main(String[] args) {
        Book b = new Book();
        b.setAuthor("Knut Hamsun");
        b.setTitle("Sult");
        b.setNumberOfPages(111);
        b.setGenre(Genre.CLASSIC);
        b.printMe();


        BookRegister br = new BookRegister();
        br.addBook(b);
        System.out.println("Antall books in my Bookregister:" + br.countRegisteredBooks());

        b = new Book();
        b.setAuthor("Isaac Asimov");
        b.setTitle("Foundation Trilogy");
        b.setNumberOfPages(605);
        b.setGenre(Genre.OTHER);
        b.printMe();
        br.addBook(b);
        System.out.println("Antall books in my Bookregister:" + br.countRegisteredBooks());
    }
}
