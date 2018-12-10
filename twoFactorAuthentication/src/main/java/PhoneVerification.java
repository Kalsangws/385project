import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

// this code is from twilio
public class PhoneVerification {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "ACdfca22cd8dbe4b33add43aa3c5017ca1";
  public static final String AUTH_TOKEN = "0aa249f61cc08be388d5726ff470b96b";

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    PasswordGenerator pg = new BasicPasswordGenerator();
    
    Message message = Message.creator(new PhoneNumber("+17185935682"),
        new PhoneNumber("+18606064653"), 
        pg.executeDefault(6)).create();

    System.out.println(message.getSid());
  }
}
