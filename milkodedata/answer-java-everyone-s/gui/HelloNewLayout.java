//���K���11.3 
//�{�^��������ʃp�l���ɔz�u���A�����ɓ����(���C�A�E�g�̓���q)

import java.awt.*;             
import javax.swing.*;  

public class HelloNewLayout extends JPanel{ 
   JLabel label; //���x���p�̕ϐ�
   JPanel flowPanel;  //�p�l���p�̕ϐ�
   JButton b1, b2;//�{�^���p�̕ϐ�

   public HelloNewLayout(){  
      label = new JLabel("����ɂ���");  
      flowPanel = new JPanel(); 
      b1 = new JButton("�{�^��1");  
      b2 = new JButton("�{�^��2");  
      flowPanel.add(b1); //�ʃp�l����Ƀ{�^����u��
      flowPanel.add(b2); 
      setLayout(new BorderLayout());   //�z�u�����̐ݒ�
      add(label, BorderLayout.NORTH);  //���x����u��
      add(flowPanel, BorderLayout.CENTER); //�{�^�����ڂ����p�l����u��
   }

   public static void main(String[] args){
      JFrame frame = new JFrame();//JFrame�I�u�W�F�N�g�𐶐�
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      HelloNewLayout h = new HelloNewLayout();  //�I�u�W�F�N�g�𐶐�
      frame.add(h, BorderLayout.CENTER);//�t���[���ɃI�u�W�F�N�g��u��
      frame.pack();               //�t���[����K�v�ŏ��̑傫���ɂ���
      frame.setVisible(true);     //�t���[������ʂɌ�����
   }
}

