/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        05/14/2021
Instructor:  Dr. Helsing
Description: This program is for creation of Music type objects for use by DataManager.java, is a
             subclass of Item.java
*/

public class Music extends Item {
    private String musicArtist; // The music artist
    private int musicSongCount; // The number of songs

    // Music constructor
    public Music(int musicID, String musicName, String musicArtist, String musicGenre, int musicSongCount, int musicCopies) {
        super(musicID, "Music", musicName, musicGenre, musicCopies);
        this.musicArtist = musicArtist;
        this.musicSongCount = musicSongCount;
    }

    // Getters and Setters

    public String getMusicArtist() {
        return musicArtist;
    }

    public void setMusicArtist(String musicArtist) {
        this.musicArtist = musicArtist;
    }

    public int getMusicSongCount() {
        return musicSongCount;
    }

    public void setMusicSongCount(int musicSongCount) {
        this.musicSongCount = musicSongCount;
    }
}