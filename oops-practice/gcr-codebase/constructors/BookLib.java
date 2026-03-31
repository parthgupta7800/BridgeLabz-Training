class BookLib {
    String title;
    String author;
    double price;
    boolean available;
    BookLib(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }
    void borrowBook() {
        if (available) {
            available = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }
    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + available);
    }
    public static void main(String[] args) {
        BookLib book = new BookLib("Java Basics", "James Gosling", 499.0);
        book.display();
        book.borrowBook();
        book.borrowBook();
    }
}
