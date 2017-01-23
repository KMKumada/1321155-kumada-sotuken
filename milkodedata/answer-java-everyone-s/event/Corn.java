// ���K��� �}�E�X�Œ��S���������S�~
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;

public class Corn extends JPanel implements MouseMotionListener{
   int centerX, centerY; //�p�l���̒��S
   int x, y, r;  //�~�̈ʒu�ƒ��a
   int mX, mY;   //�}�E�X�̈ʒu
   int distance=10, kosu=20;  //�~�̒��a�̕ω��ʂƉ~�̌�
   float dx, dy;  //�}�E�X�̈ʒu�����ւ̂���
   Dimension size = new Dimension(250, 250);  

   public Corn(){
      setBackground(Color.white);     
      setPreferredSize(size);
      mX = size.width/2; //�ŏ��̃}�E�X�̈ʒu
      mY = size.height/2;
      addMouseMotionListener(this);
   }
   protected void paintComponent(Graphics g){    
       super.paintComponent(g);
       centerX=getWidth()/2;  //�p�l���̒���
       centerY=getHeight()/2;
       r=0;
       dx = (centerX-mX)/(float)(kosu); //�~�̂���
       dy = (centerY-mY)/(float)(kosu);
       for(int i=1; i<=kosu; i++){
           r=r+distance;
	   x = (int)(mX + dx*i - r/2.0F);
	   y = (int)(mY + dy*i - r/2.0F);
	   g.drawOval(x, y, r, r);
       }
   }
   public void mouseDragged(MouseEvent e){
      mX = e.getX();
      mY = e.getY();
      repaint();
   }
   public void mouseMoved(MouseEvent e){  }
   public static void main(String[] args){
      JFrame frame  = new JFrame("Circle Example");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Corn h = new Corn();
      frame.add(h, BorderLayout.CENTER);
      frame.pack();
      frame.setVisible(true);
   }
}
