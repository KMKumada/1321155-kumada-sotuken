// ���X�g14.1 ����ɂ��̓v���O�����A�v���b�g��
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  

public class HelloApplet extends JApplet implements ActionListener{ 
   JLabel label; //���x���p�̕ϐ�
   JButton b1, b2;//�{�^���p�̕ϐ�
   public void init(){  
      label = new JLabel("  ");  //JLabel�I�u�W�F�N�g�̐���
      b1 = new JButton("����������");  //JButton�I�u�W�F�N�g�̐���
      b2 = new JButton("����");  //JButton�I�u�W�F�N�g�̐���
      b1.addActionListener(this); //�C�x���g���X�i�[��ݒ�
      b2.addActionListener(this); //�C�x���g���X�i�[��ݒ�
      add(label, BorderLayout.NORTH);  //���x����u��
      add(b1, BorderLayout.CENTER);    //�{�^����u��
      add(b2, BorderLayout.EAST);      //�{�^����u��
      //validate(); 
   }

   public void actionPerformed(ActionEvent e){
      Object obj = e.getSource();
      if(obj == b1){          //b1�������ꂽ��
	 label.setText("����ɂ���");    //label�ɕ������ݒ� 
      } else if(obj == b2){     //b2�������ꂽ��
      label.setText(" ");              //label�̕����������
      }
   }
}

