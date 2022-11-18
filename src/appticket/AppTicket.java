package appticket;

import auth.User;
import util.Encryption;

public class AppTicket {
    public static void main(String[] args) {
        try {
            Encryption encryption = new Encryption();
            encryption.init();

            User user = new User(encryption);
            user.register("Ariq Heritsa", "ariqhm@gmail.com", "081808625505", "hehehe");

            user.login("ariqhm@gmail.com", "hehehe");
        } catch (Exception e) {
            System.out.println("Failed to run app: " + e.getMessage());
        }
    }
}
