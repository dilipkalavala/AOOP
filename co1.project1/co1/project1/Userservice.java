package co1.project1;
import java.util.HashMap;
import java.util.Map;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Userservice {
	private Map<String, User> userDatabase = new HashMap<>();

    // Register a new user
    public boolean registerUser(String username, String password) {
        if (userDatabase.containsKey(username)) {
            return false; // Username already exists
        }
        String hashedPassword = hashPassword(password);
        User user = new User(username, hashedPassword);
        userDatabase.put(username, user);
        return true;
    }

    // Hashing function for password
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // Validate login
    public boolean loginUser(String username, String password) {
        User user = userDatabase.get(username);
        if (user == null) {
            return false; // User does not exist
        }
        String hashedInputPassword = hashPassword(password);
        return user.getHashedPassword().equals(hashedInputPassword);
    }

}
