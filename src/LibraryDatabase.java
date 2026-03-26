import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryDatabase {
    private Librarian currentLibrarian;
    private List<LibraryItem> availableItems = new ArrayList<>();
    private Map<LibraryItem, User> borrowedBooks = new HashMap<>();

    public LibraryDatabase(Librarian librarian) {
        this.currentLibrarian = librarian;
    }

    // add item
    public void addItem(LibraryItem item) {
        availableItems.add(item);
        System.out.println(item.getTitle() + " added to library.");
    }
 //view item
    public void viewAvailableItems() {
        if (availableItems.isEmpty()) {
            System.out.println("No items available.");
            return;
        }

        System.out.println("Available Library Items:");
        for (LibraryItem item : availableItems) {
            item.displayInfo();
            System.out.println("---------------------------");
        }
    }
 // lend item
    public void lendItem(String title, String type, User user) {
        for (LibraryItem item : availableItems) {
            boolean typeMatches = false;
            switch (type.toLowerCase()) {
                case "book":
                    typeMatches = item instanceof Book;
                    break;
                case "magazine":
                    typeMatches = item instanceof Magazine;
                    break;
                case "journal":
                    typeMatches = item instanceof Journal;
                    break;
            }

            if (typeMatches && item.getTitle().equalsIgnoreCase(title) && item.isAvailable()) {
                item.setAvailable(false);
                availableItems.remove(item);
                borrowedBooks.put(item, user);
                System.out.println(user.getName() + " borrowed " + item.getTitle() + " (" + type + ")");
                return;
            }
        }
        System.out.println(type + " with title '" + title + "' is not available.");
    }

    //receive item
    public void receiveItemFromBorrower(String title) {
        for (Map.Entry<LibraryItem, User> entry : borrowedBooks.entrySet()) {
            LibraryItem item = entry.getKey();
            User user = entry.getValue();
            if (item.getTitle().equalsIgnoreCase(title)) {
                item.setAvailable(true);
                borrowedBooks.remove(item);
                availableItems.add(item);
                System.out.println(item.getTitle() + " has been returned by " + user.getName());
                return;
            }
        }
        System.out.println("This item is not currently borrowed.");
    }

    //search for item
    public void searchForItem(String title, String type) {
        boolean found = false;
        for (LibraryItem item : availableItems) {
            boolean typeMatches = false;
            switch (type.toLowerCase()) {
                case "book":
                    typeMatches = item instanceof Book;
                    break;
                case "magazine":
                    typeMatches = item instanceof Magazine;
                    break;
                case "journal":
                    typeMatches = item instanceof Journal;
                    break;
            }

            if (typeMatches && item.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found " + type + ":");
                item.displayInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(type + " not found with title: " + title);
        }
    }
// borrow report
    public void borrowReport() {
        System.out.println("Borrowed Items Report:");
        if (borrowedBooks.isEmpty()) {
            System.out.println("No borrowed items.");
        } else {
            for (Map.Entry<LibraryItem, User> entry : borrowedBooks.entrySet()) {
                LibraryItem item = entry.getKey();
                User user = entry.getValue();
                System.out.println(item.getTitle() + " (ID:" + item.getId() + ") borrowed by " + user.getName() + " (Job: " + user.getJob() + ")");
            }
        }
    }
 // summary report
    public void summaryReport() {
        int booksCount = 0;
        int magazinesCount = 0;
        int journalsCount = 0;

        for (LibraryItem item : availableItems) {
            if (item instanceof Book) booksCount++;
            else if (item instanceof Magazine) magazinesCount++;
            else if (item instanceof Journal) journalsCount++;
        }

        for (LibraryItem item : borrowedBooks.keySet()) {
            if (item instanceof Book) booksCount++;
            else if (item instanceof Magazine) magazinesCount++;
            else if (item instanceof Journal) journalsCount++;
        }

        System.out.println("Library Summary Report:");
        System.out.println("Total Books: " + booksCount);
        System.out.println("Total Magazines: " + magazinesCount);
        System.out.println("Total Journals: " + journalsCount);
        System.out.println("Available Items: " + availableItems.size());
        System.out.println("Borrowed Items: " + borrowedBooks.size());
    }
}