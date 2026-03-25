public class Journal extends LibraryItem {
    private String researchField;

    public Journal(String title, int publication, int id, int pages, boolean isAvailable, String researchField) {
        super(title, publication, id, pages, isAvailable);
        this.researchField = researchField;
    }

    public String getResearchField() {
        return researchField;
    }

    public void displayInfo(){
        super.displayInfo();
        System.out.println("Research Field:" + getResearchField() );

    }
}