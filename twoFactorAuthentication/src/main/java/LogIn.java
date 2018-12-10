
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ha
 */
public class LogIn {

    private Map<String, User> manager = new HashMap<>();
    Hash hsh;
    UserRepository ur;
    PhoneVerification pv;
    User user;
    
    public LogIn(UserRepository ur, User user) {
        hsh = new Hash();
        this.ur = ur;
        this.user = user;
        pv = new PhoneVerification(user.getPhoneNumber());
    }
    
    public boolean firstFactorVerify(String username, String password) {
        Map<String, User> manager = ur.getManager();
        if (!manager.containsKey(username)) {
            System.out.println("This username does not exist");
            return false;
        } else {
            if (manager.get(username).getPassword().equals(hsh.hash(password)))
                return true;
            else {
                System.out.println("Wrong password");
                return false;
            }
        }
    }
    
    public boolean verifyPad(PhoneVerification pv, String username, String pad) {
        Map<String, String> padManager = pv.getPadManager();
        if (!padManager.containsKey(username)) {
            System.out.println("This username does not exist");
            return false;
        } else {
            if (padManager.get(username).equals(hsh.hash(pad)))
                return true;
            else {
                System.out.println("Wrong pad");
                return false;
            }
        }
    }
}
