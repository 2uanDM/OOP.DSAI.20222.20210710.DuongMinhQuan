package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private Cart cart;
    private Store store;

    public Aims(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
    }

    public Aims() {
        cart = new Cart();
        store = new Store();
    }

    public static void showMenu() {
        System.out.println("------AIMS-------: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("------Store Menu-------");
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("------Media detail------");
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("-------Cart detail------");
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public void selectInMenu() {
        showMenu();
        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();
        switch (selection) {
            case 0: {
                System.out.println("Thank you, see you again!");
                System.exit(0);
                break;
            }
            case 1: {
                store.available();
                selectInStoreMenu();
                break;
            }
            case 2: {
                System.out.println("Add(a) or Remove(r) item in Store?");
                String select = scanner.next();

                if (select.equals("r")) {
                    System.out.println("Enter title of media");
                    String title = scanner.next();
                    Media x = store.searchByTitle(title);
                    store.removeMedia(x);
                } else if (select.equals("a")) {
                    System.out.println("Enter type of media:");
                    String type = scanner.next();
                    if (type.equals("CD")) {
                        System.out.println("Enter title of CD:");
                        String title = scanner.next();
                        Media x = new CompactDisc(title);
                        store.addMedia(x);
                    } else if (type.equals("DVD")) {
                        System.out.println("Enter title of DVD: ");
                        String title = scanner.next();
                        Media x = new DigitalVideoDisc(title);
                        store.addMedia(x);
                    } else {
                        System.out.println("Enter title of Book:");
                        String title = scanner.next();
                        Media x = new Book(title);
                        store.addMedia(x);
                    }
                }
                selectInMenu();
                break;
            }
            case 3: {
                cart.displayCart();
                selectInCartMenu();
                break;
            }
        }
    }

    public void selectInStoreMenu() {
        storeMenu();
        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();
        switch (selection) {
            case 0:
                selectInMenu();
                break;
            case 1: {
                System.out.println("Enter title: ");
                String title = scanner.next();
                Media x = store.searchByTitle(title);
                if (x != null) {
                    System.out.println(x.toString());
                    selectInMediaDetailsMenu(x);
                } else {
                    System.out.println("not found, please re-enter!");
                    selectInStoreMenu();
                }
                break;
            }
            case 2: {
                System.out.println("Title of media:");
                String title = scanner.next();
                Media x = store.searchByTitle(title);
                if (x == null) {
                    System.out.println("sorry, the media is not in the store.");
                } else {
                    cart.addMedia(x);
                    store.removeMedia(x);
                }
                selectInStoreMenu();
                break;
            }
            case 3: {
                System.out.println("Title of media:");
                String title = scanner.next();
                Media x = store.searchByTitle(title);
                if (x != null) {
                    if (x instanceof DigitalVideoDisc) {
                        DigitalVideoDisc x_dvd = (DigitalVideoDisc) x;
                        x_dvd.play();
                    } else if (x instanceof CompactDisc) {
                        CompactDisc x_cd = (CompactDisc) x;
                        x_cd.play();
                    } else {
                        System.out.println("Book cannot play!");
                    }
                } else {
                    System.out.println("Your media is not in the store");
                }
                selectInStoreMenu();
                break;
            }
            case 4: {
                cart.displayCart();
                selectInStoreMenu();
                break;
            }
            default: {
                System.out.println("The selection is invalid!");
                selectInStoreMenu();
            }
        }
    }

    public void selectInMediaDetailsMenu(Media x) {
        mediaDetailsMenu();
        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();
        switch (selection) {
            case 0:
                selectInStoreMenu();
                break;
            case 1: {
                boolean flag = cart.addMedia(x);
                if (flag) {
                    System.out.println(String.format("Number of medias: %d", cart.getItemsOrdered().size()));
                }
                selectInStoreMenu();
                break;
            }
            case 2: {
                if (x instanceof DigitalVideoDisc) {
                    DigitalVideoDisc x_dvd = (DigitalVideoDisc) x;
                    x_dvd.play();
                } else if (x instanceof CompactDisc) {
                    CompactDisc x_cd = (CompactDisc) x;
                    x_cd.play();
                } else {
                    System.out.println("Book cannot play! Try again!");
                }
                selectInStoreMenu();
                break;
            }
            default: {
                System.out.println("The selection is invalid!");
                selectInMediaDetailsMenu(x);
                break;
            }
        }
    }

    public void selectInCartMenu() {
        int select;
        cartMenu();
        Scanner scanner = new Scanner(System.in);
        select = scanner.nextInt();
        switch (select) {
            case 0: {
                selectInMenu();
                break;
            }
            case 1: {
                System.out.println("Enter choice: cost or title ? :");
                String choice = scanner.next();
                if (choice.equals("title")) {
                    System.out.println("Enter the title:");
                    String title = scanner.next();
                    for (Media media : cart.getItemsOrdered()) {
                        if (media.getTitle().equals(title)) {
                            System.out.println(media.toString());
                        }
                    }
                } else {
                    System.out.println("Enter the cost:");
                    float cost = scanner.nextFloat();
                    for (Media media : cart.getItemsOrdered()) {
                        if (media.getCost() == cost) {
                            System.out.println(media.toString());
                        }
                    }
                }
                selectInCartMenu();
                break;
            }
            case 2: {
                System.out.println("Enter choice: cost or title ?:");
                String choice = scanner.next();
                if (choice.equals("cost")) {
                    cart.sortCost();
                    System.out.println("Successfully sorted by cost");
                } else if (choice.equals("title")) {
                    cart.sortTitle();
                    System.out.println("Successfully sorted by title");
                }
                selectInCartMenu();
                break;
            }
            case 3: {
                System.out.println("Enter title of Media: ");
                String media = scanner.next();
                Media x = cart.searchByTitle(media);
                if (x != null) {
                    cart.removeMedia(x);
                    store.addMedia(x);
                    selectInMenu();
                } else {
                    System.out.println("The media is not in the cart");
                    selectInCartMenu();
                }
                break;
            }
            case 4: {
                System.out.println("Title of media:");
                String title = scanner.next();
                Media x = store.searchByTitle(title);
                if (x != null) {
                    if (x instanceof DigitalVideoDisc) {
                        DigitalVideoDisc x_dvd = (DigitalVideoDisc) x;
                        x_dvd.play();
                    } else if (x instanceof CompactDisc) {
                        CompactDisc x_cd = (CompactDisc) x;
                        x_cd.play();
                    } else {
                        System.out.println("Book cannot play!");
                    }
                } else {
                    System.out.println("Your media is not in the store");
                }
                selectInCartMenu();
                break;
            }
            case 5: {
                System.out.println("An order is created");
                cart.emptyCart();
                selectInMenu();
                break;
            }
        }
    }

    public static void main(String[] args) {
        Book book1 = new Book("book1");
        Book book2 = new Book("book2");
        Cart cart = new Cart();
        Store store = new Store();
        store.addMedia(book1);
        store.addMedia(book2);
        Aims aims = new Aims(cart, store);
        aims.selectInMenu();
    }
}
