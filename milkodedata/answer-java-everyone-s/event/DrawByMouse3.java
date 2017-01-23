//  ���K��� �}�E�X�h���b�O�ɉ����Đ�������, �m�肵����F��ς���
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawByMouse3 extends JPanel implements MouseListener, 
                                            MouseMotionListener {
   int x1, y1, x2, y2;
   Color c;
   public DrawByMouse3(){
      setBackground(Color.white);
      setPreferredSize(new Dimension(250, 250));
      addMouseListener(this);
      addMouseMotionListener(this);
   }

   protected void paintComponent(Graphics g){    
      super.paintComponent(g);
      g.drawLine(x1,y1,x2,y2);
   }
	
   public void mousePressed(MouseEvent e){ //�}�E�X�����������̏���
      x1 = e.getX();
      y1 = e.getY();
   }
   public void mouseDragged(MouseEvent e){ //�}�E�X���h���b�O�������̏���
      x2 = e.getX();
      y2 = e.getY();
      setForeground(Color.red);
      repaint();     //�}�`��`��
   }
   public void mouseReleased(MouseEvent e){ 
      setForeground(Color.black);
      repaint();     //�{�^���𗣂������A�}�`��`��
   }
   public void mouseMoved(MouseEvent e){   }
   public void mouseClicked(MouseEvent e){   }
   public void mouseEntered(MouseEvent e){   }
   public void mouseExited(MouseEvent e){   }

   public static void main(String[] args){
      JFrame frame  = new JFrame("Draw Line");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      DrawByMouse3 e = new DrawByMouse3();
      frame.add(e, BorderLayout.CENTER);
      frame.pack();
      frame.setVisible(true);
   }
}

