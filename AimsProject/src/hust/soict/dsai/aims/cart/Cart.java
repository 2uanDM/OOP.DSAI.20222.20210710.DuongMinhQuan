<<<<<<< Updated upstream
package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;


=======
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

package hust.soict.dsai.aims.cart;
>>>>>>> Stashed changes
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered;
    private int qtyOrdered;

    public Cart() {
        itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
        qtyOrdered = 0;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full");
        } else {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been successfully added to cart");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full");
        } else {
            int dvds_qty = dvdList.length;
            if (qtyOrdered + dvds_qty > MAX_NUMBERS_ORDERED) {
                System.out.println(
                    "The number of DVDs you choose is more than the remaining slot(" + (MAX_NUMBERS_ORDERED - qtyOrdered) + ") of your cart !");
            } else {
                for (int i = 0; i < dvds_qty; i++) { 
                    itemsOrdered[qtyOrdered + i] = dvdList[i];
                }
                qtyOrdered += dvds_qty;
                System.out.println("The list of discs has been successfully added to cart");
            }
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full");
        } else {
            if (qtyOrdered + 2 > MAX_NUMBERS_ORDERED) {
                System.out.println("The cart just has only 1 remaining slot");
            } else {
                itemsOrdered[qtyOrdered] = dvd1;
                itemsOrdered[qtyOrdered + 1] = dvd2;
                qtyOrdered += 2;
                System.out.println("Two discs have been successfully added to cart");
            }
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isEqual(disc)) {
                // Shift the remaining items to fill the gap
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j+1];
                } 
                itemsOrdered[qtyOrdered-1] = null; // Remove the last reference
                qtyOrdered--;
                System.out.println("The disc has been removed from the cart");
                return; 
            }
        }
        System.out.println("The disc is not found in the card");
    }

    public double totalCost() {
        double total = 0.0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return Math.round(total * 100.0) / 100.0;
    }

    public void print() {
        System.out.println("************************************CART************************************");
        System.out.println("Ordered Items: ");
        for (int i = 0; i < qtyOrdered; i++) { 
            System.out.print(i+1);
            System.out.println(". " + itemsOrdered[i]);
        }
        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("****************************************************************************");
    }

    public void searchDVDByID(int id) {
        boolean found = false; 
        int position = 0;

        // Iterate all the items
        for (int i = 0; i < qtyOrdered; i++) { 
            if (itemsOrdered[i].getId() == id) {
                position = i;
                found = true;
                break;
            }
        }

        if (found == false) {
            System.out.println("No match is found !");
        } else { 
            System.out.println(itemsOrdered[position]);
        }
    }

    public void searchDVDByTitle(String title) {
        boolean found = false; 
        int position = 0;

        // Iterate all the items
        for (int i = 0; i < qtyOrdered; i++) { 
            if (itemsOrdered[i].getTitle().equals(title)) {
                position = i;
                found = true;
                break;
            }
        }

        if (found == false) {
            System.out.println("No match is found !");
        } else { 
            System.out.println(itemsOrdered[position]);
        }
    }

}
