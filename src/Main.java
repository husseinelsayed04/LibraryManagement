import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter librarian name:");
        String librarianName = sc.nextLine();
        System.out.println("Enter librarian ID:");
        int librarianId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter librarian username:");
        String librarianUsername = sc.nextLine();
        System.out.println("Enter librarian password:");
        String librarianPassword = sc.nextLine();

        Librarian librarian = new Librarian(librarianName, librarianId, librarianUsername, librarianPassword);
        LibraryDatabase library = new LibraryDatabase(librarian);

        while (true) {
            System.out.println("Login to Library System:");
            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();

            if (librarian.checkLogin(username, password)) {
                System.out.println("Login successful!\n");
                break;
            } else {
                System.out.println("Incorrect username or password. Try again.\n");
            }
        }

        while (true) {
            System.out.println(
                    "\n--- Library System ---\n" +
                            "1: Add Book\n" +
                            "2: Add Magazine\n" +
                            "3: Add Journal\n" +
                            "4: View Available Items\n" +
                            "5: Lend Item\n" +
                            "6: Receive Item\n" +
                            "7: Search for Item\n" +
                            "8: Report: Borrowed Items\n" +
                            "9: Summary Report\n" +
                            "10: Exit"
            );
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:   //add book
                    System.out.print("Enter book title: ");
                    String bookTitle = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter publication year: ");
                    int year = sc.nextInt();
                    System.out.print("Enter number of pages: ");
                    int pages = sc.nextInt();
                    System.out.print("Enter book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();
                    Book book = new Book(bookTitle, year, bookId, pages, true, author);
                    library.addItem(book);
                    break;

                case 2: // add magazine
                    System.out.print("Enter magazine title: ");
                    String magTitle = sc.nextLine();
                    System.out.print("Enter publication year: ");
                    int magYear = sc.nextInt();
                    System.out.print("Enter number of pages: ");
                    int magPages = sc.nextInt();
                    System.out.print("Enter magazine ID: ");
                    int magId = sc.nextInt();
                    System.out.print("Enter issue number: ");
                    int issueNumber = sc.nextInt();
                    sc.nextLine();
                    Magazine mag = new Magazine(magTitle, magYear, magId, magPages, true, issueNumber);
                    library.addItem(mag);
                    break;

                case 3: // add journal
                    System.out.print("Enter journal title: ");
                    String journalTitle = sc.nextLine();
                    System.out.print("Enter publication year: ");
                    int journalYear = sc.nextInt();
                    System.out.print("Enter number of pages: ");
                    int journalPages = sc.nextInt();
                    System.out.print("Enter journal ID: ");
                    int journalId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter research field: ");
                    String field = sc.nextLine();
                    Journal journal = new Journal(journalTitle, journalYear, journalId, journalPages, true, field);
                    library.addItem(journal);
                    break;

                case 4:  // view available items
                    library.viewAvailableItems();
                    break;

                case 5: //lend item
                    System.out.print("Enter item type to lend (Book / Magazine / Journal): ");
                    String lendType = sc.nextLine();
                    System.out.print("Enter item title to lend: ");
                    String lendTitle = sc.nextLine();
                    System.out.print("Enter user name: ");
                    String userName = sc.nextLine();
                    System.out.print("Enter user ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter user job: ");
                    String userJob = sc.nextLine();
                    User user = new User(userName, userId, userJob);
                    library.lendItem(lendTitle, lendType, user);
                    break;

                case 6:  // receive item
                    System.out.print("Enter item title to receive: ");
                    String receiveTitle = sc.nextLine();
                    library.receiveItemFromBorrower(receiveTitle);
                    break;

                case 7: // search
                    System.out.println("Search by type (Book / Magazine / Journal):");
                    String searchType = sc.nextLine();
                    System.out.print("Enter item title to search: ");
                    String searchTitle = sc.nextLine();
                    library.searchForItem(searchTitle, searchType);
                    break;

                case 8: // report borrow items
                    library.borrowReport();
                    break;

                case 9: // summary report
                    library.summaryReport();
                    break;

                case 10:
                    System.out.println("Exiting system.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}