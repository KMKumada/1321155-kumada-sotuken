//���X�g11.2 JLabel�̗�
import java.awt.*;             
import javax.swing.*;  

public class JLabelExample extends JPanel{
   JLabel a1, a2;
   public JLabelExample(){  
      setBackground(Color.white); //�p�l���̔w�i�𔒂ɂ���
      ImageIcon icon = new ImageIcon("dance.gif");
      JLabel a1 = new JLabel("�������̃_���X");
      JLabel a2 = new JLabel(icon);
      add(a1);
      add(a2);
   }

   public static void main(String[] args){
      JFrame frame = new JFrame("JLabel");//JFrame�I�u�W�F�N�g�𐶐�
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JLabelExample h = new JLabelExample();
      frame.add(h, BorderLayout.CENTER);//�t���[���ɃI�u�W�F�N�g��u��
      frame.pack();               //�t���[����K�v�ŏ��̑傫���ɂ���
      frame.setVisible(true);     //�t���[������ʂɌ�����
   }
}
