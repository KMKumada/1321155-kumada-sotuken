//���K���11.2
import java.awt.*;             
import javax.swing.*;  

public class HelloFlowLayout extends JPanel{ 
   JLabel label; //���x���p�̕ϐ�
   JButton b1, b2;//�{�^���p�̕ϐ�

   public HelloFlowLayout(){
      label = new JLabel("����ɂ���");  //JLabel�I�u�W�F�N�g�̐���
      b1 = new JButton("�{�^��1");  //JButton�I�u�W�F�N�g�̐���
      b2 = new JButton("�{�^��2");  //JButton�I�u�W�F�N�g�̐���
      add(label);  //���x����u��
      add(b1);    //�{�^����u��
      add(b2);    //�{�^����u��
   }

   public static void main(String[] args){
      JFrame frame = new JFrame("FlowLayout");//JFrame�I�u�W�F�N�g�𐶐�
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                              //�E�B���h�E�����ƃv���O�������I��
      HelloFlowLayout h = new HelloFlowLayout();  //HelloFlowLayout�I�u�W�F�N�g�𐶐�
      frame.add(h, BorderLayout.CENTER); 
      frame.pack();               //�t���[����K�v�ŏ��̑傫���ɂ���
      frame.setVisible(true);     //�t���[������ʂɌ�����
   }
}

