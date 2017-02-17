package com.twu.biblioteca.model;

public class Book implements Good {

    Integer id;
    String name;
    String author;
    String published;
    //simple Status 0 means unavailable;
    int status = 1;

    public Book(Integer id, String name, String author, String published) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.published = published;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getId() {

        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!id.equals(book.id)) return false;
        if (!name.equals(book.name)) return false;
        if (!author.equals(book.author)) return false;
        return published.equals(book.published);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + published.hashCode();
        return result;
    }


    @Override
    public String getGoodDetails(){
        StringBuffer buffer = new StringBuffer();

        buffer.append("Here are details of book ");

        buffer.append(this.getId());
        buffer.append(":\nID\tName\tAuthor\tPublished Years\n");

        buffer.append(this.getId());
        buffer.append("\t");
        buffer.append(this.getName());
        buffer.append("\t");
        buffer.append(this.getAuthor());
        buffer.append("\t");
        buffer.append(this.getPublished());


        return buffer.toString();
    }
}
