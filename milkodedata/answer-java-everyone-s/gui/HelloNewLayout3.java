//���K���11.4 
//�{�^��������ʃp�l���ɔz�u���A�����ɓ����(���C�A�E�g�̓���q,GridLayout)
//�{�^���p�l�����O���p�l����SOUTH�ɔz�u

import java.awt.*;             
import javax.swing.*;  

public class HelloNewLayout3 extends JPanel{ 
   JLabel label; //���x���p�̕ϐ�
   JPanel flowPanel;  //�p�l���p�̕ϐ�
   JButton b1, b2;//�{�^���p�̕ϐ�

   public HelloNewLayout3(){  
      label = new JLabel("����ɂ���");  
      flowPanel = new JPanel();  
      flowPanel.setLayout(new GridLayout(1,0));
      b1 = new JButton("�{�^��1");  
      b2 = new JButton("�{�^��2");  
      flowPanel.add(b1); //�ʃp�l����Ƀ{�^����u��
      flowPanel.add(b2); 

      setLayout(new BorderLayout());   //�z�u�����̐ݒ�
      add(label, BorderLayout.CENTER);  //���x����u��
      add(flowPanel, BorderLayout.SOUTH); //�{�^�����ڂ����p�l����u��
   }

   public static void main(String[] args){
      JFrame frame = new JFrame();//JFrame�I�u�W�F�N�g�𐶐�
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      HelloNewLayout3 h = new HelloNewLayout3();  //�I�u�W�F�N�g�𐶐�
      frame.add(h, BorderLayout.CENTER);//�t���[���ɃI�u�W�F�N�g��u��
      frame.pack();               //�t���[����K�v�ŏ��̑傫���ɂ���
      frame.setVisible(true);     //�t���[������ʂɌ�����
   }
}
