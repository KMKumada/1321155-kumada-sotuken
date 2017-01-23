//  ���X�g13.4 �}�E�X�N���b�N�ɉ����Đ���������
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawByMouse extends JPanel implements MouseListener {
   int x1, y1, x2, y2;
   public DrawByMouse(){
      setBackground(Color.white);
      setPreferredSize(new Dimension(250, 250));
      addMouseListener(this);
   }

   protected void paintComponent(Graphics g){    
      super.paintComponent(g);
      g.drawLine(x1,y1,x2,y2);
   }
	
   public void mousePressed(MouseEvent e){ //�}�E�X�����������̏���
       x1 = e.getX();
       y1 = e.getY();
   }
   public void mouseReleased(MouseEvent e){ //�}�E�X�𗣂������̏���
       x2 = e.getX();
       y2 = e.getY();
       repaint();     //�{�^���𗣂������A�}�`��`��
   }
   public void mouseClicked(MouseEvent e){   }
   public void mouseEntered(MouseEvent e){   }
   public void mouseExited(MouseEvent e){   }

   public static void main(String[] args){
      JFrame frame  = new JFrame("Draw Line");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      DrawByMouse e = new DrawByMouse();
      frame.add(e, BorderLayout.CENTER);
      frame.pack();
      frame.setVisible(true);
   }
}

