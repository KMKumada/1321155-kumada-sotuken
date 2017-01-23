// ���K��� �`�F�b�N�{�b�N�X�̑I���ŃA�C�R���摜���ς��

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  

public class ChangeIcon2 extends JPanel implements ItemListener{
   JLabel label; //���x���p�̕ϐ�
   JCheckBox c1, c2;
   ImageIcon frog,bug,frogbug,muji;

   public ChangeIcon2(){
      setBackground(Color.white);
      frog = new ImageIcon("frog.gif");
      bug = new ImageIcon("bug.gif");
      frogbug = new ImageIcon("frogbug.gif");
      muji = new ImageIcon("muji.gif");
      label = new JLabel(muji);  //JLabel�I�u�W�F�N�g�̐��� 
      c1 = new JCheckBox("�J�G��"); 
      c2 = new JCheckBox("��");  
      c1.setBackground(Color.white);
      c2.setBackground(Color.white);
      c1.addItemListener(this);
      c2.addItemListener(this);
      JPanel p = new JPanel();
      p.setLayout(new GridLayout(2,0));
      p.add(c1);
      p.add(c2);
      add(label);  //���x����u��
      add(p);
   }
 
   public void itemStateChanged(ItemEvent e){
      if(c1.isSelected() && c2.isSelected()){ //�����`�F�b�N
	 label.setIcon(frogbug);  
      }else if(c1.isSelected() && !c2.isSelected()){ //frog�����`�F�b�N
         label.setIcon(frog);      
      }else if(!c1.isSelected() && c2.isSelected()){ //bug�����`�F�b�N
         label.setIcon(bug);      
      }else{
         label.setIcon(muji);      
      }
   }

   public static void main(String[] args){
      JFrame frame = new JFrame("Frog and Bug");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ChangeIcon2 h = new ChangeIcon2();
      frame.add(h, BorderLayout.CENTER);
      frame.setSize(new Dimension(150, 110));
      frame.setVisible(true);
   }
}
