import java.util.Scanner;


public class LogInTester {
    public static void main(String[] args) {   
        UserRepository ur = new UserRepository();
        User user = new User ("user1","pw1","+17185935682");
        ur.createUser("user1","pw1","+18609774823");
        LogIn login = new LogIn(ur,user);   
        PhoneVerification pv = new PhoneVerification(user.getPhoneNumber());
        System.out.println("Verification for user1: " + login.firstFactorVerify("user1","pw1"));
        pv.sendOneTimePad(user);
        Scanner reader = new Scanner(System.in); 
        System.out.println("Enter the one-time pad sent to your phone: ");
        String input = reader.next();
        if (login.verifyPad(pv, user.getUsername(), input))
            System.out.println("The pad is correct. You have successfully logged in!!");
        else
            System.out.println("Attempt to log in failed because the one-time pad is incorrect!");
        reader.close();
    }
}
