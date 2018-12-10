
import java.util.Random;

public class Generator {
    private int passLen = 5;
    //https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java
    public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < passLen) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}