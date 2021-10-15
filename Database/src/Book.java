/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        05/14/2021
Instructor:  Dr. Helsing
Description: This program is for creation of Book type objects for use by DataManager.java, is a
             subclass of Item.java
*/

public class Book extends Item {
    private String bookAuthor; // The book author
    private int bookPages;     // The number of pages in a given book

    // Book constructor
    public Book( int bookID, String bookName, String bookAuthor, String bookGenre, int bookPages, int bookCopies) {
        super(bookID, "Book",bookName,bookGenre,bookCopies);
        this.bookPages = bookPages;
        this.bookAuthor = bookAuthor;
    }

    // Getters and Setters

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookPages() {
        return bookPages;
    }

    public void setBookPages(int bookPages) {
        this.bookPages = bookPages;
    }
}
