package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestingPassingParameter {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        Object[] dvdArray = { jungleDVD, cinderellaDVD };
        swap(dvdArray);

        jungleDVD = (DigitalVideoDisc) dvdArray[0];
        cinderellaDVD = (DigitalVideoDisc) dvdArray[1];

        System.out.println("jungle DVD title: " + jungleDVD.getTitle());
        System.out.println("cinderella DVD title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object[] array) {
        Object tmp = array[0];
        array[0] = array[1];
        array[1] = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle((title));
        // dvd = new DigitalVideoDisc(oldTitle);
    }
}
