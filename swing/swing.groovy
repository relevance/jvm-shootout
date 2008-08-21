import javax.swing.JFrame
import javax.swing.JButton
import javax.swing.JOptionPane
import java.awt.event.ActionListener

frame = new JFrame("Hello Swing")
button = new JButton("Click Me")

button.addActionListener({
  JOptionPane.showMessageDialog(null, """<html>Hello from <b>Groovy</b>.
Button ${it.actionCommand} pressed""")
} as ActionListener) 
frame.contentPane.add button

frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
frame.pack()
frame.visible = true