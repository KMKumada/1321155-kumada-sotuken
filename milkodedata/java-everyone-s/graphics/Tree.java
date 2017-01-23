import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Tree extends JPanel{
   double scale = 0.7;        // ��}�̒����̔䗦
   int angle = 30;           // �}�̍L����p�x�i�x�P�ʁj
   int N = 8;               // �J�Ԃ���
   final int W = 400, H = 400;
   double len = 100.0;    // �ŏ��̎}�̒���
   BufferedImage bi;
   Graphics bg;
   Tree() {
      setPreferredSize(new Dimension(W, H)); 
      bi = new BufferedImage(W, H, BufferedImage.TYPE_INT_RGB);
      bg = bi.createGraphics();
      bg.setColor(Color.white);  
      bg.fillRect(0,0,W,H); 
      bg.setColor(new Color(100, 153, 0));  // �`��F�̐ݒ�
      drawTree(W/2, H, len, 0, N);  // �ċA�����̊J�n 
   }
   void drawTree(double x1, double y1, double len, double stand, int n){
      double x2=x1 + len*Math.sin(Math.toRadians(stand));  //�}���x���W
      double y2=y1 - len*Math.cos(Math.toRadians(stand));  //�}���y���W
      bg.drawLine((int)x1,(int)y1,(int)x2,(int)y2); //����`��
      if(n>=1){   //�؂̖��[�܂ŒB���Ă��Ȃ��Ƃ��́C���̎}��`��
	 drawTree(x2,y2,len*scale,stand-angle,n-1); //���̉E�̎}��`��
	 drawTree(x2,y2,len*scale,stand+angle,n-1); //���̍��̎}��`��
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

