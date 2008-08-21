import javax.swing._;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

object HelloWorld extends JFrame("Hello Swing") {
  implicit def actionPerformedWrapper(closure: (ActionEvent) => Unit) = 
    new ActionListener { def actionPerformed(e:ActionEvent) = closure(e) }

  def showButtonMessage(msg: String)  =       
    JOptionPane.showMessageDialog(null, String.format("""<html>Hello from <b>Scala</b>.
Button %s pressed""", Array(msg)));

  def main(args: Array[String]) =
  {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    val button = new JButton("Click Me")
    button.addActionListener((e:ActionEvent) => showButtonMessage(e.getActionCommand.toString))
    getContentPane.add(button)
    pack;
    setVisible(true);
  }
}
