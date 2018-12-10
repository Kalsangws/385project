/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ha
 */
public class UserTester {
    public static void main (String[] args) {
        System.out.println("Let's test the user class.");
        User user1 = new User ("Google", "Larry Page", 12456);
        System.out.println(user1);
        User user2 = new User ("Facebook", "Mark Zuckerberg", 124567);
        System.out.println(user2);
        User user3 = new User ("Snapchat", "Evan Spiegel", 1245678);
        System.out.println(user3);
    }
}
