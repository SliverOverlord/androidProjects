package edu.mnstate.rm8834yy.lab15recyclerview;

public class Movie {
    private String title, genre, year;

    public Movie(String title, String gener, String year){
        this.title = title;
        this.genre = gener;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String gener) {
        this.genre = gener;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
