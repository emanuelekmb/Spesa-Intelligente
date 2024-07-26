package Articoli;

public class User {

	//attributi
    private String user;
    private String password;
    private boolean isAdmin;

    //costruttore
    
    public User(String username, String password, boolean isAdmin) {
        this.user = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //inserimento metodo get 
    public String getUsername() {
        return user;
    }

    public boolean authenticated(String password) {
        return this.password.equals(password);
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}