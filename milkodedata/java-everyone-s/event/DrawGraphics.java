//���X�g13.5  ���ȈՐ}�`�G�f�B�^�̘g�g��
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawGraphics extends JPanel implements ActionListener{
   DrawByMouse area;   //�`���̃p�l��
   JButton b1, b2, b3;
   final int RECT = 1;  final int OVAL = 2; final int LINE=3;
   int type = RECT;   //�`���}�`�̎��, �����l�͎l�p
   public DrawGraphics(){
      //3�̃{�^���𐶐��C���X�i�[��ݒ�
      //�{�^����u���p�l�������C�{�^����z�u
      //�`���𐶐�
      //�`���ƃ{�^����u�����p�l����z�u
   }

   public void actionPerformed(ActionEvent e) {
      //�����ꂽ�{�^���ɉ����āCtype��RECT, OVAL, LINE�̒l��ݒ�
   }
   //�`���̃p�l���C�����N���X�Ƃ��Ē�`

   class DrawByMouse extends JPanel implements MouseListener, 
                                            MouseMotionListener {
      int x1, y1, x2, y2; //�`��p�̍��W
      DrawByMouse(){
	 //�w�i�F��ݒ�C�p�l���T�C�Y��ݒ�C���X�i�[��ݒ�
      }
      protected void paintComponent(Graphics g){    
	 //type�̒l�ɉ����āC�l�p�C�~�C������`���B
      }
      public void mousePressed(MouseEvent e){ 
	 //�}�E�X�����������̏���
      }
      public void mouseDragged(MouseEvent e){ 
	 //�}�E�X�𗣂������̏���
      }
      public void mouseMoved(MouseEvent e){   }
      public void mouseReleased(MouseEvent e){   }
      public void mouseClicked(MouseEvent e){   }
      public void mouseEntered(MouseEvent e){   }
      public void mouseExited(MouseEvent e){   }
   }
   public static void main(String args[]){
      JFrame frame  = new JFrame("Draw Editor");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      DrawGraphics e = new DrawGraphics();
      frame.add(e, BorderLayout.CENTER);
      frame.pack();
      frame.setVisible(true);
   }
}
