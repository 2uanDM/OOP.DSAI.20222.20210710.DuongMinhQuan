package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    public Media() {
        super();
    }

    private int id = 0;
    private String title = "";
    private String category = "";
    private float cost = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean equals(Media product) {
        return this.getTitle() == product.getTitle();
    }

    public String toString() {
        return String.format("Title: ", this.getTitle());
    }

}
