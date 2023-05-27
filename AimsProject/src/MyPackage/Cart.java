package MyPackage;

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
            System.out.println("The disc has been added to cart");
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

    public void getItemsOrdered() {
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc disc = itemsOrdered[i];
            System.out.println("-------------------------------");
            System.out.println("Disc " + (i+1) + ":");
            System.out.println("Title: " + disc.getTitle()); 
            System.out.println("Category: " + disc.getCategory()); 
            System.out.println("Director: " + disc.getDirector()); 
            System.out.println("Cost: " + disc.getCost()); 
            System.out.println("Length: " + disc.getLength()); 
        }
    }

}
