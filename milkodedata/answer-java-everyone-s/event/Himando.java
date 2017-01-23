//���K���  �얞�x�v�Z�v���O����
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  

public class Himando extends JPanel implements ActionListener{
   JTextField hField,wField;   //���̓t�B�[���h
   JLabel hyoujun, himando, hantei;    //���x��
   Double w, h; //�̏d�Ɛg��
   public Himando(){
      setBackground(Color.white);
      hField = new JTextField(10);  //���̓t�B�[���h�𐶐�
      wField = new JTextField(10);
      hyoujun = new JLabel();       //���x���𐶐�
      himando= new JLabel();
      hantei= new JLabel();
      hField.addActionListener(this);  //���̓t�B�[���h�Ƀ��X�i�[��ݒ�
      wField.addActionListener(this);
      setLayout(new GridLayout(5,2));  //���C�A�E�g��ݒ�
      add(new JLabel("�g��(cm)"));     add(hField);                     
      add(new JLabel("�̏d(Kg)"));     add(wField);
      add(new JLabel("�W���̏d(Kg)")); add(hyoujun);
      add(new JLabel("�얞�x"));    add(himando);
      add(new JLabel("�얞�x����"));    add(hantei);
   }
   public void actionPerformed(ActionEvent e){  
      try{ //�g����ݒ�
         h = Double.parseDouble(hField.getText()); //double�^�ɕϊ�
      } catch (NumberFormatException error){ h = 0.0; } //�G���[�������0
      try{ //�̏d��ݒ�
         w=Double.parseDouble(wField.getText());
      } catch (NumberFormatException error){ w = 0.0; }
      doCalc(); //�v�Z�����A�\�������郁�\�b�h
   }
   void doCalc(){
      if(h <= 0){ hField.requestFocus(); } //���̓G���[�����������փJ�[�\���ړ�
      else if(w <= 0){ wField.requestFocus();}
      else{
	 double std = h/100 * h/100 * 22; //�W���̏d���v�Z
	 double him = w /((h/100)*(h/100));  //�얞�x���v�Z
	 hyoujun.setText(String.valueOf(std));//�W���̏d��\��
	 himando.setText(String.valueOf(him));  //�얞�x��\��

	 if (him<=15) hantei.setText("��������");
	 else if (him>15 && him<=20) hantei.setText("��������");
	 else if (him>20 && him<=25) hantei.setText("����");
	 else if (him>25 && him<=30) hantei.setText("���肬��");
	 else hantei.setText("���肷��");
      }
   }
   public static void main(String[] args) {
      JFrame frame = new JFrame("Himando");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Himando h = new Himando();        //�얞�x�p�l�������
      frame.add(h, BorderLayout.CENTER);
      frame.pack();               
      frame.setVisible(true);
   }
}
