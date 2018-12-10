import java.io.*;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BasicFileConverter implements FileConverter {

    private String fileName;
    private File file;
    private boolean fileExisted = false;

    public BasicFileConverter(String fileName) {
        this.fileName = fileName;
        this.file = new File(fileName);
        try {
            fileExisted = !this.file.createNewFile();
        } catch (IOException e) {
            Logger.getLogger(BasicFileConverter.class.getName()).log(Level.SEVERE, "Error initializing file converter", e);
        }
    }

    public boolean doesFileExist() {
        return fileExisted;
    }

    public void serializeUser(Map<String, User> manager) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName, false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(manager);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            Logger.getLogger(BasicFileConverter.class.getName()).log(Level.SEVERE, "Error serializing the user map", e);
        }
    }
    
    public void serializePad(Map<String, String> padManager) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName, false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(padManager);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            Logger.getLogger(BasicFileConverter.class.getName()).log(Level.SEVERE, "Error serializing the pad map", e);
        }
    }

    public Map<String, User> deserializeUser() {
        Map<String, User> manager = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            manager = (Map<String, User>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(BasicFileConverter.class.getName()).log(Level.SEVERE, "Error deserializing the user map", e);
        }
        return manager;
    }

    public Map<String, String> deserializePad() {
        Map<String, String> padManager = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            padManager = (Map<String, String>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(BasicFileConverter.class.getName()).log(Level.SEVERE, "Error deserializing the pad map", e);
        }
        return padManager;
    }
    
    public void fileClose() {
        this.file.delete();
    }
}
