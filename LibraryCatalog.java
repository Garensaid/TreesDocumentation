import java.util.Scanner;

class Book {
    String title;
    String author;
    String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
}

public class LibraryCatalog {
    private Book[] books;
    private int size;

    public LibraryCatalog(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    public void addBook(String title, String author, String isbn) {
        books[size] = new Book(title, author, isbn);
        size++;
    }

    public void removeBook(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].title.equals(title)) {
                books[i] = books[size - 1];
                size--;
                break;
            }
        }
    }

    public void searchBook(String query) {
        for (int i = 0; i < size; i++) {
            if (books[i].title.contains(query) || books[i].author.contains(query) || books[i].isbn.contains(query)) {
                System.out.println("Book found:");
                System.out.println("Title: " + books[i].title);
                System.out.println("Author: " + books[i].author);
                System.out.println("ISBN: " + books[i].isbn);
                return;
            }
        }
        System.out.println("Book not found");
    }

    public void displayBooks() {
        for (int i = 0; i < size; i++) {
            System.out.println("Title: " + books[i].title);
            System.out.println("Author: " + books[i].author);
            System.out.println("ISBN: " + books[i].isbn);
        }
    }

    public static void main(String[] args) {
        LibraryCatalog libraryCatalog = new LibraryCatalog(10);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Search book");
            System.out.println("4. Display all books");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    libraryCatalog.addBook(title, author, isbn);
                    break;
                case 2:
                    System.out.print("Enter title: ");
                    title = scanner.nextLine();
                    libraryCatalog.removeBook(title);
                    break;
                case 3:
                    System.out.print("Enter query: ");
                    String query = scanner.nextLine();
                    libraryCatalog.searchBook(query);
                    break;
                case 4:
                    libraryCatalog.displayBooks();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}