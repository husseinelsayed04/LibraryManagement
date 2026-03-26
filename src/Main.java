import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Library System Setup ===");
        System.out.print("Enter librarian name: ");
        String libName = sc.nextLine();

        System.out.print("Enter librarian ID: ");
        int libId = Integer.parseInt(sc.nextLine());

        System.out.print("Enter librarian username: ");
        String libUsername = sc.nextLine();

        System.out.print("Enter librarian password: ");
        String libPassword = sc.nextLine();

        Librarian librarian = new Librarian(libName, libId, libUsername, libPassword);
        LibraryDatabase library = new LibraryDatabase(librarian);
        System.out.println("\n=== Librarian Login ===");

        boolean loggedIn = false;
        while(!loggedIn){
            System.out.print("Enter username: ");
            String inputUsername = sc.nextLine();
            System.out.print("Enter password: ");
            String inputPassword = sc.nextLine();

            if(librarian.checkLogin(inputUsername, inputPassword)){
                System.out.println("Login successful. Welcome, " + librarian.getName() + "!");
                loggedIn = true;
            } else {
                System.out.println("Invalid username or password. Try again.");
            }
        }
        boolean running = true;
        while(running) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1: Add Book");
            System.out.println("2: View Available Books");
            System.out.println("3: Lend Book");
            System.out.println("4: Receive Book");
            System.out.println("5: Search for Book");
            System.out.println("6: Borrowed Books Report");
            System.out.println("7: Summary Report");
            System.out.println("8: Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch(choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter publication year: ");
                    int year = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter book ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter number of pages: ");
                    int pages = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();

                    Book book = new Book(title, year, id, pages, true, author);
                    library.addBook(book);
                    break;

                case 2:
                    library.viewAvailableBooks();
                    break;

                case 3:
                    System.out.print("Enter book title to lend: ");
                    String lendTitle = sc.nextLine();
                    System.out.print("Enter user name: ");
                    String userName = sc.nextLine();
                    System.out.print("Enter user ID: ");
                    int userId = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter user job: ");
                    String userJob = sc.nextLine();

                    User user = new User(userName, userId, userJob);
                    library.lendBook(lendTitle, user);
                    break;

                case 4:
                    System.out.print("Enter book title to receive: ");
                    String receiveTitle = sc.nextLine();
                    library.receiveBookFromBorrower(receiveTitle);
                    break;

                case 5:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = sc.nextLine();
                    library.searchForBook(searchTitle);
                    break;

                case 6:
                    library.borrowReport();
                    break;

                case 7:
                    library.summaryReport();
                    break;

                case 8:
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }

        sc.close();
    }
}