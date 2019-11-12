package model;

import java.io.Serializable;
import java.util.Date;

import static controller.IOController.*;


public class Showtime implements Serializable {
    private Movie movie;
    private Cinema cinema;
    private Date time;
    private Seat[][] seats;

    private final static int COLS = 17;
    private final static int ROWS = 9;

    public Showtime() {
        seats = new Seat[ROWS][COLS];
        initializeSeat();
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public Seat getSeatAt(int row, int col) {
        if (row < 1 || row > 9 || col < 1 || col > 16) return null;

        if (col >= 9) col++;

        return seats[row - 1][col - 1];
    }

    public Date getTime() {
        return time;
    }

    private void initializeSeat() {
        for (int row = 0; row <= 3; row++) {
            for (int col = 2; col <= 16; col++) {
                if (col == 8) continue;
                seats[row][col] = new Seat(row, col, this);
            }
        }

        for (int row = 4; row <= 7; row++) {
            for (int col = 0; col <= 16; col++) {
                if (col == 8) continue;
                seats[row][col] = new Seat(row, col, this);
            }
        }

        for (int col = 0; col <= 16; col++) {
            if (col == 8 || col == 9 || col == 10) continue;
            seats[8][col] = new Seat(8, col, this);
        }
    }

    public String getDetails() {
        return "Cineplex: " + cinema.getCineplex() + "\n" +
                "Cinema: " + cinema.toString() + "\n" +
                "Time: " + time.toString() + "\n";
    }



    @Override
    public String toString() {
        return cinema.getCineplex().toString() + ": " + formatTimeMMddHHmm(time);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Showtime showtime = (Showtime) o;

        if (!movie.equals(showtime.movie)) return false;
        if (!cinema.equals(showtime.cinema)) return false;
        return formatTimeMMddHHmm(time).equals(formatTimeMMddHHmm(showtime.time));
    }
}
