import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class UserRepository {

    private Map<String, User> manager = new HashMap<>();
 
    private String hash(String passwordToHash) {
        String hashPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte oneByte : bytes) {
                sb.append(Integer.toString((oneByte & 0xff) + 0x100, 16).substring(1));
            }
            hashPassword = sb.toString();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
        return hashPassword;
    }

    public boolean createUser(String username, String password, int phoneNumber) {
        if (!isUsernameValid(username) || !isPasswordValid(password) || !isPhoneNumberValid(phoneNumber)) {
            System.out.println("Failed to create this user: " + new User(username, password, phoneNumber));
            return false;
        }    
        manager.put(username, new User(username, hash(password), phoneNumber));
        System.out.println("Created: " + new User (username, password, phoneNumber));
        return true;
    }
    
    private boolean isUsernameValid(String username) {
        if (username == null || username.length() == 0 || manager.containsKey(username))
            return false;
        return true;
    }
    
    private boolean isPasswordValid(String password) {
        if (password == null || password.length() == 0)
            return false;
        return true;
    }

    private boolean isPhoneNumberValid(int phoneNumber) {
        for (User user : manager.values()) {
            if (user.getPhoneNumber() == phoneNumber)
                return false;
        }
        return (phoneNumber != 0);
    }
    
    public boolean updateUser(String username, String newPassword, int newPhoneNumber) {
        if (!manager.containsKey(username)) {
            System.out.println("Error in updating user: This user does not exist");
            return false;
        }
        if (manager.get(username).getPhoneNumber() != newPhoneNumber && !isPhoneNumberValid(newPhoneNumber)) {
            System.out.println("Error in updating user: The phone number already exists");
            return false;
        }
        manager.put (username, new User(username, hash(newPassword), newPhoneNumber));
        System.out.println("Updated user: " + new User(username, newPassword, newPhoneNumber));
        return true;
    }

    public boolean deleteUser(String username) {
        if (!manager.containsKey(username)) {
            System.out.println("Error in deleting user: This user does not exist");
            return false;
        }
        System.out.println("Delete: " + manager.remove(username));        
        return true;
    }
        
    public User retrieveUser(String username) {
        return manager.get(username);
    }

    public void displayManager() {
        for (HashMap.Entry<String, User> user : manager.entrySet()) {
            System.out.println("Key: " + user.getKey() + " Value: " + user.getValue());
        }
    }
}