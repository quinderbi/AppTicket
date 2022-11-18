package appticket;

import auth.User;
import ticket.Movie;
import ticket.Schedule;
import ticket.Seat;
import ticket.Studio;
import ticket.Ticket;
import util.Encryption;

public class AppTicket {
    private static Movie[] movies;
    private static Seat[] seats;
    private static Schedule[] schedules;
    private static Studio studio;
    private static Encryption encryption;

    public static void initDatabase() {
        movies = new Movie[10];
        seats = new Seat[5];
        schedules = new Schedule[10];

        movies[0] = new Movie("M001", "Avengers: Endgame", "Action", "Anthony Russo", 181);
        movies[1] = new Movie("M002", "Captain Marvel", "Action", "Anna Boden", 124);
        movies[2] = new Movie("M003", "Alita: Battle Angel", "Action", "Robert Rodriguez", 122);
        movies[3] = new Movie("M004", "How to Train Your Dragon: The Hidden World", "Animation", "Dean DeBlois", 104);
        movies[4] = new Movie("M005", "Toy Story 4", "Animation", "Josh Cooley", 100);
        movies[5] = new Movie("M006", "The Lion King", "Animation", "Jon Favreau", 118);

        seats[0] = new Seat("A1");
        seats[1] = new Seat("A2");
        seats[2] = new Seat("A3");
        seats[3] = new Seat("A4");
        seats[4] = new Seat("A5");

        studio = new Studio(1, seats); 

        schedules[0] = new Schedule("S001", movies[0], studio, "2019-04-26", "10:00");
        schedules[1] = new Schedule("S002", movies[1], studio, "2019-04-26", "13:00");
        schedules[2] = new Schedule("S003", movies[2], studio, "2019-04-26", "16:00");
    }

    private static void initEncryption() {
        try {
            encryption = new Encryption();
            encryption.init();
        } catch (Exception e) {
            System.out.println("Failed to init encryption " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        initEncryption();
        initDatabase();

        User user = new User(encryption);

        user.register("Ariq Heritsa", "ariqhm@gmail.com", "081808625505", "hehehe");

        boolean loggedIn = user.login("ariqhm@gmail.com", "hehehe");

        if (!loggedIn) {
            return;
        }
        
        System.out.println(schedules[0].toString());

        System.out.println();

        Ticket ticket = new Ticket("T001", user, seats[0], schedules[0], studio, "Booked");

        System.out.println(schedules[0]);

        System.out.println();

        System.out.println(ticket.toString());
    }
}
