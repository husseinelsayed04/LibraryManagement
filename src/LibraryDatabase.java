import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryDatabase {
    private Librarian currentLibrarian;
    private List<LibraryItem> availableBooks = new ArrayList<>();
    private Map<LibraryItem, User> borrowedBooks = new HashMap<>();

    public LibraryDatabase(Librarian librarian){
        this.currentLibrarian = librarian;
    }

    public void addBook(LibraryItem book){
        availableBooks.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void viewAvailableBooks(){
        if(availableBooks.isEmpty()){
            System.out.println("No books available.");
            return;
        }

        System.out.println("Available Books:");
        for(LibraryItem book : availableBooks){
            System.out.println("--> " + book.getTitle() +
                    " (ID: " + book.getId() +
                    ", Year: " + book.getPublication() +
                    ", Pages: " + book.getNumOfPages() + ")");
        }
    }

    public void lendBook(String title, User user){
        for(LibraryItem book : availableBooks){
            if(book.getTitle().equalsIgnoreCase(title) && book.isAvailable()){
                book.setAvailable(false);
                availableBooks.remove(book);
                borrowedBooks.put(book, user);
                System.out.println(user.getName() + " borrowed " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void receiveBookFromBorrower(String title){
        for(Map.Entry<LibraryItem, User> entry : borrowedBooks.entrySet()){
            LibraryItem book = entry.getKey();
            User user = entry.getValue();
            if(book.getTitle().equalsIgnoreCase(title)){
                book.setAvailable(true);
                borrowedBooks.remove(book);
                availableBooks.add(book);
                System.out.println("Book '" + book.getTitle() + "' has been returned by " + user.getName());
                return;
            }
        }
        System.out.println("This book is not currently borrowed.");
    }

    public void searchForBook(String title){
        for(LibraryItem book : availableBooks){
            if(book.getTitle().equalsIgnoreCase(title)){
                System.out.println("Book '" + book.getTitle() + "' is available.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
    public void borrowReport(){
        if(borrowedBooks.isEmpty()){
            System.out.println("No borrowed books.");
            return;
        }
        System.out.println("Borrowed Books Report:");
        for(Map.Entry<LibraryItem, User> entry : borrowedBooks.entrySet()){
            LibraryItem book = entry.getKey();
            User user = entry.getValue();
            System.out.println(book.getTitle() + " (ID: " + book.getId() + ") borrowed by " + user.getName() + " (Job: " + user.getJob() + ")");
        }
    }

    public void summaryReport(){
        int totalBooks = availableBooks.size() + borrowedBooks.size();
        System.out.println("Library Summary:");
        System.out.println("Total books: " + totalBooks);
        System.out.println("Available books: " + availableBooks.size());
        System.out.println("Borrowed books: " + borrowedBooks.size());
    }
}