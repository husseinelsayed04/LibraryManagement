public abstract class LibraryItem {
    private String title;
    private int publication;
    private int id;
    private int numOfPages;
    private boolean isAvailable;

    public LibraryItem(String title, int publication, int id, int numOfPages, boolean isAvailable) {
        this.title = title;
        this.publication = publication;
        this.id = id;
        this.numOfPages = numOfPages;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public int getPublication() {
        return publication;
    }

    public int getId() {
        return id;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("ID: " + id);
        System.out.println("Publication Year: " + publication);
        System.out.println("Pages: " + numOfPages);
        System.out.println("Available: " + isAvailable);
    }
}