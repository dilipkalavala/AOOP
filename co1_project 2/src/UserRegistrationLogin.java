import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserRegistrationLogin {
	private static final String CREDENTIALS_FILE = "credentials.txt";

    // Method for registration
    public String registerUser(String username, String password) {
        if (isUsernameTaken(username)) {
            return "Username already taken. Try a different one.";
        } else {
            saveCredentials(username, password);
            return "Registration successful!";
        }
    }

    // Method for login
    public boolean loginUser(String username, String password) {
        return authenticate(username, password);
    }

    private boolean isUsernameTaken(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(CREDENTIALS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(":");
                if (credentials[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading credentials file.");
        }
        return false;
    }

    private void saveCredentials(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CREDENTIALS_FILE, true))) {
            writer.write(username + ":" + password);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to credentials file.");
        }
    }

    private boolean authenticate(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(CREDENTIALS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(":");
                if (credentials[0].equals(username) && credentials[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading credentials file.");
        }
        return false;
    }
	

}
