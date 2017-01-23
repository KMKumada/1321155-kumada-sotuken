//���K��� ���ȈՐ}�`�G�f�B�^
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawGraphics extends JPanel implements ActionListener{
   JButton b1, b2, b3;
   final int RECT = 1;  final int OVAL = 2; final int LINE=3;
   DrawByMouse area;
   int type = RECT;   //�`���}�`�̎��, �����l�͎l�p
   public DrawGraphics(){
      JPanel p1 = new JPanel(); //�{�^����u���p�l��
      b1 = new JButton("�l�p");
      b2 = new JButton("�~");
      b3 = new JButton("����");
      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      p1.setBackground(Color.WHITE);
      p1.add(b1);
      p1.add(b2);
      p1.add(b3);
      area = new DrawByMouse();
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));  //�c�ɔz�u
      add(area);
      add(p1);
   }

   public void actionPerformed(ActionEvent e) {
      Object target = e.getSource();
      if (target == b1) { type = RECT; }   //�`���}�`�̎�ނ��l�p�ɐݒ�
      else if (target == b2) { type = OVAL; }  //�`���}�`�̎�ނ��~�ɐݒ�
      else if (target == b3) { type = LINE; }  //�`���}�`�̎�ނ���ɐݒ�
   }


   class DrawByMouse extends JPanel implements MouseListener, 
                                            MouseMotionListener {
      int x1, y1, x2, y2; //�`��p�̍��W
      int fX, fY, sX, sY; //�}�E�X�J�[�\���̈ʒu
      DrawByMouse(){
	 setBackground(Color.white);
	 setPreferredSize(new Dimension(250, 250));
	 addMouseListener(this);
	 addMouseMotionListener(this);
      }

      protected void paintComponent(Graphics g){    
	 super.paintComponent(g);
	 if(type == RECT){
	    g.drawRect(x1, y1, x2-x1, y2-y1);
	 } else if (type == OVAL){
	    g.drawOval(x1, y1, x2-x1, y2-y1);
	 } else if (type == LINE){
	    g.drawLine(x1,y1,x2,y2);
	 }
      }

      public void mousePressed(MouseEvent e){ //�}�E�X�����������̏���
	 fX = e.getX();
	 fY = e.getY();
      }
      public void mouseDragged(MouseEvent e){ //�}�E�X�𗣂������̏���
	 sX = e.getX();
	 sY = e.getY();
	 if(type == LINE) {x1=fX; x2=sX; y1=fY; y2=sY;}
	 else {adjustPoint();}
	 repaint();     //�{�^���𗣂������A�}�`��`��
      }
      public void mouseMoved(MouseEvent e){   }
      public void mouseReleased(MouseEvent e){   }
      public void mouseClicked(MouseEvent e){   }
      public void mouseEntered(MouseEvent e){   }
      public void mouseExited(MouseEvent e){   }

      void adjustPoint(){ //�h���b�O��̍��W���n�߂̓_��菬�����ꍇ�̏���
	 if(sX>=fX && sY>=fY) { //�E���փh���b�O �ύX�Ȃ�
	    x1=fX; x2=sX;
	    y1=fY; y2=sY;
         }else if(sX<fX && sY<fY){ //����փh���b�O �������W����
            x1=sX; x2=fX;
	    y1=sY; y2=fY;
	 }else if(sX>=fX && sY<fY){ //�E��փh���b�O �����W����
	    x1=fX; x2=sX;
	    y1=sY; y2=fY;
	 }else if(sX<fX && sY>=fY){ //�����փh���b�O �����W����
            x1=sX; x2=fX;
	    y1=fY; y2=sY;
	 }
      }
   }
   public static void main(String[] args){
      JFrame.setDefaultLookAndFeelDecorated(true);
      JFrame frame  = new JFrame("Draw Editor");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      DrawGraphics e = new DrawGraphics();
      frame.add(e, BorderLayout.CENTER);
      frame.pack();
      frame.setVisible(true);
   }
}

