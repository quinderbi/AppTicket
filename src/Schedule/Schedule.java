package Schedule;

import Studio.Studio;
import Movie.Movie;
import Ticket.Ticket;
import Seat.Seat;

public class Schedule {
    private String scheduleID;
    private Movie movie;
    private Studio studio;
    private String date;
    private String time;
    private Ticket[] tickets;

    public Schedule(String scheduleID, Movie movie, Studio studio, String date, String time) {
        this.scheduleID = scheduleID;
        this.movie = movie;
        this.studio = studio;
        this.date = date;
        this.time = time;
    }

    // get Available Seats
    public Seat[] getAvailableSeats() {
        Seat[] seats = studio.getSeats();
        Seat[] availableSeats = new Seat[seats.length];
        int count = 0;
        for (Seat seat : seats) {
            boolean isAvailable = true;
            for (Ticket ticket : tickets) {
                if (ticket.getSeat().getSeatID().equals(seat.getSeatID())) {
                    isAvailable = false;
                    break;
                }
            }
            if (isAvailable) {
                availableSeats[count] = seat;
                count++;
            }
        }
        return availableSeats;
    }
}