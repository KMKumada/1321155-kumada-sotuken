//���X�g13.2 �`�F�b�N�{�b�N�X�̑I���ɂ��A�C�R�����ω�
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  

public class Standup extends JPanel implements ItemListener{
   JLabel label; //���x��
   JCheckBox cb; //�`�F�b�N�{�b�N�X
   ImageIcon lay,up; //�A�C�R��
   public Standup(){
      setBackground(Color.white); //�p�l���̔w�i�𔒂�
      lay = new ImageIcon("lay.gif");
      up = new ImageIcon("up.gif");
      label = new JLabel(lay);  
      cb = new JCheckBox("����");  
      cb.setBackground(Color.white);//�`�F�b�N�{�b�N�X�̔w�i�𔒂�
      cb.addItemListener(this); //���X�i�[�̐ݒ�
      add(label);  //���x����u��
      add(cb);     //�`�F�b�N�{�b�N�X��u��
   }
 
   public void itemStateChanged(ItemEvent e){
      if( e.getStateChange()==ItemEvent.SELECTED){ //�I�����ꂽ���
         label.setIcon(up);  
      }else if(e.getStateChange()==ItemEvent.DESELECTED){ //��I���̏��
         label.setIcon(lay);  
      }
   }

   public static void main(String[] args){
      JFrame frame = new JFrame("Standup");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Standup h = new Standup();
      frame.add(h, BorderLayout.CENTER);
      frame.setSize(new Dimension(150, 110));
      frame.setVisible(true);
   }
}
