public class Magazine extends  LibraryItem{

    private int issueNumber;
    public Magazine(String title , int publication , int id , int numberOfPages , boolean isAvailable , int issueNumber){
        super(title , publication , id , numberOfPages , isAvailable);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }
}
