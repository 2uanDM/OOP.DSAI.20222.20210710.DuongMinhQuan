package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private int length = 0;
    private String director = "";

    public Disc() {
        super();
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
