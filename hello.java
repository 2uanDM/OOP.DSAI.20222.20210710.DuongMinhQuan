import java.lang.Math;
import javax.swing.*;

public class hello {

    public void oneVariableFirstDegree() {
        JOptionPane.showMessageDialog(null,
                "The first degree equation with one variable has the form of ax + b = 0",
                "Information",
                JOptionPane.INFORMATION_MESSAGE);

        double a = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Input the value of a:"));

        double b = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Input the value of b:"));

        if (a == 0 && b != 0) {
            JOptionPane.showMessageDialog(null, "No solution !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (a == 0 && b == 0) {
            JOptionPane.showMessageDialog(null, "Infinitely many solutions!");
        } else {
            String result = String.format("%.2f", -b / a);
            JOptionPane.showMessageDialog(null, "Solution is: " + result);
        }

    }

    public void twoVariablesFirstDegree() {

        double a11 = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Input the a11 coefficient: ",
                "a11",
                JOptionPane.INFORMATION_MESSAGE));

        double a12 = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Input the a12 coefficient: ",
                "a12",
                JOptionPane.INFORMATION_MESSAGE));

        double b1 = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Input the b1 coefficient: ",
                "b1",
                JOptionPane.INFORMATION_MESSAGE));

        double a21 = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Input the a21 coefficient: ",
                "a21",
                JOptionPane.INFORMATION_MESSAGE));

        double a22 = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Input the a11 coefficient: ",
                "a22",
                JOptionPane.INFORMATION_MESSAGE));

        double b2 = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Input the b2 coefficient: ",
                "b2",
                JOptionPane.INFORMATION_MESSAGE));

        double D = a11 * a22 - a21 * a12;

        if (D != 0) {
            Double D1 = b1 * a22 - b2 * a12;
            Double D2 = a11 * b2 - a21 * b1;
            System.out.println(D1);
            System.out.println(D2);
            String result = String.format("x1 = %.2f ; x2 = %.2f", D1 / D, D2 / D);
            JOptionPane.showMessageDialog(null,
                    "Solution of the systems is: " + result);
        } else {
            if (a22 / a12 == b2 / b1) {
                JOptionPane.showMessageDialog(null,
                        "Infinitely many solutions!",
                        "Result",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "No solution!",
                        "Result",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    public void oneVariableSecondDegree() {
        JOptionPane.showMessageDialog(null,
                "The equation has the form: ax^2 + bx + c = 0");

        double a = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the value of a: "));
        double b = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the value of b: "));
        double c = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the value of c: "));

        if (a == 0) {
            if (b == 0 && c == 0) {
                JOptionPane.showMessageDialog(null,
                        "Infinitely many solutions!");
            } else if (b == 0 && c != 0) {
                JOptionPane.showMessageDialog(null,
                        "No solution !");
            } else {
                String result = String.format("x = %.2f", -c / b);
                JOptionPane.showMessageDialog(null,
                        "Solution: " + result);
            }
        } else {
            double denta = b * b - 4 * a * c;
            if (denta == 0) {
                String result = String.format("x = %.2f", -b / (2 * a));
                JOptionPane.showMessageDialog(null,
                        "The equation has only one solution: " + result);
            } else if (denta > 0) {
                String result = String.format("x1 = %.2f , x2 = %.2f",
                        (-b + Math.sqrt(denta) / (2 * a)),
                        (-b - Math.sqrt(denta) / (2 * a)));
                JOptionPane.showMessageDialog(null,
                        "The equation has two solutions: " + result);
            } else {
                JOptionPane.showMessageDialog(null,
                        "There is no real solution !");
            }
        }
    }

    public static void main(String[] args) {
        hello h = new hello();
        h.oneVariableFirstDegree();
        h.twoVariablesFirstDegree();
        h.oneVariableSecondDegree();
    }
}
