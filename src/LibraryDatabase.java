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

    // Add item
    public void addItem(LibraryItem item) {
        availableItems.add(item);
        System.out.println(item.getTitle() + " added to library.");
    }

    // View available items
    public void viewAvailableItems() {
        if (availableItems.isEmpty()) {
            System.out.println("No items available.");
            return;
        }

        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-20s %-10s %-10s %-10s%n", "Title", "ID", "Type", "Available");
        System.out.println("-------------------------------------------------------------");

        for (LibraryItem item : availableItems) {
            String type = item.getClass().getSimpleName();
            System.out.printf("%-20s %-10d %-10s %-10s%n",
                    item.getTitle(),
                    item.getId(),
                    type,
                    item.isAvailable() ? "Yes" : "No");
        }

        System.out.println("-------------------------------------------------------------");
    }

    // Lend item
    public void lendItem(String title, String type, User user) {
        for (LibraryItem item : availableItems) {
            boolean typeMatches = false;
            switch (type.toLowerCase()) {
                case "book": typeMatches = item instanceof Book; break;
                case "magazine": typeMatches = item instanceof Magazine; break;
                case "journal": typeMatches = item instanceof Journal; break;
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

    // Receive item
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

    // Search for item
    public void searchForItem(String title, String type) {
        boolean found = false;
        for (LibraryItem item : availableItems) {
            boolean typeMatches = false;
            switch (type.toLowerCase()) {
                case "book": typeMatches = item instanceof Book; break;
                case "magazine": typeMatches = item instanceof Magazine; break;
                case "journal": typeMatches = item instanceof Journal; break;
            }

            if (typeMatches && item.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found " + type + ":");
                System.out.println("-------------------------------------------------------------");
                System.out.printf("%-20s %-10s %-10s %-10s%n", "Title", "ID", "Type", "Available");
                System.out.println("-------------------------------------------------------------");
                System.out.printf("%-20s %-10d %-10s %-10s%n",
                        item.getTitle(),
                        item.getId(),
                        type,
                        item.isAvailable() ? "Yes" : "No");
                System.out.println("-------------------------------------------------------------");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(type + " not found with title: " + title);
        }
    }

    // available item types
    public List<String> getAvailableItemTypes() {
        List<String> types = new ArrayList<>();
        for (LibraryItem item : availableItems) {
            String typeName = item.getClass().getSimpleName(); // Book, Magazine, Journal
            if (!types.contains(typeName)) {
                types.add(typeName);
            }
        }
        return types;
    }

    // Borrowed items report
    public void borrowReport() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No borrowed items.");
            return;
        }

        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-20s %-10s %-20s %-10s%n", "Title", "ID", "Borrowed By", "Job");
        System.out.println("-------------------------------------------------------------");

        for (Map.Entry<LibraryItem, User> entry : borrowedBooks.entrySet()) {
            LibraryItem item = entry.getKey();
            User user = entry.getValue();
            System.out.printf("%-20s %-10d %-20s %-10s%n",
                    item.getTitle(),
                    item.getId(),
                    user.getName(),
                    user.getJob());
        }

        System.out.println("-------------------------------------------------------------");
    }

    // Summary report
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

        System.out.println("-------------------------------------------------------------");
        System.out.println("Library Summary Report:");
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-20s %-10d%n", "Total Books:", booksCount);
        System.out.printf("%-20s %-10d%n", "Total Magazines:", magazinesCount);
        System.out.printf("%-20s %-10d%n", "Total Journals:", journalsCount);
        System.out.printf("%-20s %-10d%n", "Available Items:", availableItems.size());
        System.out.printf("%-20s %-10d%n", "Borrowed Items:", borrowedBooks.size());
        System.out.println("-------------------------------------------------------------");
    }
}