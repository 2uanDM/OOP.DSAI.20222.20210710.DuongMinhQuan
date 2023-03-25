import javax.swing.JOptionPane;

public class SecondCode {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Enter your name ?");

        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your ages: "));

        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height"));

        JOptionPane.showMessageDialog(null, 
            "Your name is " + name +
            "\nYour age is : " + age +
            "\nYour height is: " + height
        );

        


    }
}