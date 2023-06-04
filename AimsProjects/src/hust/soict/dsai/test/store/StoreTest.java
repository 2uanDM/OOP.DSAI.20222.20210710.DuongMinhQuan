package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        
        Store myStore = new Store();

        // Create new dvd objects and add them to myStore
         DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
         myStore.addDVD(dvd1);
        
         DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
         myStore.addDVD(dvd2);
 
         DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation",18.99f);
         myStore.addDVD(dvd3);
        
         DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladanh", "Animation",18.99f);
         
        //Test remove an dvd
         myStore.removeDVD(dvd1);
         myStore.removeDVD(dvd4);
    }
}