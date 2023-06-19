package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist = "";
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public String toString() {
        return String.format(
                "Class: %s,Id: %d,Title: %s, Artist : %s, Category: %s, Director: %s, Cost: %f, Length: %d",
                this.getClass(), this.getId(), this.getTitle(), this.getArtist(), this.getCategory(),
                this.getDirector(), this.getCost(), this.getLength());
    }

    // Constructor
    public CompactDisc() {
        super();
    }

    public CompactDisc(String title) {
        this.setTitle(title);
    }

    public CompactDisc(int id, String title, String category, float cost, String director, int length) {
        this(title);
        this.setId(id);
        this.setCategory(category);
        this.setCost(cost);
        this.setDirector(director);
        this.setLength(length);
    }

    // Getter and Setter
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public boolean addTrack(Track newTrack) {
        for (Track track : tracks) {
            if (track.equals(newTrack)) {
                System.out.println("The track " + newTrack.getTitle() + " is already in the list");
                return false;
            }
        }
        tracks.add(newTrack);
        return true;
    }

    public boolean removeTrack(Track track) {
        for (Track name : tracks) {
            if (track.equals(name)) {
                tracks.remove(track);
                return true;
            }
        }
        System.out.println("There is no track: " + track.getTitle() + " in the list");
        return false;
    }

    public int getLength() {
        int res = 0;
        for (Track track : tracks) {
            int length = track.getLength();
            res += length;
        }
        return res;
    }

    public void play() {
        for (Track track : tracks) {
            track.play();
        }
    }
}
