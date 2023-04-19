import javax.swing.*;
import java.awt.event.*;

public class ChoosingOption extends WindowAdapter {
    JFrame f;

    public void windowClosing(WindowEvent e) {
        int a = JOptionPane.showConfirmDialog(null,"Are you sure ?");
        if (a == JOptionPane.YES_OPTION) {
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    public static void main(String[] args) {
        ChoosingOption obj = new ChoosingOption();
        obj.f = new JFrame();
        obj.f.addWindowListener(obj);
        obj.f.setSize(300, 300);
        obj.f.setVisible(true);
    }
}
