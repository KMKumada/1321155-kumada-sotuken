//���K��� 100�̉~
import java.awt.*;
import javax.swing.*;

public class CustomGraphics2 extends JPanel {
   int x, y;
   int r=10; //�~�̒��a
   public CustomGraphics2(){
      setBackground(Color.white);
      setPreferredSize(new Dimension(250, 250));//�]�ރT�C�Y��ݒ�
   }

   protected void paintComponent(Graphics g){    
      super.paintComponent(g);

      for(int i=1; i<=10; i++){
         x = 20*i;
         for(int j=1; j<=10; j++){
            y = 20*j;
            g.drawOval(x, y, r, r);
         }
      }
   }
	
   public static void main(String[] args){
      JFrame frame  = new JFrame("Circle on lines");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      CustomGraphics2 h = new CustomGraphics2(); 
      frame.add(h, BorderLayout.CENTER); 
      frame.pack();               //�t���[����K�v�ŏ��̑傫���ɂ���
      frame.setVisible(true);     //�t���[������ʂɌ�����
   }
}

