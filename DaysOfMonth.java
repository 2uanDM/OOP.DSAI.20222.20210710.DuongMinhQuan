import javax.swing.*;
import java.util.*;

public class DaysOfMonth {

    public boolean checkLeapYear(int n) {
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

    public boolean checkContain(String[] arr, String s) {
        for (String item : arr) {
            if (s == item)
                return true;
        }
        return false;
    }

    public int checkValidMonth(String s) {
        DaysOfMonth day = new DaysOfMonth();

        // Initialize
        String[] month = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        String[] abbreviation = { "Jan.", "Feb.", "Mar.", "Apr.", "May", "June", "July", "Aug.", "Sept.", "Oct.",
                "Nov.", "Dec." };
        String[] threeLetters = { "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov",
                "Dec" };
        String[] monthNumber = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

        boolean checkStatus = day.checkContain(month, s) ||
                day.checkContain(abbreviation, s) ||
                day.checkContain(threeLetters, s) ||
                day.checkContain(monthNumber, s);

        if (checkStatus == false)
            return -1;

        if (day.checkContain(month, s) == true)
            return Arrays.asList(month).indexOf(s) + 1;
        else if (day.checkContain(abbreviation, s) == true)
            return Arrays.asList(abbreviation).indexOf(s) + 1;
        else if (day.checkContain(threeLetters, s) == true)
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
        int numMonth, result = 0;

        // Input Month
        while (true) {
            month = JOptionPane.showInputDialog("Enter the month: ");
            if (day.checkValidMonth(month) == -1) {
                JOptionPane.showMessageDialog(null, "You've enter a not valid month. Please try again!");
                continue;
            } else {
                numMonth = day.checkValidMonth(month);
                break;
            }
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

        if (day.checkLeapYear(Integer.parseInt(year)) == true) {
            switch (numMonth) {
                case 1:
                    result = 31;
                    break;
                case 2:
                    result = 29;
                    break;
                case 3:
                    result = 31;
                    break;
                case 4:
                    result = 30;
                    break;
                case 5:
                    result = 31;
                    break;
                case 6:
                    result = 30;
                    break;
                case 7:
                    result = 31;
                    break;
                case 8:
                    result = 31;
                    break;
                case 9:
                    result = 30;
                    break;
                case 10:
                    result = 31;
                    break;
                case 11:
                    result = 30;
                    break;
                case 12:
                    result = 31;
                    break;
            }

            JOptionPane.showMessageDialog(null,
                    "The day in mont: " + month + ", year: " + Integer.parseInt(year) + " is: " + result);

        } else {
            switch (numMonth) {
                case 1:
                    result = 31;
                    break;
                case 2:
                    result = 28;
                    break;
                case 3:
                    result = 31;
                    break;
                case 4:
                    result = 30;
                    break;
                case 5:
                    result = 31;
                    break;
                case 6:
                    result = 30;
                    break;
                case 7:
                    result = 31;
                    break;
                case 8:
                    result = 31;
                    break;
                case 9:
                    result = 30;
                    break;
                case 10:
                    result = 31;
                    break;
                case 11:
                    result = 30;
                    break;
                case 12:
                    result = 31;
                    break;
            }

            JOptionPane.showMessageDialog(null,
                    "The day in month: " + month + ", year: " + Integer.parseInt(year) + " is: " + result);

        }
    }
}
