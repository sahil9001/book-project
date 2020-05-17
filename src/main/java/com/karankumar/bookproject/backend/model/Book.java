package com.karankumar.bookproject.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

/**
 * A {@code Book} object represents a single book with its corresponding metadata, such as an Author, genre and rating
 */
@Entity
public class Book extends BaseEntity {

    @NotNull
    @NotEmpty
    private String title;

    private int numberOfPages;

    private Genre genre;

    // For books that have been read
    private RatingScale rating;
    private String favouriteQuote;
    private LocalDate dateStartedReading;
    private LocalDate dateFinishedReading;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Shelf> shelves;

    public Book() {
    }

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public RatingScale getRating() {
        return rating;
    }

    public void setRating(RatingScale rating) {
        this.rating = rating;
    }

    public String getFavouriteQuote() {
        return favouriteQuote;
    }

    public void setFavouriteQuote(String favouriteQuote) {
        this.favouriteQuote = favouriteQuote;
    }

    public Set<Shelf> getShelves() {
        return shelves;
    }

    public void setShelves(Set<Shelf> shelves) {
        this.shelves = shelves;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public LocalDate getDateStartedReading() {
        return dateStartedReading;
    }

    public void setDateStartedReading(LocalDate dateStartedReading) {
        this.dateStartedReading = dateStartedReading;
    }

    public LocalDate getDateFinishedReading() {
        return dateFinishedReading;
    }

    public void setDateFinishedReading(LocalDate dateFinishedReading) {
        this.dateFinishedReading = dateFinishedReading;
    }
}
