// �}�E�X�ŕ`�悵���摜���t�@�C���֕ۑ�
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class DrawGraphics3 extends JPanel implements ActionListener{
   JButton b1, b2, b3, b4, b5;
   final int RECT = 1;  final int OVAL = 2; final int LINE=3; 
   final int CLEAR = 0; 
   DrawByMouse area;
   int type = RECT;   //�`���}�`�̎��, �����l�͎l�p
   File ff; //�ۑ�����t�@�C����
   JFileChooser chooser;

   public DrawGraphics3(){
      JPanel p1 = new JPanel(); //�{�^����u���p�l��
      b1 = new JButton("�l�p");
      b2 = new JButton("�~");
      b3 = new JButton("����");
      b4 = new JButton("�N���A");
      b5 = new JButton("�ۑ�");
      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      b4.addActionListener(this);
      b5.addActionListener(this);
      p1.setBackground(Color.WHITE);
      p1.add(b1);
      p1.add(b2);
      p1.add(b3);
      p1.add(b4);
      p1.add(b5);
      area = new DrawByMouse();
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));  //�c�ɔz�u
      add(area);
      add(p1);

      chooser = new JFileChooser();
      chooser.addActionListener(this);
   }

   public void actionPerformed(ActionEvent e) {
      Object target = e.getSource();
      if (target == b1) { type = RECT; }   //�`���}�`�̎�ނ��l�p�ɐݒ�
      else if (target == b2) { type = OVAL; }  //�`���}�`�̎�ނ��~�ɐݒ�
      else if (target == b3) { type = LINE; }  //�`���}�`�̎�ނ���ɐݒ�
      else if (target == b4) { 
         type = CLEAR;   //�N���A
         area.repaint(); 
      } else if (target == b5) { 
	 chooser.showSaveDialog(this);
	 System.out.println(ff);
	 if(ff != null){
	    try{
               ImageIO.write(area.bi, "png", ff);
	    }catch(IOException er){System.out.println("error in write"); }
	 }
      } else if(target == chooser){ //�t�@�C����I������
	  ff = chooser.getSelectedFile(); //�I�����ꂽ�t�@�C��
      }
   }


   class DrawByMouse extends JPanel implements MouseListener, 
                                            MouseMotionListener {
      int x1, y1, x2, y2; //�`��p�̍��W
      int fX, fY, sX, sY; //�}�E�X�J�[�\���̈ʒu
      BufferedImage bi; //�I�t�X�N���[���C���[�W
      Graphics bg;
      boolean firsttime = true;
      boolean confirm = false;
      DrawByMouse(){
	 setPreferredSize(new Dimension(250, 250));
	 addMouseListener(this);
	 addMouseMotionListener(this);
      }

      protected void paintComponent(Graphics g){    
	 super.paintComponent(g);
         if(firsttime){
            bi = (BufferedImage)createImage(getWidth(), getHeight());
            bg = bi.createGraphics(); //Graphics�R���e�L�X�g�𓾂�
            bg.setColor(Color.white);
	    bg.fillRect(0, 0, getWidth(), getHeight());
            bg.setColor(Color.black);
            firsttime = false;
         }
         if(type==CLEAR){
            bg.setColor(Color.white);
	    bg.fillRect(0, 0, getWidth(), getHeight());
            bg.setColor(Color.black);
            g.drawImage(bi, 0,0,this);
            type = RECT;  // �`���}�`�������l�̎l�p�ɐݒ�
            return;
         }

         if(confirm){
	    if(type == RECT){
	       bg.drawRect(x1, y1, x2-x1, y2-y1);
	    } else if (type == OVAL){
	       bg.drawOval(x1, y1, x2-x1, y2-y1);
	    } else if (type == LINE){
	       bg.drawLine(x1,y1,x2,y2);
	    }
            confirm=false;
         }
         g.drawImage(bi, 0,0,this);
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
      public void mouseReleased(MouseEvent e){
	 sX = e.getX();
	 sY = e.getY();
	 if(type == LINE) {x1=fX; x2=sX; y1=fY; y2=sY;}
         else {adjustPoint();}
         confirm = true;
	 repaint();     //�{�^���𗣂������A�}�`��`��
      }
      public void mouseMoved(MouseEvent e){   }
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
      JFrame frame  = new JFrame("Draw Editor");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      DrawGraphics3 e = new DrawGraphics3();
      frame.add(e, BorderLayout.CENTER);
      frame.pack();
      frame.setVisible(true);
   }
}

