// ���X�g12.4�@�ό`
import java.awt.*;
import javax.swing.*;  
import java.io.*;
import javax.imageio.*;  

public class DrawBalloon extends JPanel{
   int w = 200, h = 200; // �p�l���̕��ƍ���
   int iw , ih; // �摜�̕��ƍ���
   Image bi;
   Graphics bg;
   public DrawBalloon(){  
      setBackground(Color.white);
      setPreferredSize(new Dimension(w, h));
      try{  //�I�t�X�N���[���o�b�t�@�ɉ摜��ǂݍ���
         bi = ImageIO.read(new File("bal.gif"));
      }catch(IOException e){}
      iw = bi.getWidth(this);
      ih = bi.getHeight(this);
   }

   protected void paintComponent(Graphics g){
      super.paintComponent(g); 
      Graphics2D g2 = (Graphics2D)g;
      for(int i=0; i<=5; i++){
         g2.scale(0.8, 0.8);
         g2.translate(iw, -ih/3.0);
         g2.drawImage(bi, 0, h, iw, ih, this);
      }
   }

   public static void main(String[] args){
      JFrame frame = new JFrame("Draw Balloon");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      DrawBalloon h = new DrawBalloon();
      frame.add(h, BorderLayout.CENTER);
      frame.pack();               
      frame.setVisible(true);
   }   
}
