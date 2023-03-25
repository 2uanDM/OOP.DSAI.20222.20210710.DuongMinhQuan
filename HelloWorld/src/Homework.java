import javax.swing.JOptionPane;
public class Homework {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Enter your name: ");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age: "));
        String gender = JOptionPane.showInputDialog("Enter your gender: ");
        String prefix = "";

        switch (gender.toLowerCase()) {
            case "male": prefix = "Mr.";
            break;
            case "female" : {
                if (age < 30) 
                    prefix = "Miss.";
                else 
                    prefix = "Mrs.";
            }
            break;
            default: {
                JOptionPane.showMessageDialog(null, "This is not a correct gender !");
                return;
            }
            
        } 
        JOptionPane.showMessageDialog(null, 
            "Hi " + prefix + name + 
            "\n Your age is: " + age + 
            "\n Your gender is: " + gender
        );
    }
}
