public class TestingPassingParameter {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle DVD title: " + jungleDVD.getTitle());
        System.out.println("cinderella DVD title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object s1, Object s2) {
        Object tmp = s1; 
        s1 = s2; 
        s2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) { 
        String oldTitle = dvd.getTitle();
        dvd.setTitle((title));
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
