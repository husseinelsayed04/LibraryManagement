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
            System.out.println("--> " + book.getTitle());
        }
    }

}