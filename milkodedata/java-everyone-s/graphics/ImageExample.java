//  ���X�g 12.2  �C���[�W�̕\���@ImageIO���g��
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

public class ImageExample extends JPanel{
   Image image;
   public ImageExample(){
      setBackground(Color.white);
      try{
         image = ImageIO.read(new File("frog.gif"));
      }catch(IOException e){}
   }

   public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.drawImage(image, 0, 0, this);  //���̑傫���ŕ`��
      g.drawImage(image, 400, 50, 100, 100, this);//�X�P�[�����O���ĕ`��
      g.drawImage(image, 400, 200, 500, 300, 
                         140, 60, 190, 110, this);//�X�P�[�����O���ĕ`��
   }
	
   public static void main(String[] args){
      JFrame frame  = new JFrame("Image Example");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ImageExample h = new ImageExample();
      frame.add(h, BorderLayout.CENTER);
      frame.setSize(550,400);
      frame.setVisible(true);
   }
}
