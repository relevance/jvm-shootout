(import '(javax.swing JFrame JButton JOptionPane))
(import '(java.awt.event ActionListener))

(let [frame (new JFrame "Hello Swing")
      button (new JButton "Click Me")]
  (.addActionListener 
   button
   (proxy [ActionListener] []
     (actionPerformed 
      [evt]
      (JOptionPane/showMessageDialog 
       nil, 
       (str "<html>Hello from <b>Clojure</b>.<br/> Button "
            (.getActionCommand evt)
            " clicked.")))))

  (.. frame (getContentPane) (add button))
  (doto frame
    (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
    .pack
    (.setVisible true)))
					      

