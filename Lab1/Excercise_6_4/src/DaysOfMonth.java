
import javax.swing.*;
import java.util.*;

public class DaysOfMonth {

    public static boolean checkLeapYear(int n) {
        if (n % 100 == 0) {
            if (n % 400 == 0)
                return true;
            else
                return false;
        } else {
            if (n % 4 == 0)
                return true;
            else
                return false;
        }
    }

    public static boolean checkContain(String[] arr, String s) {
        for (int i = 0; i < arr.length; ++i) {
            if (s.equals(arr[i]))
                return true;
        }
        return false;
    }

    public static boolean checkContain(int[] arr, int s) {
        for (int i = 0; i < arr.length; ++i) {
            if (s == arr[i])
                return true;
        }
        return false;
    }

    public static int checkValidMonth(String s) {

        // Initialize
        String[] month = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        String[] abbreviation = { "Jan.", "Feb.", "Mar.", "Apr.", "May", "June", "July", "Aug.", "Sept.", "Oct.",
                "Nov.", "Dec." };
        String[] threeLetters = { "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov",
                "Dec" };
        String[] monthNumber = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

        boolean checkStatus = checkContain(month, s) ||
                checkContain(abbreviation, s) ||
                checkContain(threeLetters, s) ||
                checkContain(monthNumber, s);

        if (checkStatus == false)
            return -1;

        if (checkContain(month, s) == true)
            return Arrays.asList(month).indexOf(s) + 1;
        else if (checkContain(abbreviation, s) == true)
            return Arrays.asList(abbreviation).indexOf(s) + 1;
        else if (checkContain(threeLetters, s) == true)
            return Arrays.asList(threeLetters).indexOf(s) + 1;
        else
            return Arrays.asList(monthNumber).indexOf(s) + 1;
    }

    public boolean checkValidYear(String s) {
        try {
            int year = Integer.parseInt(s);
            if (year < 0)
                return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        DaysOfMonth day = new DaysOfMonth();
        String year, month;
        int numMonth;

        // Input Month
        while (true) {
            month = JOptionPane.showInputDialog(null, "Enter the month: ");
            numMonth = checkValidMonth(month);
            if (numMonth == -1) {
                JOptionPane.showMessageDialog(null, "You've enter a not valid month. Please try again!");
                continue;
            } else
                break;
        }

        // Input Year
        while (true) {
            year = JOptionPane.showInputDialog("Enter the year: ");
            if (day.checkValidYear(year) == false) {
                JOptionPane.showMessageDialog(null, "You've enter a not valid month. Please try again!");
                continue;
            } else
                break;
        }

        // Main process

        int[] monthWith30Days = { 4, 6, 9, 11 };
        int[] monthWith31Days = { 1, 3, 5, 7, 8, 10, 12 };

        if (checkContain(monthWith31Days, numMonth)) {
            JOptionPane.showMessageDialog(null,
                    "The day in Month: " + month + "\nYear: " + Integer.parseInt(year) + "\nis: 31");
        } else {
            if (checkContain(monthWith30Days, numMonth)) {
                JOptionPane.showMessageDialog(null,
                        "The day in Month: " + month + "\nYear: " + Integer.parseInt(year) + "\nis: 30");
            } else {
                if (checkLeapYear(Integer.parseInt(year))) {
                    JOptionPane.showMessageDialog(null,
                            "The day in Month: " + month + "\nYear: " + Integer.parseInt(year) + "\nis: 29");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "The day in Month: " + month + "\nYear: " + Integer.parseInt(year) + "\nis: 28");
                }
            }
        }
    }
}
