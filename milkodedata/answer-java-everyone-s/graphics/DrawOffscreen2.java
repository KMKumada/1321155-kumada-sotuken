// ���K���  �I�t�X�N���[���C���[�W���g���Đ}�`���J��Ԃ��`��
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;  

public class DrawOffscreen2 extends JPanel{
   BufferedImage bi; //�I�t�X�N���[���C���[�W
   Graphics bg; //Graphics�R���e�L�X�g�𓾂�
   public DrawOffscreen2(){  
      setBackground(Color.white);
      setPreferredSize(new Dimension(250, 80));
   }

   protected void paintComponent(Graphics g){
      if(bi==null){
         bi = (BufferedImage)createImage(51, 51);
         bg = bi.createGraphics(); //Graphics�R���e�L�X�g�𓾂�
         bg.setColor(Color.white);
         bg.fillRect(0, 0, 51, 51); //�w�i�𔒂����邽�ߎl�p��`��
         bg.setColor(Color.black);
         bg.drawLine(0, 0, 50, 50); //����`��
         bg.drawLine(50, 0, 0, 50); //����`��
         bg.drawRect(0, 0, 50, 50); //�l�p��`��
      }
      super.paintComponent(g);
      for(int i=0; i<4; i++){
         g.drawImage(bi, 10+i*60, 10, this);
      }
   }

   public static void main(String[] args){
      JFrame frame = new JFrame("Draw the same lines");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      DrawOffscreen2 h = new DrawOffscreen2();
      frame.add(h, BorderLayout.CENTER);
      frame.pack();               
      frame.setVisible(true);
   }   
}
