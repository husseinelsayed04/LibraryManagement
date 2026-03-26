public class Librarian extends Person{
    private String username;
    private String password;
    public Librarian(String name , int id ,String username, String password){
        super(name , id );
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public boolean checkLogin(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }
}

