//���K���11.1 �{�^���ɃC���[�W��\������

import java.awt.*;             
import javax.swing.*;  

public class HelloIcon extends JPanel{
   JLabel label; //���x���p�̕ϐ�
   JButton b1, b2;//�{�^���p�̕ϐ�

   public HelloIcon(){
      ImageIcon icon1 = new ImageIcon("hello.gif");
      ImageIcon icon2 = new ImageIcon("doron.gif");

      label = new JLabel("����ɂ���");  //JLabel�I�u�W�F�N�g�̐���
      b1 = new JButton("��������", icon1);  //JButton�I�u�W�F�N�g�̐���
      b2 = new JButton("������", icon2);  //JButton�I�u�W�F�N�g�̐���

      setLayout(new BorderLayout());   //�z�u�����̐ݒ�
      add(label, BorderLayout.NORTH);  //���x����u��
      add(b1, BorderLayout.CENTER);    //�{�^����u��
      add(b2, BorderLayout.EAST);      //�{�^����u��
   }
 

   public static void main(String[] args){
      JFrame frame = new JFrame("Hello");//JFrame�I�u�W�F�N�g�𐶐�
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      HelloIcon h = new HelloIcon();  //HelloIcon�̃I�u�W�F�N�g�𐶐�
      frame.add(h, BorderLayout.CENTER);//�t���[����Hello�I�u�W�F�N�g��u��
      frame.pack();               //�t���[����K�v�ŏ��̑傫���ɂ���
      frame.setVisible(true);     //�t���[������ʂɌ�����
   }
}
