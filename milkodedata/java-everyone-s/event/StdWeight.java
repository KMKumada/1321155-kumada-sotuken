//���X�g13.3  �W���̏d�v�Z�v���O����
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  

public class StdWeight extends JPanel implements ActionListener{
   JTextField hField;   //���̓t�B�[���h
   JLabel hyoujun;    //���x��
   Double h; //�g��
   public StdWeight(){
      setBackground(Color.white);
      hField = new JTextField(10);  //���̓t�B�[���h�𐶐�
      hyoujun = new JLabel();       //���x���𐶐�
      hField.addActionListener(this);  //���̓t�B�[���h�Ƀ��X�i�[��ݒ�
      setLayout(new GridLayout(2,2));  //���C�A�E�g��ݒ�
      add(new JLabel("�g��(cm)"));     add(hField);                     
      add(new JLabel("�W���̏d(Kg)")); add(hyoujun);
   }
   public void actionPerformed(ActionEvent e){  
      try{ //�g����ݒ�
         h = Double.parseDouble(hField.getText()); //double�^�ɕϊ�
      } catch (NumberFormatException error){ h = 0.0; } //�G���[�������0
      doCalc(); //�v�Z�����A�\�������郁�\�b�h
   }
   void doCalc(){
      if(h > 0){
	 double std = h/100 * h/100 * 22;
	 hyoujun.setText(String.valueOf(std));//�W���̏d���v�Z,�\��
      }
   }
   public static void main(String[] args) {
      JFrame frame = new JFrame("Standart Weight");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      StdWeight h = new StdWeight();        //�얞�x�p�l�������
      frame.add(h, BorderLayout.CENTER);
      frame.pack();               
      frame.setVisible(true);
   }
}
