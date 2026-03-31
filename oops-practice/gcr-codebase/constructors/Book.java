public class Book {
    String author;
    String title;
    double price;
    Book() {
        author = "Mr. Bean";
        title = "Laugh with Bean";
        price = 329.25;
    }
    Book(String author, String title, double price) {
        this.author = author;
        this.title = title;
        this.price = price;
    }
    void displayBookDetails() {
        System.out.println("Author: " + author);
        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
    }
    public static void main(String[] args) {
        Book myBook = new Book();
        myBook.displayBookDetails();
        Book book = new Book("James", "It's me!", 425.39);
        book.displayBookDetails();
    }
}
