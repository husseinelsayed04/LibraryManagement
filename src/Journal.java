public class Journal extends LibraryItem {
    private String researchField;

    public Journal(String title, int publication, int id, int pages, boolean isAvailable, String researchField) {
        super(title, publication, id, pages, isAvailable);
        this.researchField = researchField;
    }

    public String getResearchField() {
        return researchField;
    }

    @Override
    public void displayInfo() {
        System.out.println("Type: Journal");
        System.out.println("Title: " + getTitle());
        System.out.println("ID: " + getId());
        System.out.println("Publication Year: " + getPublication());
        System.out.println("Pages: " + getNumOfPages());
        System.out.println("Available: " + isAvailable());
        System.out.println("Research Field: " + researchField);
    }
}