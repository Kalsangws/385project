/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ha
 */
public class PhoneVerificationTester {
    public static void main (String args[]) {
        User user = new User("user1", "pw1", "+18609774823");
        PhoneVerification pv = new PhoneVerification(user.getPhoneNumber());
        pv.sendOneTimePad(user);
        pv.displayPadManager();
    }
}
