// ���X�g 11.4 JCheckBox�̗� 
import java.awt.*;
import javax.swing.*;  

public class JCheckBoxExample extends JPanel{
   JCheckBox cbox1, cbox2;
   public JCheckBoxExample(){  
      setLayout(new GridLayout(2, 0));
      cbox1 = new JCheckBox("�`�F�b�N�{�b�N�X");
      Icon icon1 = new ImageIcon("dance.gif");
      Icon icon2 = new ImageIcon("lay.gif");
      cbox2 = new JCheckBox("������", icon1);
      cbox2.setSelectedIcon(icon2);  //�I�����̃A�C�R���ݒ�
      add(cbox1);
      add(cbox2);
   }

   public static void main(String[] args){
      JFrame frame = new JFrame("JCheckBox");//JFrame�I�u�W�F�N�g�𐶐�
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JCheckBoxExample h = new JCheckBoxExample();
      frame.add(h, BorderLayout.CENTER);//�t���[���ɃI�u�W�F�N�g��u��
      frame.pack();               //�t���[����K�v�ŏ��̑傫���ɂ���
      frame.setVisible(true);     //�t���[������ʂɌ�����
   }
}
