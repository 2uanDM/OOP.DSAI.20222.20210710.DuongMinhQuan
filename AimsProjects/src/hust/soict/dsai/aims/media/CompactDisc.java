package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist = "";
    private ArrayList<Track> tracks = new ArrayList<Track>();

    // Constructor
    public CompactDisc() {
        super();
    }

    public CompactDisc(int id, String title, String category, float cost, String director, int length) {
        this.setId(id);
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        this.setDirector(director);
        this.setLength(length);
    }

    public CompactDisc(String title) {
        this.setTitle(title);
    }

    // Getter and Setter
    public int getLength() {
        int res = 0;
        for (Track track : tracks) {
            int length = track.getLength();
            res += length;
        }
        return res;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public boolean addTrack(Track track) {
        for (Track name : tracks) {
            if (track.equals(name)) {
                return false;
            }
        }
        tracks.add(track);
        return true;
    }

    public boolean removeTrack(Track track) {
        for (Track name : tracks) {
            if (track.equals(name)) {
                tracks.remove(track);
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return String.format(
                "Class: %s,Id: %d,Title: %s, Artist : %s, Category: %s, Director: %s, Cost: %f, Length: %d",
                this.getClass(), this.getId(), this.getTitle(), this.getArtist(), this.getCategory(),
                this.getDirector(), this.getCost(), this.getLength());
    }

    public void play() {
        for (Track track : tracks) {
            track.play();
        }
    }
}
