// ���K��� 11.6
// �z�u���K
import java.awt.*;
import javax.swing.*;  

public class HaitiRensyu extends JPanel{
   JButton b1, b2, b3;
   JLabelExample p2;

   public HaitiRensyu(){  
      JPanel p1 = new JPanel(); //�{�^����u���p�l��
      b1 = new JButton("�{�^���P");
      b2 = new JButton("�{�^���Q");
      b3 = new JButton("�{�^���R");
      p1.setBackground(Color.WHITE);
      p1.add(b1);
      p1.add(b2);
      p1.add(b3);

      p2 = new JLabelExample();
      //�㕔�p�l���̃T�C�Y���D�܂����傫���ɐݒ�
      p2.setPreferredSize(new Dimension(250, 250));

      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      add(p2);//�㕔��JLabelExample�p�l����z�u
      add(p1);//�����Ƀ{�^����u�����p�l����z�u
   }

   public static void main(String[] args){
      JFrame frame = new JFrame("JPanel");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      HaitiRensyu h = new HaitiRensyu();
      frame.add(h, BorderLayout.CENTER);
      frame.pack();               
      frame.setVisible(true);
   }
}
