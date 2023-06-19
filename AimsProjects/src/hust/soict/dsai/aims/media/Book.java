package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<String>();

    // Constructor
    public Book(int id, String title, String category, float cost) {
        this.setId(id);
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
    }

    public Book(String title) {
        this.setTitle(title);
    }

    // toString()
    public String toString() {
        return String.format("Class: %s, Title: %s, Category: %s, Cost: %f",
                this.getClass(), this.getTitle(), this.getCategory(), this.getCost());
    }

    public boolean addAuthor(String author) {
        for (String name : authors) {
            if (author.equals(name)) {
                System.out.println(author + " author is already in the list");
                return false;
            }
        }
        authors.add(author);
        return true;
    }

    public boolean removeAuthor(String author) {
        for (String name : authors) {
            if (author.equals(name)) {
                authors.remove(name);
                return true;
            }
        }
        return false;
    }

}
