package com.twu.biblioteca.model;

public class Movie implements Good {

    private Integer id;
    private String name;
    private String year;
    private String director;
    private Integer rating;
    private Integer status = 1;
    private String borrowerID;

    public Movie(Integer id, String name, String year, String director, Integer rating) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String getGoodDetails() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("Here are details of movie ");

        buffer.append(this.getId());
        buffer.append(":\nID\tName\tDirector\tPublished Years\tRating\n");

        buffer.append(this.getId());
        buffer.append("\t");
        buffer.append(this.getName());
        buffer.append("\t");
        buffer.append(this.director);
        buffer.append("\t");
        buffer.append(this.year);
        buffer.append("\t");
        buffer.append(this.rating);

        return buffer.toString();
    }

    @Override
    public int getStatus() {
        return this.status;
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getBorrowerID() {

        return borrowerID;
    }

    @Override
    public String setBorrowerID(String borrowerID) {
        this.borrowerID = borrowerID;
        return null;
    }

}
