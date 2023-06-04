package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore;
    private int qtyDisc;

    public Store() {
        itemsInStore = new DigitalVideoDisc[1000];
        qtyDisc = 0;
    }

    public void addDVD(DigitalVideoDisc disc) { 
        itemsInStore[qtyDisc] = disc;
        qtyDisc++;
        System.out.println("The disc has successfully added to the store");
    }

    public void removeDVD(DigitalVideoDisc disc) {
        // Search for the position of the disc in the array
        for (int i = 0; i < qtyDisc-1; i++) { 
            if (disc.isEqual(itemsInStore[i])) {
                for(int j = i; j < qtyDisc-2; j++)
                    itemsInStore[i] = itemsInStore[i+1]; // Shift the remaining items to fill the gap 
                
                itemsInStore[qtyDisc-1] = null;
                qtyDisc--;
                System.out.println("The disc has successfully removed from the store!");
                return;
            }
        }
        System.out.println("No match is found!");       
    }
}
