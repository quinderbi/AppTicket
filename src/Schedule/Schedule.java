package Schedule;

import java.time.LocalDateTime;
import Studio.Studio;
import Movie.Movie;
import Ticket.Ticket;
import Seat.Seat;

public class Schedule {
    private String scheduleID;
    private Movie movie;
    private Studio studio;
    private LocalDateTime dateTime;
    private Ticket[] tickets;

    public Schedule(String scheduleID, Movie movie, Studio studio, String date, String time) {
        this.scheduleID = scheduleID;
        this.movie = movie;
        this.studio = studio;
        this.dateTime = LocalDateTime.parse(date + "T" + time);
        this.tickets = new Ticket[studio.getSeats().length];
    }

    
    public String getScheduleID() {
        return scheduleID;
    }
    
    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
    
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i].getSeat() == ticket.getSeat()) {
                tickets[i] = ticket;
                break;
            }
        }
    }

    // get Available Seats
    public Seat[] getAvailableSeats() {
        Seat[] availableSeats = new Seat[studio.getSeats().length];
        int count = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] == null) {
                availableSeats[count] = studio.getSeats()[i];
                count++;
            }
        }
        return availableSeats;
    }
}