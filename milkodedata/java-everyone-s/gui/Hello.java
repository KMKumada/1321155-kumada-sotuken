//  ���X�g11.1 ����ɂ��̓v���O����(Hello.java)
import java.awt.*;             
import javax.swing.*;  

public class Hello extends JPanel{ 
   JLabel label; //���x���p�̕ϐ�
   JButton b1, b2;//�{�^���p�̕ϐ�

   public Hello(){  
      label = new JLabel("����ɂ���");  //JLabel�I�u�W�F�N�g�̐���
      b1 = new JButton("�{�^���P");  //JButton�I�u�W�F�N�g�̐���
      b2 = new JButton("�{�^���Q");  //JButton�I�u�W�F�N�g�̐���
      setLayout(new BorderLayout());   //�p�l���̔z�u������ݒ�
      add(label, BorderLayout.NORTH);  //�p�l���Ƀ��x����u��
      add(b1, BorderLayout.CENTER);    //�p�l���Ƀ{�^����u��
      add(b2, BorderLayout.EAST);      //�p�l���Ƀ{�^����u��
   }

   public static void main(String[] args){
      JFrame frame = new JFrame("Hello");//JFrame�I�u�W�F�N�g�𐶐�
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                              //�E�B���h�E�����ƃv���O�������I��
      //JFrame.setDefaultLookAndFeelDecorated(true); //Java�Ǝ�Look&Feel
      Hello h = new Hello();  //Hello�̃I�u�W�F�N�g�𐶐�
      frame.add(h, BorderLayout.CENTER); 
      frame.pack();               //�t���[����K�v�ŏ��̑傫���ɂ���
      frame.setVisible(true);     //�t���[������ʂɌ�����
   }
}


