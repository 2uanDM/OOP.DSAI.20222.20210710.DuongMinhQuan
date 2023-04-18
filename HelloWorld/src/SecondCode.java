import java.util.*;
import java.text.*;

public class SecondCode {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        NumberFormat currencyFmt = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        int items;
        double cost, total;
        System.out.print("Enter the number of item");
        items = scan.nextInt();
        System.out.print("Enter the cost per item");
        cost = scan.nextDouble();
        total = items * cost;
        System.out.println();
        System.out.println("Unformated total: " + total);
        System.out.println("Formatted total:  " + currencyFmt.format(total));

        scan.close(); //
    }
}