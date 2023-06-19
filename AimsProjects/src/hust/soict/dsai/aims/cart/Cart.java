package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private List<Media> itemsOrdered;
    private int qtyOrdered;

    // Constructor
    public Cart() {
        itemsOrdered = new ArrayList<Media>(MAX_NUMBERS_ORDERED);
        qtyOrdered = 0;
    }

    public boolean addMedia(Media product) {
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full");
            return false;
        } else {
            qtyOrdered++;
            System.out.println("The product has successfully been added to cart");
            return true;
        }
    }

    public boolean removeMedia(Media product) {
        // Search for media in the cart
        for (Media media : itemsOrdered) {
            if (media.equals(product)) {
                itemsOrdered.remove(media);
                System.out.println("The product has successfully been removed from the cart");
                return true;
            }
        }
        System.out.println("There is no product match in the cart");
        return false;
    }

    public double totalCost() {
        double total = 0.0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return Math.round(total * 100.0) / 100.0;
    }

    public void information() {
        System.out.println("************************************CART************************************");
        System.out.println("Ordered Items: ");
        for (Media media : itemsOrdered) {
            int index = itemsOrdered.indexOf(media);
            System.out.println("Item " + index + ": " + media);
        }
        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("****************************************************************************");
    }

}
