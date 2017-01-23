// ���K���  �{�^���ŃA�C�R�����ς��
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  

public class ChangeIcon extends JPanel implements ActionListener{
   JButton b1, b2, b3;
   JLabel label;
   ImageIcon dance, lay, stand;
   public ChangeIcon(){  
      JPanel p1 = new JPanel(); //�{�^����u���p�l��
      b1 = new JButton("�x��");
      b2 = new JButton("�|���");
      b3 = new JButton("����");
      p1.setBackground(Color.WHITE);
      p1.add(b1);
      p1.add(b2);
      p1.add(b3);
      b1.addActionListener(this); //�C�x���g���X�i�[��ݒ�
      b2.addActionListener(this); //�C�x���g���X�i�[��ݒ�
      b3.addActionListener(this); //�C�x���g���X�i�[��ݒ�
      dance = new ImageIcon("dance.gif");
      lay = new ImageIcon("lay.gif");
      stand = new ImageIcon("up.gif");

      JPanel p2 = new JPanel();
      //�㕔�p�l���̃T�C�Y���D�܂����傫���ɐݒ�
      p2.setPreferredSize(new Dimension(250, 100));
      p2.setBackground(Color.WHITE);
      label = new JLabel();
      p2.add(label);

      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      add(p2);//�㕔�Ƀp�l����z�u
      add(p1);//�����Ƀ{�^����u�����p�l����z�u
   }

   public void actionPerformed(ActionEvent e){
      Object obj = e.getSource();
      if(obj == b1){          //b1�������ꂽ��
         label.setIcon(dance); 
      }
      else if(obj == b2){     //b2�������ꂽ��
	 label.setIcon(lay);
      }
      else if(obj == b3){     //b3�������ꂽ��
         label.setIcon(stand);
      }
   }

   public static void main(String[] args){
      JFrame frame = new JFrame("Change Icon");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ChangeIcon h = new ChangeIcon();
      frame.add(h, BorderLayout.CENTER);
      frame.pack();               
      frame.setVisible(true);
   }
}
