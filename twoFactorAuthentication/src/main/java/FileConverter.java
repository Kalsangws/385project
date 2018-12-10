import java.util.Map;

public interface FileConverter {
    public void serializeUser (Map<String, User> manager);
    
    public void serializePad (Map<String, String> padManager);
    
    public Map<String, User> deserializeUser();
    
    public Map<String, String> deserializePad();

    public boolean doesFileExist();

    public void fileClose();
}

