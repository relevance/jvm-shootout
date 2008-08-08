(import '(javax.swing JFrame JButton JOptionPane))
(import '(java.awt.event ActionListener))

(def frame (new JFrame "Hello Swing"))
(def button (new JButton "Click Me"))

(.addActionListener button (proxy [ActionListener] []
			     (actionPerformed [evt]
					      (.showMessageDialog JOptionPane nil, "foo"))))

(.. frame (getContentPane) (add button))
(doto frame
  (setDefaultCloseOperation (. JFrame EXIT_ON_CLOSE))
  (pack)
  (setVisible true))
					      

