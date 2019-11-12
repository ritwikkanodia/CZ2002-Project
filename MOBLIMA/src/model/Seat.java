package model;

import java.io.Serializable;

public class Seat implements Serializable{
    private final int row;
    private final int col;
    private final Showtime showtime;
    private boolean booked;


    public Seat(int row, int col, Showtime showtime) {
        this.row = row;
        this.col = col;
        this.showtime = showtime;
        booked = false;
    }


    public Showtime getShowtime() {
        return showtime;
    }


    public int getCol() {
        return col;
    }


    public int getRow() {
        return row;
    }


    public boolean isBooked() {
        return booked;
    }


    public void bookSeat() {
        booked = true;
    }

    @Override
    public String toString() {
        if (!booked) return "[ ]";
        else return "[*]";
    }
}
