//���K���11.5 
//�{�^���ƃ��x����BoxLayout�ŏc���ɔz�u

import java.awt.*;             
import javax.swing.*;  

public class HelloNewLayout4 extends JPanel{ 
   JLabel label; //���x���p�̕ϐ�
   JButton b1, b2;//�{�^���p�̕ϐ�

   public HelloNewLayout4(){  
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //�z�u�����̐ݒ�
      label = new JLabel("����ɂ���");  
      b1 = new JButton("�{�^��1");  
      b2 = new JButton("�{�^��2");  
      add(label);  
      add(b1); 
      add(b2); 
   }

   public static void main(String[] args){
      JFrame frame = new JFrame();//JFrame�I�u�W�F�N�g�𐶐�
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      HelloNewLayout4 h = new HelloNewLayout4();  //�I�u�W�F�N�g�𐶐�
      frame.add(h, BorderLayout.CENTER);//�t���[���ɃI�u�W�F�N�g��u��
      frame.pack();               //�t���[����K�v�ŏ��̑傫���ɂ���
      frame.setVisible(true);     //�t���[������ʂɌ�����
   }
}
