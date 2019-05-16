package com.hfad.bookapplication.model;

public class Book {

    private String id;
    private String title;
    private String author;
    private String publisher;
    private String genre;
    private double rating;

    public Book(String title, String author, String publisher, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
