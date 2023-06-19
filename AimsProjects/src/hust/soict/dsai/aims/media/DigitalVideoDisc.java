package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc {
    private static int nbDigitalVideoDiscs = 0;

    // Constructor
    public DigitalVideoDisc(String title) {
        this.setTitle(title);
        nbDigitalVideoDiscs += 1;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this(title);
        this.setCategory(category);
        this.setCost(cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this(title, category, cost);
        this.setDirector(director);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this(title, category, director, cost);
        this.setLength(length);
    }

    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - "
                + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$";
    }

}
