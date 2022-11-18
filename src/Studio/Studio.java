package Studio;

import Seat.Seat;

public class Studio {
    private int studioNo;
    private Seat[] seats;

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
