include Java
import javax.swing.JFrame
import javax.swing.JButton
import javax.swing.JOptionPane
import java.awt.event.ActionListener

button = JButton.new "Click Me"
button.add_action_listener do |evt|
  JOptionPane.showMessageDialog(nil, <<-END)
<html>Hello from <b>JRuby</b>.
Button '#{evt.getActionCommand()}' clicked.
END
end

frame = JFrame.new "Hello Swing"
frame.content_pane.add button
frame.default_close_operation = JFrame::EXIT_ON_CLOSE
frame.pack
frame.visible = true
