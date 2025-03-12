// Superclass Book
class Book {
    protected String title;
    protected int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Subclass Author extending Book
class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Bio: " + bio);
    }
}

// Main Class to Test Library Management System
public class LibraryManagement {
    public static void main(String[] args) {
        // Creating an Author object (which is also a Book)
        Author authorBook = new Author("The Great Gatsby", 1925, "F. Scott Fitzgerald", "An American novelist famous for The Great Gatsby.");

        // Displaying information
        authorBook.displayInfo();
    }
}
