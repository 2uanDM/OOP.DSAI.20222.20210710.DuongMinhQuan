package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered;

    // Constructor
    public Cart() {
        itemsOrdered = new ArrayList<Media>(MAX_NUMBERS_ORDERED);
    }

    // Getter and Setter
    public ArrayList<Media> getItemsOrdered() {
        return this.itemsOrdered;
    }

    public int qtyOrdered() {
        return this.itemsOrdered.size();
    }

    public boolean addMedia(Media item) {
        if (this.qtyOrdered() == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full");
            return false;
        } else {
            itemsOrdered.add(item);
            System.out.println("The item has successfully been added to cart");
            return true;
        }
    }

    public boolean removeMedia(Media item) {
        // Search for media in the cart
        for (Media media : itemsOrdered) {
            if (media.equals(item)) {
                itemsOrdered.remove(media);
                System.out.println("The item has successfully been removed from the cart");
                return true;
            }
        }
        System.out.println("There is no item match in the cart");
        return false;
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

    public void sortTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }

    public void sortCost() {
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }

    public double totalCost() {
        double total = 0.0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return Math.round(total * 100.0) / 100.0;
    }

    public void displayCart() {
        System.out.println("------Items in Cart-------");

        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
    }

    public void emptyCart() {
        this.itemsOrdered = new ArrayList<Media>();
    }

    // public void information() {
    // System.out.println("************************************CART************************************");
    // System.out.println("Ordered Items: ");
    // for (Media media : itemsOrdered) {
    // int index = itemsOrdered.indexOf(media);
    // System.out.println("Item " + index + ": " + media);
    // }
    // System.out.println("Total cost: " + totalCost() + "$");
    // System.out.println("****************************************************************************");
    // }

}
