package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore;
    private int qtyItems;

    public Store() {
        itemsInStore = new ArrayList<Media>(1000);
        qtyItems = 0;
    }

    public boolean addItem(Media item) {
        for (Media media : itemsInStore) {
            if (media.equals(item)) {
                System.out.println("The item is already exist in the store");
                return false;
            }
        }
        itemsInStore.add(item);
        qtyItems++;
        System.out.println("The item has successfully added to the store");
        return true;
    }

    public boolean removeItem(Media item) {
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
}
