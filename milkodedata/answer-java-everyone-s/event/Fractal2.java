import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;

class Fractal2 extends JPanel{
   int which;    // which point is selected, based on Button number
   int n = 15;               // `繰り返し回数`
   int m = 200;           // 1辺の長さ
   int XA = m, YA = m*2, XB = m*2, YB=m*2;
   int xxa = m + m/2, yya = 2*m-m/2;
   int xxb = m + m/2, yyb = 2*m-m/2;
   final int W = m * 3, H = m * 3;
   double sina, cosa, sinb, cosb;
   BufferedImage bi;
   Graphics2D bg;

   JRadioButton red, blue, both;
   ButtonGroup group = new ButtonGroup();

   Fractal2() {
      bi = new BufferedImage(W, H, BufferedImage.TYPE_INT_RGB);
      bg = (Graphics2D) bi.createGraphics();

      JPanel cpanel = new JPanel();
      red = new JRadioButton("赤");
      blue = new JRadioButton("青");
      both = new JRadioButton("両方", true);

      cpanel.add(red); cpanel.add(blue); cpanel.add(both);
      group.add(red); group.add(blue); group.add(both);
      MyCanvas m = new MyCanvas();
      addMouseMotionListener(new MouseMotionAdapter(){
	    public void mouseDragged(MouseEvent e){
	       if(red.isSelected()) which = 1;
	       if(blue.isSelected()) which = 2;
	       if(both.isSelected()) which = 3;

	       if(which == 1 || which == 3){
		  xxa = e.getX();
		  yya = e.getY();
	       }
	       if(which == 2 || which == 3){
		  xxb = e.getX();
		  yyb = e.getY();
	       }
	       drawit();
	       repaint();
	    }
	 });

      setLayout(new BorderLayout());
      add(m, BorderLayout.CENTER);
      add(cpanel, BorderLayout.SOUTH);
      drawit();
   }

   public void drawit(){
      bg.setColor(Color.white); 
      bg.fillRect(0,0,W,H); 
      bg.setColor(Color.black); 
      sina = (double)(yya - YA)/m;
      cosa = (double)(xxa - XA)/m;
      sinb = (double)(yyb - YB)/m;
      cosb = (double)(xxb  - XB)/m;
      bg.setColor(Color.black);
      levi(XA,YA,XB,YB,n);
      bg.setColor(Color.blue); bg.fillOval(xxb-2,yyb-2,6,6);
      bg.setColor(Color.red); bg.fillOval(xxa-2,yya-2,6,6);
      bg.setColor(Color.green); bg.fillOval(XA-2,YA-2,6,6);
      bg.setColor(Color.green); bg.fillOval(XB-2,YB-2,6,6);

   }
   void levi(double x1, double y1, double x2, double y2, int n){

      if(n == 0){
	 bg.drawLine((int)x1,(int)y1,(int)x2,(int)y2);
      }else{

	 double x3 = x1 + (x2 - x1)* cosa - (y2-y1)*sina;
	 double y3 = y1 + (y2-y1)* cosa + (x2 - x1)*sina;

	 double x4 = x2 + (x2 - x1)* cosb -(y2-y1)* sinb;
	 double y4 = y2 + (y2-y1)* cosb + (x2 - x1)*sinb;
      
	 levi(x1, y1, x3,y3, n-1);
	 levi(x4, y4, x2,y2, n-1);
      }
   }
   class MyCanvas extends JPanel{
      MyCanvas(){
	 setPreferredSize(new Dimension(W, H)); 
      }
      protected void paintComponent(Graphics g){
	 super.paintComponent(g); 
	 g.drawImage(bi, 0, 0, this);
      }
   }
   public static void main(String args[]){
      JFrame.setDefaultLookAndFeelDecorated(true);
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Fractal2 h = new Fractal2();
      frame.add(h, BorderLayout.CENTER);
      frame.pack();               
      frame.setVisible(true);
    }
}


