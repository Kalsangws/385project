import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhoneVerification {
    public static final String ACCOUNT_SID = "ACdfca22cd8dbe4b33add43aa3c5017ca1";
    public static final String AUTH_TOKEN = "0aa249f61cc08be388d5726ff470b96b";
    PhoneNumber sendToNumber;
    PhoneNumber sendFromNumber;
    private static final String PAD_FILE_NAME = "src/main/java/oneTimePad.txt";
    private FileConverter fileConverter;
    Hash hsh;
    Map<String, String> padManager = new HashMap();
    
    public PhoneVerification(String phoneNumber) {
        hsh = new Hash();
        sendFromNumber = new PhoneNumber("+18606064653");
        try { 
            sendToNumber = new PhoneNumber(phoneNumber); 
        }  
        catch (Exception e)  { 
            System.out.println(phoneNumber + " is not a valid phone number");
        }  
        fileConverter = new BasicFileConverter(PAD_FILE_NAME);
        try {
            BufferedReader br = new BufferedReader(new FileReader(PAD_FILE_NAME));
            if (fileConverter.doesFileExist() && br.readLine() != null) {
                Map<String, String> original = fileConverter.deserializePad();
                padManager = original == null ? new HashMap<>() : padManager;
            }
        } catch (IOException e) {
            Logger.getLogger(PhoneVerification.class.getName()).log(Level.SEVERE, "Error reading pad file", e);
        }
    }
    
    public void sendOneTimePad(User user) {
        Generator gen = new Generator();
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        try {
            String pad = gen.getSaltString();
            Message message = Message.creator(sendToNumber, sendFromNumber, pad).create();
            padManager.put(user.getUsername(), hsh.hash(pad.toString()));
            fileConverter.serializePad(padManager);
        } catch (Exception e) {
            System.out.println(sendToNumber + " is not a valid phone number");
        }
    }
    
    public void displayPadManager() {
        for (HashMap.Entry<String, String> pad : padManager.entrySet()) {
            System.out.println("Key: " + pad.getKey() + " Value: " + pad.getValue());
        }
    }
    
    public Map<String, String> getPadManager() {
        return padManager;
    }
    
    public boolean verifyPad(String username, String pad) {
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
