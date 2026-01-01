class Book{
    static String libraryName="GLA Library";
    final String isbn;
    String title;
    String author;
    Book(String title,String author,String isbn){
        this.title=title;
        this.author=author;
        this.isbn=isbn;
    }
    static void displayLibraryName(){
        System.out.println("Library Name: "+libraryName);
    }
    void displayDetails(Object obj){
        if(obj instanceof Book){
            System.out.println("Title: "+title);
            System.out.println("Author: "+author);
            System.out.println("ISBN: "+isbn);
        }
    }
    public static void main(String[] args){
        Book b=new Book("Java","James","685991");
        displayLibraryName();
        b.displayDetails(b);
    }
}
