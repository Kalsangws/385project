/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ha
 */
public class UserRepositoryTester {
    public static void main (String[] args) {
       UserRepositoryTester urt = new UserRepositoryTester();
        UserRepository ur = new UserRepository();
        urt.testAddUser(ur); 
        urt.testUpdateUser(ur);
        urt.testDeleteUser(ur);
        urt.testRetrieveUser(ur);
    }
    
    private void testAddUser(UserRepository ur) {
        System.out.println("--- TEST ADD USER ---");
        ur.createUser("user1","pw1",123);
        ur.createUser("user2","pw2",1234);
        ur.createUser("user3","pw3",12345);
        ur.createUser("user2", "pw4", 123456);
        ur.createUser("user5", "pw5", 123);
    }
    
    private void testUpdateUser(UserRepository ur) {
        System.out.println("\n--- TEST UPDATE USER ---");
        ur.updateUser("user1", "updatedPw", 123);
        ur.updateUser("user2", "updatedPw2", 12345);
    }
    
    private void testDeleteUser(UserRepository ur) {
        System.out.println("\n--- TEST DELETE USER ---");
        ur.deleteUser("user2");       
    }
    
    private void testRetrieveUser(UserRepository ur) {
        System.out.println("\n--- TEST RETRIEVE USER ---");
        System.out.println("Retrieve: " + ur.retrieveUser("user1"));
    }
}
