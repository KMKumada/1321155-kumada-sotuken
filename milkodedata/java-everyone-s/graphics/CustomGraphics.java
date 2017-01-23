//  ƒŠƒXƒg12.1  ƒpƒlƒ‹ã‚Éü‚ğ•`‚­
import java.awt.*;
import javax.swing.*;  

public class CustomGraphics extends JPanel{
   public CustomGraphics(){  
      setBackground(Color.white);
      setPreferredSize(new Dimension(250, 250));
   }
   protected void paintComponent(Graphics g){
      super.paintComponent(g); //”wŒi‚ğ•`‚­
      g.drawLine(50, 50, 200, 200); //ü‚ğ•`‚­
      g.drawLine(200, 50, 50, 200); //ü‚ğ•`‚­
      g.drawRect(50, 50, 150, 150); //lŠp‚ğ•`‚­
   }
   public static void main(String[] args){
      JFrame frame = new JFrame("Draw Line");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      CustomGraphics h = new CustomGraphics();
      frame.add(h, BorderLayout.CENTER);
      frame.pack();               
      frame.setVisible(true);
   }
}
