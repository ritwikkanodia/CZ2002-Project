package controller;

import model.*;

import java.io.IOException;
import java.util.*;


/**
 * This class handles all the read from and write to specific files
 */
public class FileReadWriteController {

    /**
     * File path to store list of cinemas
     */
    static String FILENAME_CINEMA = "src/data/cinemaList.dat";
    /**
     * File path to store showtime
     */
    static String FILENAME_SHOWTIME = "src/data/movieShowTime.dat";
    /**
     * File path to store list of movies
     */
    static String FILENAME_MOVIE = "src/data/movieListing.dat";
    /**
     * File path to store review
     */
    static String FILENAME_REVIEWLIST = "src/data/reviewList.dat";
    /**
     * File path to store booking history
     */
    static String FILENAME_BOOKINGHISTORY = "src/data/bookingHistory.dat";
    /**
     * File path to store ticket price setting
     */
    static String FILENAME_TICKETPRICESETTING = "src/data/ticketPriceSetting.dat";

    static String FILENAME_HOLIDAYLIST = "src/data/holidayList.dat";




    /**
     * List of bookings
     */
    static ArrayList<Booking> bookingHistory = new ArrayList<Booking>() ;
    /**
     * List of movies
     */
    static ArrayList <Movie> movieList = new ArrayList <Movie>();
    /**
     * Hashmap of cineplexes name as key and list of cinema objects as value
     */
    static HashMap<String, ArrayList<Cinema>> cinemaList = new HashMap<String, ArrayList<Cinema>>();
    /**
     * Hashmap of Movie objects as key and list of Show objects as value
     */
    static HashMap<Movie, ArrayList<Show>> movieShowtime = new HashMap<Movie, ArrayList<Show>>();
    /**
     * Hashmap of Movie objects as key and list of Review objects as value
     */
    static HashMap<Movie, ArrayList<Review>> reviewList = new HashMap<Movie, ArrayList<Review>>();
    /**
     * List of price setting
     */
    static ArrayList<Double> priceSettingList = new ArrayList<Double>();

    static ArrayList<Date> holidayList = new ArrayList<Date>();



    /**
     * This method reads the list of movies from file FILENAME_MOVIE
     * @return All movies from file
     * @throws IOException when cannot find file
     */
    public static ArrayList <Movie> readMovieList() throws IOException{
        if (DataController.readSerializedObject(FILENAME_MOVIE) == null) movieList = new ArrayList<>();
        else {
            movieList = (ArrayList<Movie>)DataController.readSerializedObject(FILENAME_MOVIE);
            // sort listing by movie status
            Collections.sort(movieList, Comparator.comparing(o -> o.getShowingStatus()));
        }
        return movieList;
    }


    /**
     * This method reads the list of cinemas from file FILENAME_CINEMA
     * @return All cinemas from file
     * @throws IOException when cannot find file
     */
    public static HashMap<String, ArrayList<Cinema>> readCinemaList() throws IOException{
        if (DataController.readSerializedObject(FILENAME_CINEMA) == null) cinemaList = new HashMap<>();
        else {
            cinemaList = (HashMap<String, ArrayList<Cinema>>)DataController.readSerializedObject(FILENAME_CINEMA);
        }
        return cinemaList;
    }


    /**
     * This method reads the showtimes of movie from file FILENAME_SHOWTIME
     * @return Hashmap with Movie objects as keys and list of showtimes as values
     * @throws IOException when cannot find file
     */
    public static HashMap<Movie, ArrayList<Show>> readShowTime() throws IOException{
        if (DataController.readSerializedObject(FILENAME_SHOWTIME) == null) movieShowtime = new HashMap<>();
        else {
            movieShowtime = (HashMap<Movie, ArrayList<Show>>) DataController.readSerializedObject(FILENAME_SHOWTIME);

        }
        return movieShowtime;
    }

    /**
     * This method reads the reviews of movie from file FILENAME_REVIEWLIST
     * @return Hashmap with Movie objects as keys and list of reviews as values
     * @throws IOException when cannot find file
     */
    public static HashMap<Movie, ArrayList<Review>> readReviewList() throws IOException{
        if (DataController.readSerializedObject(FILENAME_REVIEWLIST) == null) reviewList = new HashMap<>();
        else
            reviewList =  (HashMap<Movie, ArrayList<Review>>) DataController.readSerializedObject(FILENAME_REVIEWLIST);
        return reviewList;
    }

