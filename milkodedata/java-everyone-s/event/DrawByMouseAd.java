// ���X�g13.7  �}�E�X�N���b�N�ɉ����Đ��������v���O����
// �A�_�v�^�[���g�����������X�i�[�N���X
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawByMouseAd extends JPanel {
   int x1, y1, x2, y2;
   public DrawByMouseAd(){
      setBackground(Color.white);
      setPreferredSize(new Dimension(250, 250));
      addMouseListener(new MousePosition());
   }

   protected void paintComponent(Graphics g){    
      super.paintComponent(g);
      g.drawLine(x1,y1,x2,y2);
   }
	
   class MousePosition extends MouseAdapter{
      public void mousePressed(MouseEvent e){ //�}�E�X�����������̏���
	 x1 = e.getX();
	 y1 = e.getY();
      }
      public void mouseReleased(MouseEvent e){ //�}�E�X�𗣂������̏���
	 x2 = e.getX();
	 y2 = e.getY();
	 repaint();     //�{�^���𗣂������A�}�`��`��
      }
   }
   public static void main(String[] args){
      JFrame frame  = new JFrame("Draw Line");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      DrawByMouseAd e = new DrawByMouseAd();
      frame.add(e, BorderLayout.CENTER);
      frame.pack();
      frame.setVisible(true);
   }
}

