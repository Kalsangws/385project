/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kalsang
 */
public class User {
    String name;
    String password;
    int phone_number;
    /*Constructor*/
    public User(String name, String password, int phone_number){
        this.name = name;
        this.password = password;
        this.phone_number = phone_number; 
    }
    /*Get methods*/
    public String getName() {
        return name;
    }  
    public String getPassword() {
        return password;
    } 
    public int getPhone_number() {
        return phone_number;
    }   
    /*Set methods*/
    public void setName ( String new_name ) {
        name = new_name;
    } 
    public void setPassword ( String new_password ) {
        password = new_password;
    } 
    public void setPhone_number( int new_phone_number) {
        phone_number = new_phone_number;
    } 
}
