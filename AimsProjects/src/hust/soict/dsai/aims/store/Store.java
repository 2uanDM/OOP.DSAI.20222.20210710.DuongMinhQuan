package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore;

    public int qtyItems() {
        return this.itemsInStore.size();
    }

    public Store() {
        itemsInStore = new ArrayList<Media>(1000);
    }

    public boolean addMedia(Media item) {
        for (Media media : itemsInStore) {
            if (media.equals(item)) {
                System.out.println("The item is already exist in the store");
                return false;
            }
        }
        itemsInStore.add(item);
        System.out.println("The item has successfully added to the store");
        return true;
    }

    public boolean removeMedia(Media item) {
        // Search for the position of the disc in the array
        for (Media media : itemsInStore) {
            if (media.equals(item)) {
                itemsInStore.remove(media);
                System.out.println("The item has successfully removed from the store");
                return true;
            }
        }
        System.out.println("There is no item match in the store");
        return false;
    }

    public boolean checkMedia(Media media) {
        for (Media name : itemsInStore) {
            if (media.equals(name)) {
                return true;
            }
        }
        return false;

    }

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

    public void available() {
        System.out.println("-----Items in store------");
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
    }

    public ArrayList<Media> getItemsInStores() {
        return itemsInStore;
    }

}
