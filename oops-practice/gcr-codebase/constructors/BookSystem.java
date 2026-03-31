class Book {
    public String ISBN;
    protected String title;
    private String author;
    Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
}
class EBook extends Book {
    EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }
    void displayBook() {
        System.out.println("ISBN: " + ISBN); 
        System.out.println("Title: " + title); 
        System.out.println("Author: " + getAuthor()); 
    }
}
public class BookSystem {
    public static void main(String[] args) {
        EBook ebook = new EBook("978-101", "Java Basics", "James");
        ebook.displayBook();
        ebook.setAuthor("James Gosling");
        System.out.println("Updated Author: " + ebook.getAuthor());
    }
}
