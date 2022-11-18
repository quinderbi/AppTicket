package auth;

import util.Encryption;

public class User {
    private String name, email, phone, password;
    private Encryption encryption;

    public User(Encryption encryption) {
        this.encryption = encryption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void register(String name, String email, String phone, String password) {
        try {
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.password = encryption.encrypt(password);
        } catch (Exception e) {
            System.out.println("Failed to register user " + e.getMessage());
        }
    }

    public void login(String email, String password) {
        try {
            if (this.email.equals(email) && encryption.decrypt(this.password).equals(password)) {
                System.out.println("Login success");
                return;
            }
            
            System.out.println("Login failed");
        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
        }
    }
}
