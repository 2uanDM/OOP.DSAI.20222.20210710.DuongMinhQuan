package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title = "";
    private int length = 0;

    // Constructor
    public Track() {
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter and Setter
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Compare function
    public boolean equals(Track track) {
        return this.getTitle() == track.getTitle() & this.getLength() == track.getLength();
    }

    // Implements
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

}
