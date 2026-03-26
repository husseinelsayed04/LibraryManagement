public class Magazine extends  LibraryItem{

    private int issueNumber;
    public Magazine(String title , int publication , int id , int numberOfPages , boolean isAvailable , int issueNumber){
        super(title , publication , id , numberOfPages , isAvailable);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }
    @Override
    public void displayInfo() {
        System.out.println("Type: Magazine");
        System.out.println("Title: " + getTitle());
        System.out.println("ID: " + getId());
        System.out.println("Publication Year: " + getPublication());
        System.out.println("Pages: " + getNumOfPages());
        System.out.println("Available: " + isAvailable());
        System.out.println("Issue Number: " + issueNumber);
    }
}
