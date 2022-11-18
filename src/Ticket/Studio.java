package ticket;

public class Studio {
    private int studioNo;
    private Seat[] seats;

    public Studio(int studioNo, Seat[] seats) {
        this.studioNo = studioNo;
        this.seats = seats;
    }

    public int getStudioNo() {
        return studioNo;
    }

    public void setStudioNo(int studioNo) {
        this.studioNo = studioNo;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public void setSeats(Seat[] seats) {
        this.seats = seats;
    }
}
