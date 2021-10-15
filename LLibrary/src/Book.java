/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        04/09/2021
Instructor:  Dr. Helsing
Description: This program acts as a book node class for book title storage and count. Used by LLibrary.java
*/

public class Book {

    // Variable initialization of book title and book copy count
    private String title;
    private int bookCount;

    // Basic constructor
    public Book(String title, int bookCount){
        this.setTitle(title);
        this.setBookCount(bookCount);
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }
}