    /**
     * This method reads the list of bookings from file FILENAME_BOOKINGHISTORY
     * @return List of bookings
     * @throws IOException when cannot find file
     */
    public static ArrayList<Booking> readBookingHistory() throws IOException {
        if (DataController.readSerializedObject(FILENAME_BOOKINGHISTORY) == null) bookingHistory = new ArrayList<Booking>();
        else
            bookingHistory =  (ArrayList<Booking>) DataController.readSerializedObject(FILENAME_BOOKINGHISTORY);
        return bookingHistory;
    }

    /**
     * This method reads the list of price setting from file FILENAME_TICKETPRICESETTING
     * @return All price settings from file
     * @throws IOException when cannot find file
     */
    public static ArrayList <Double> readPriceSetting() throws IOException{
        if (DataController.readSerializedObject(FILENAME_TICKETPRICESETTING) == null) priceSettingList = new ArrayList<>();
        else {
            priceSettingList = (ArrayList<Double>)DataController.readSerializedObject(FILENAME_TICKETPRICESETTING);
        }
        return priceSettingList;
    }

    public static ArrayList <Date> readHolidayList() throws IOException{
        if (DataController.readSerializedObject(FILENAME_HOLIDAYLIST) == null) holidayList = new ArrayList<>();
        else {
            holidayList = (ArrayList<Date>)DataController.readSerializedObject(FILENAME_HOLIDAYLIST);
        }
        return holidayList;
    }


    /**
     * This method write the list of movies to file FILENAME_MOVIE
     * @param movieList List of movies
     * @throws IOException when cannot find file
     */
    public static void writeMovieList(ArrayList <Movie> movieList) throws IOException
    {
        DataController.writeSerializedObject(FILENAME_MOVIE, movieList);
    }

    /**
     * This method write the list of cinemas to file FILENAME_CINEMA
     * @param cinemaList List of cinemas
     * @throws IOException when cannot find file
     */
    public static void writeCinemaList(HashMap<String, ArrayList<Cinema>> cinemaList) throws IOException
    {
        DataController.writeSerializedObject(FILENAME_CINEMA, cinemaList);
    }

    /**
     * This method write the showtimes list to file FILENAME_SHOWTIME
     * @param movieShowTime Hashmap with Movie objects as key and list of showtimes as value
     * @throws IOException when cannot find file
     */
    public static void writeMovieShowList(HashMap<Movie, ArrayList<Show>> movieShowTime) throws IOException
    {
        DataController.writeSerializedObject(FILENAME_SHOWTIME, movieShowTime);
    }

    /**
     * This method write the list of review to file FILENAME_REVIEWLIST
     * @param reviewList Hashmap with Movie objects as key and list of reviews as value
     * @throws IOException when cannot find file
     */
    public static void writeReviewList(HashMap<Movie, ArrayList<Review>> reviewList) throws IOException {
        DataController.writeSerializedObject(FILENAME_REVIEWLIST, reviewList);
    }


    /**
     * This method write the list of bookings to file FILENAME_BOOKINGHISTORY
     * @param bookingHistory List of bookings
     * @throws IOException when cannot find file
     */
    public static void writeBookingHistory(ArrayList <Booking> bookingHistory) throws IOException
    {
        DataController.writeSerializedObject(FILENAME_BOOKINGHISTORY, bookingHistory);
    }

    /**
     * This method write the list of price setting to file FILENAME_TICKETPRICESETTING
     * @param priceSettingList List of price setting
     * @throws IOException when cannot find file
     */
    public static void writePriceSetting(ArrayList <Double> priceSettingList) throws IOException
    {
        DataController.writeSerializedObject(FILENAME_TICKETPRICESETTING, priceSettingList);
    }

    public static void writeHolidayList(ArrayList <Date> holidayList) throws IOException
    {
        DataController.writeSerializedObject(FILENAME_HOLIDAYLIST, holidayList);
    }
}
