package model;

import java.io.Serializable;

/**
 * This class contains information on the seat mapping of each showtime
 */
public class SeatMap implements Serializable {
    /**
     * 2D array of Seat objects
     */
    private Seat[][] seats;

    /**
     * Constructor
     */
    public SeatMap() {
        seats = new Seat[9][17];
        initializeSeat();
    }

    /**
     * This method creates the seat map
     */
    private void initializeSeat() {
        for (int row = 0; row <= 3; row++) {
            for (int col = 2; col <= 16; col++) {
                if (col == 8) continue;
                seats[row][col] = new Seat(row, col);
            }
        }

        for (int row = 4; row <= 7; row++) {
            for (int col = 0; col <= 16; col++) {
                if (col == 8) continue;
                seats[row][col] = new Seat(row, col);
            }
        }

        for (int col = 0; col <= 16; col++) {
            if (col == 8 || col == 9 || col == 10) continue;
            seats[8][col] = new Seat(8, col);
        }
    }

    /**
     * This method returns the seat map
     * @return Seat map
     */
    public Seat[][] getSeats() {
        return seats;
    }

    /**
     * This method returns the seat at specific row and column
     * @param row Row of the seat
     * @param col Column of the seat
     * @return The seat
     */
    public Seat getSeatAt(int row, int col) {
        if (row < 1 || row > 9 || col < 1 || col > 16) return null;

        if (col >= 9) col++;

        return seats[row - 1][col - 1];
    }

    /**
     * This method marks a seat as booked
     * @param seat The booked seat
     */
    public void setSeat(Seat seat) {
        seats[seat.getRow()][seat.getCol()].bookSeat();
    }
}
