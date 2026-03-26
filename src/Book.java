public class Book extends LibraryItem{
    private String author;
    public Book(String title, int publication, int id, int numOfPages, boolean isAvailable , String author ){
        super(title , publication ,id ,numOfPages , isAvailable );
        this.author= author;
    }

    public String getAuthor() {
        return author;
    }
    @Override
    public void displayInfo() {
        System.out.println("Type: Book");
        System.out.println("Title: " + getTitle());
        System.out.println("ID: " + getId());
        System.out.println("Publication Year: " + getPublication());
        System.out.println("Pages: " + getNumOfPages());
        System.out.println("Available: " + isAvailable());
        System.out.println("Author: " + author);
    }
}
