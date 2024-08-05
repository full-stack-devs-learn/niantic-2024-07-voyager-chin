package com.niantic.part_1_sakila_dtos;

public class Film
{
    // Declare private variables for Film data
    private int filmId;
    private String title;
    private String description;
    private int releaseYear;
    private int languageId;
    private int rentalDuration;
    private double rentalRate;
    private int length;
    private double replacementCost;
    private String rating;
    private String specialFeatures;

    // Parameterless constructor:
    public Film()
    {

    };

    // Parameterized constructor:
    public Film(int filmId, String title, String description, int releaseYear, int languageId, int rentalDuration, double rentalRate, int length, double replacementCost, String rating, String specialFeatures)
    {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.languageId = languageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.specialFeatures = specialFeatures;
    }

    // Public 'getters' and 'setters':
    public int getFilmId() { return filmId; }

    public void setFilmId(int filmId) { this.filmId = filmId; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getReleaseYear() { return  releaseYear; }

    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }

    public int getLanguageId() { return languageId; }

    public void setLanguageId(int languageId) { this.languageId = languageId; }

    public int getRentalDuration() { return rentalDuration; }

    public void setRentalDuration(int rentalDuration) { this.rentalDuration = rentalDuration; }

    public double getRentalRate() { return rentalRate; }

    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }

    public int getLength() { return length; }

    public void setLength(int length) { this.length = length; }

    public double getReplacementCost() { return replacementCost; }

    public void setReplacementCost(double replacementCost) { this.replacementCost = replacementCost; }

    public String getRating() { return rating; }

    public void setRating(String rating) { this.rating = rating; }

    public String getSpecialFeatures() { return specialFeatures; }

    public void setSpecialFeatures(String specialFeatures) {this.specialFeatures = specialFeatures; }
}
