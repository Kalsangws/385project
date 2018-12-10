
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kalsang
 */
public class User implements Serializable {
    private String username;
    private String password;
    private int phoneNumber;
    /*Constructor*/
    public User(String username, String password, int phoneNumber){
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
    public int getPhoneNumber() {
        return phoneNumber;
    }   
    /*Set methods*/
    public void setName (String username) {
        this.username = username;
    } 
    public void setPassword ( String password ) {
        this.password = password;
    } 
    public void setPhoneNumber( int phoneNumber) {
        this.phoneNumber = phoneNumber;
    } 
    
    public String toString() {
        return "username: " + username + ", password: " + password + ", phone number: " + phoneNumber;
    }
}
