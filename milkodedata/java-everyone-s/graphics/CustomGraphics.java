//  ���X�g12.1  �p�l����ɐ���`��
import java.awt.*;
import javax.swing.*;  

public class CustomGraphics extends JPanel{
   public CustomGraphics(){  
      setBackground(Color.white);
      setPreferredSize(new Dimension(250, 250));
   }
   protected void paintComponent(Graphics g){
      super.paintComponent(g); //�w�i��`��
      g.drawLine(50, 50, 200, 200); //����`��
      g.drawLine(200, 50, 50, 200); //����`��
      g.drawRect(50, 50, 150, 150); //�l�p��`��
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
