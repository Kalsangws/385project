import java.util.Map;

public interface FileConverter {
    public void serializeUser (Map<String, User> manager);

    public Map<String, User> deserializeUser();

    public boolean doesFileExist();

    public void fileClose();
}

