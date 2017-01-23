//���K��� �{�^���ŃA�C�R�����ς��A�v���b�g
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  
import java.net.*;  

public class ChangeIconApplet extends JApplet implements ActionListener{
   JButton b1, b2, b3;
   JLabel label;
   ImageIcon dance, lay, stand;
   public void init(){  
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
      try{
         dance = new ImageIcon(new URL(getCodeBase(), "dance.gif"));
         lay = new ImageIcon(new URL(getCodeBase(), "lay.gif"));
         stand = new ImageIcon(new URL(getCodeBase(), "up.gif"));
      }catch(MalformedURLException er){}
      JPanel p2 = new JPanel();
      //�㕔�p�l���̃T�C�Y���D�܂����傫���ɐݒ�
      p2.setPreferredSize(new Dimension(250, 100));
      p2.setBackground(Color.WHITE);
      label = new JLabel();
      p2.add(label);

      //setLayout�͎����I�ɃA�v���b�g�̃R���e���g�y�C���ɑ΂��Ď��s�����
      //BoxLayout�̈����ɂ̓A�v���b�g�̃R���e���g�y�C�����K�v
      Container c = getContentPane();
      setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
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
}
