
import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private String phoneNumber;
    /*Constructor*/
    public User(String username, String password, String phoneNumber){
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber; 
    }
    /*Get methods*/
    public String getUsername() {
        return username;
    }  
    public String getPassword() {
        return password;
    } 
    public String getPhoneNumber() {
        return phoneNumber;
    }   
    /*Set methods*/
    public void setName (String username) {
        this.username = username;
    } 
    public void setPassword ( String password ) {
        this.password = password;
    } 
    public void setPhoneNumber(String phoneNumber) {
        
        this.phoneNumber = phoneNumber;
    } 
    
    public String toString() {
        return "username: " + username + ", password: " + password + ", phone number: " + phoneNumber;
    }
}
