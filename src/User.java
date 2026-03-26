public class User extends  Person{
    private String job;
    public User(String name , int id , String job){
        super(name , id);
        this.job = job;
    }

    public String getJob() {
        return job;
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Job: " + getJob());
    }

}
