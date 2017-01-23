// ���X�g12.3�@�I�t�X�N���[���C���[�W���g���Đ}�`���J��Ԃ��`��
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;  

public class DrawOffscreen extends JPanel{
   BufferedImage bi; //�I�t�X�N���[���C���[�W
   Graphics bg;  //Graphics�R���e�L�X�g
   public DrawOffscreen(){  
      setBackground(Color.white);
      setPreferredSize(new Dimension(250, 80));
      bi = new BufferedImage(51, 51, BufferedImage.TYPE_INT_RGB);
      bg = bi.createGraphics(); //Graphics�R���e�L�X�g�𓾂�
      bg.fillRect(0,0,51,51); //�w�i�𔒂����邽�ߕ`��F�Ŏl�p��`��
      bg.setColor(Color.black); //�`��F�����ɂ���
      bg.drawLine(0, 0, 50, 50); //����`��
      bg.drawLine(50, 0, 0, 50); //����`��
      bg.drawRect(0, 0, 50, 50); //�l�p��`��
   }

   protected void paintComponent(Graphics g){
      super.paintComponent(g);
      for(int i=0; i<4; i++){
      g.drawImage(bi, 10+i*60, 10, this);
      }
   }

   public static void main(String[] args){
      JFrame frame = new JFrame("Draw the same lines");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      DrawOffscreen h = new DrawOffscreen();
      frame.add(h, BorderLayout.CENTER);
      frame.pack();               
      frame.setVisible(true);
   }   
}
