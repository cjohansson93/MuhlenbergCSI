/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        05/14/2021
Instructor:  Dr. Helsing
Description: This program is for creation of Movie type objects for use by DataManager.java, is a
             subclass of Item.java
*/

public class Movie extends Item {
    private int movieLengthInMin; // Length of movie in minutes

    // Movie constructor
    public Movie( int movieID, String movieName, String movieGenre, int movieLengthInMin, int movieCopies) {
        super(movieID, "Movie",movieName,movieGenre,movieCopies);
        this.movieLengthInMin = movieLengthInMin;
    }

    // Getters and Setters

    public int getMovieLengthInMin() {
        return movieLengthInMin;
    }

    public void setMovieLengthInMin(int movieLengthInMin) {
        this.movieLengthInMin = movieLengthInMin;
    }
}