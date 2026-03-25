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
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Author: " + getAuthor());
    }
}
