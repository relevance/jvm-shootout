import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Swing {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Hello Swing");
    JButton button = new JButton("Click Me");

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(null,
            String.format("<html>Hello from <b>Java</b>" +
                          "Button %s pressed", event.getActionCommand()));
      }
    });
    frame.getContentPane().add(button);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
