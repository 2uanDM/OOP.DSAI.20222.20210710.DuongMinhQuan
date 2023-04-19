import javax.swing.*;

public class Exercise_2_2_5 {
    public static void main(String[] args) {
        double num1, num2;

        num1 = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Enter the first number",
                "Input the first number",
                JOptionPane.INFORMATION_MESSAGE));

        num2 = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Enter the second number",
                "Input the second number",
                JOptionPane.INFORMATION_MESSAGE));

        double sum = num1 + num2;
        double product = num1 * num2;

        JOptionPane.showMessageDialog(null,
                "Sum of two number is  " + sum,
                "Result: Sum",
                JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null,
                "Product of two number is " + product,
                "Result: Product",
                JOptionPane.INFORMATION_MESSAGE);

        if (num2 == 0) {
            JOptionPane.showMessageDialog(null,
                    "Cannot divide num1 by num2 since num2 = 0",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            String quotient = String.format("%.2f", num1 / num2);
            JOptionPane.showMessageDialog(null,
                    "Quotient of two number is " + quotient,
                    "Result: Quotient",
                    JOptionPane.INFORMATION_MESSAGE);

            System.exit(0);
        }
    }
}
