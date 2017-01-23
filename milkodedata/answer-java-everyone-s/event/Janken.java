//  ���K���  ����񂯂�v���O����
import java.awt.*;             
import java.awt.event.*;             
import javax.swing.*;  

public class Janken extends JPanel implements ActionListener{ 
   JLabel labelC, labelH, labelWin; //���x��
   JButton bg, bt, bp;//�{�^��
   ImageIcon gu, tyoki, pa, muji;    //�A�C�R��
   int comp, human;                 //�R���s���[�^�̎�,�l�Ԃ̎�
   public Janken(){  
      setBackground(Color.white);
      bg = new JButton("�O�[");  //JButton�I�u�W�F�N�g�̐���
      bt = new JButton("�`���L"); 
      bp = new JButton("�p�["); 
      bg.addActionListener(this); //���X�i�[�̐ݒ�
      bt.addActionListener(this);
      bp.addActionListener(this);
      muji = new ImageIcon("gu.gif");
      gu = new ImageIcon("gu.gif");
      tyoki = new ImageIcon("tyoki.gif");
      pa = new ImageIcon("pa.gif");

      JPanel p1 = new JPanel(); //�{�^����u���p�l��
      p1.setLayout(new GridLayout(3,0));
      p1.add(bg);
      p1.add(bt);
      p1.add(bp);
      //��Ə��s��\������JLabel�̐���
      labelC = new JLabel("�R���s���[�^", muji, SwingConstants.CENTER);
      labelH = new JLabel("���Ȃ�", muji, SwingConstants.CENTER);  
      labelC.setHorizontalTextPosition(SwingConstants.CENTER);
      labelC.setVerticalTextPosition(SwingConstants.TOP);
      labelH.setHorizontalTextPosition(SwingConstants.CENTER);
      labelH.setVerticalTextPosition(SwingConstants.TOP);
      labelWin = new JLabel("  ", SwingConstants.CENTER);

      JPanel p2 = new JPanel(); //�{�^���̃p�l���Ƃ��Ȃ��̎��u���p�l��
      p2.setBackground(Color.white);
      p2.add(labelH);
      p2.add(p1);
   
      setLayout(new BorderLayout());   //�O���p�l���̔z�u�����̐ݒ�
      add(labelC, BorderLayout.WEST);    //�R���s���[�^�̎�
      add(new JLabel("VS"), BorderLayout.CENTER); 
      add(p2, BorderLayout.EAST);      //�l�̎�ƃ{�^��
      add(labelWin, BorderLayout.SOUTH); //���s�̃��x����u��
   }

   public void actionPerformed(ActionEvent e){
      Object obj = e.getSource();
      if(obj == bg){
         labelH.setIcon(gu);
         human = 0;
      }else if(obj == bt){
         labelH.setIcon(tyoki);
         human = 1;
      }else if(obj == bp){
         labelH.setIcon(pa);
         human = 2;
      }
      comp = (int)(Math.random()*3); //�����𐶐�
      dispComp(comp); //�R���s���[�^�̎��\�� 
      dispWin(comp, human); //���s��\�� 
   }

   void dispWin(int c, int m){  //���s�𔻒�A�\��
      switch(c){
      case 0: if(m==0)labelWin.setText("������");
              else if (m==1)labelWin.setText("���Ȃ��̕���");
              else if (m==2)labelWin.setText("���Ȃ��̏���");
	      break;
      case 1: if(m==0)labelWin.setText("���Ȃ��̏���");
              else if (m==1)labelWin.setText("������");
              else if (m==2)labelWin.setText("���Ȃ��̕���");
              break;
      case 2: if(m==0)labelWin.setText("���Ȃ��̕���");
              else if (m==1)labelWin.setText("���Ȃ��̏���");
              else if (m==2)labelWin.setText("������");
              break;
      default: labelWin.setText("�킩��܂���");
              break;
      }
   }
 
   void dispComp(int c){
      switch(c){
      case 0: labelC.setIcon(gu);
	      break;
      case 1: labelC.setIcon(tyoki);
	      break;
      case 2: labelC.setIcon(pa);
	      break;
      }
 }
  public static void main(String[] args){
      JFrame frame = new JFrame("Janken");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Janken j = new Janken();  //Janken�̃I�u�W�F�N�g�𐶐�
      frame.add(j, BorderLayout.CENTER);//�t���[����Janken�I�u�W�F�N�g��u��
      frame.pack();               
      frame.setVisible(true);     
   }
}
