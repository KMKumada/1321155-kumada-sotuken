// —ûK–â‘è Graphics2D‚Ì‰ñ“]‚ğg‚Á‚½ƒvƒƒOƒ‰ƒ€
import java.awt.*;
import javax.swing.*;

public class RotateOval extends JPanel{
   int w = 200, h = 200; // ƒpƒlƒ‹‚Ì•‚Æ‚‚³
   int ow = 150; //‘È‰~‚Ì’·Œa
   int oh = 30; //‘È‰~‚Ì’ZŒa
   int dr = 20; //‰ñ“]Šp“x
   int x = (w - ow)/2; // •`‰æˆÊ’uxÀ•W
   int y = (h - oh)/2; // •`‰æˆÊ’uyÀ•W

   public RotateOval() {
       setBackground(Color.white);
       setPreferredSize(new Dimension(w, h));
   }

   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.red);
      Graphics2D g2 = (Graphics2D)g;
      for(int a=0; a<180; a=a+dr){
         g2.rotate(Math.toRadians(dr), x+ow/2, y+oh/2);
          g.drawOval(x, y, ow, oh);
      }
   }

   public static void main(String[] args) {
       JFrame frame = new JFrame("Rotate Oval");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       RotateOval h = new RotateOval();
       frame.add(h, BorderLayout.CENTER);
       frame.pack();
       frame.setVisible(true);
   }
}
