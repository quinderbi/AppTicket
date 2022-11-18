package ticket;

import auth.User;

public class Ticket {
    private String ticketID;
    private User user;
    private Seat seat;
    private Schedule schedule;
    private Studio studio;
    private String status;

    public Ticket(String ticketID, User user, Seat seat, Schedule schedule, Studio studio, String status) {
        this.ticketID = ticketID;
        this.user = user;
        this.seat = seat;
        this.schedule = schedule;
        this.studio = studio;
        this.status = status;

        schedule.addTicket(this);
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket " + this.ticketID + " " + this.status + "\n" + this.schedule.getMovie().getTitle() + " "
                + this.schedule.getDateTime() + "\nSeat: " + this.seat.getSeatID() + "\nCustomer: "
                + this.user.getName();
    }
}