import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Tree extends JPanel{
   double scale = 0.7;        // ˆç‚Â}‚Ì’·‚³‚Ì”ä—¦
   int angle = 30;           // }‚ÌL‚ª‚éŠp“xi“x’PˆÊj
   int N = 8;               // ŒJ•Ô‚µ‰ñ”
   final int W = 400, H = 400;
   double len = 100.0;    // Å‰‚Ì}‚Ì’·‚³
   BufferedImage bi;
   Graphics bg;
   Tree() {
      setPreferredSize(new Dimension(W, H)); 
      bi = new BufferedImage(W, H, BufferedImage.TYPE_INT_RGB);
      bg = bi.createGraphics();
      bg.setColor(Color.white);  
      bg.fillRect(0,0,W,H); 
      bg.setColor(new Color(100, 153, 0));  // •`‰æF‚Ìİ’è
      drawTree(W/2, H, len, 0, N);  // Ä‹Aˆ—‚ÌŠJn 
   }
   void drawTree(double x1, double y1, double len, double stand, int n){
      double x2=x1 + len*Math.sin(Math.toRadians(stand));  //}æ‚ÌxÀ•W
      double y2=y1 - len*Math.cos(Math.toRadians(stand));  //}æ‚ÌyÀ•W
      bg.drawLine((int)x1,(int)y1,(int)x2,(int)y2); //ü‚ğ•`‚­
      if(n>=1){   //–Ø‚Ì––’[‚Ü‚Å’B‚µ‚Ä‚¢‚È‚¢‚Æ‚«‚ÍCŸ‚Ì}‚ğ•`‚­
	 drawTree(x2,y2,len*scale,stand-angle,n-1); //Ÿ‚Ì‰E‚Ì}‚ğ•`‚­
	 drawTree(x2,y2,len*scale,stand+angle,n-1); //Ÿ‚Ì¶‚Ì}‚ğ•`‚­
      }
   }
   protected void paintComponent(Graphics g){
      super.paintComponent(g); 
      g.drawImage(bi, 0, 0, this);
   }
   public static void main(String args[]){
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Tree h = new Tree();
      frame.add(h, BorderLayout.CENTER);
      frame.pack();               
      frame.setVisible(true);
    }
}

