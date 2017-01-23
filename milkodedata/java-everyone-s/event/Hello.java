//  ���X�g13.1 ����ɂ��̓v���O����(Hello.java)
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  

public class Hello extends JPanel implements ActionListener{ 
   JLabel label; //���x���p�̕ϐ�
   JButton b1, b2;//�{�^���p�̕ϐ�

   public Hello(){  
      label = new JLabel(" ");  //�ŏ��͉����\�����Ȃ�
      b1 = new JButton("����������");  //���������{�^��
      b2 = new JButton("����");  //�����{�^��

      b1.addActionListener(this); //�C�x���g���X�i�[��ݒ�
      b2.addActionListener(this); //�C�x���g���X�i�[��ݒ�

      setLayout(new BorderLayout());   //�z�u
      add(label, BorderLayout.NORTH);  
      add(b1, BorderLayout.CENTER);    
      add(b2, BorderLayout.EAST);      
   }

  public void actionPerformed(ActionEvent e){
     Object obj = e.getSource();
     if(obj == b1){          //b1�������ꂽ��
        label.setText("����ɂ���");    //label�ɕ������ݒ� 
     }
     else if(obj == b2){     //b2�������ꂽ��
        label.setText(" ");              //label�̕����������
     }
   }

   public static void main(String[] args){
      JFrame frame = new JFrame("Hello");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Hello h = new Hello(); 
      frame.add(h, BorderLayout.CENTER); 
      frame.pack();          
      frame.setVisible(true);
   }
}

