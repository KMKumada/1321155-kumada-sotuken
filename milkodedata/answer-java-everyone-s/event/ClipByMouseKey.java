// ���K���  �}�E�X�h���b�O�ƃL�[���͂ŃN���b�v����~�̈ʒu������
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;  
import java.io.*;
import javax.imageio.*;  

public class ClipByMouseKey extends JPanel implements ActionListener{
   Image image;
   GeneralPath path;
   Ellipse2D maru ;
   int r = 100; //�N���b�v����~�̒��a
   int x, y; //�~�̒��S�̈ʒu
   public ClipByMouseKey(){  
      try{ image = ImageIO.read(new File("kame.jpg"));
      }catch(IOException e){}
      setPreferredSize(new Dimension(image.getWidth(this), 
                                     image.getHeight(this)));
      maru = new Ellipse2D.Double(); //�~�𐶐�
      path = new GeneralPath(); //��̃p�X�𐶐�
      addMouseMotionListener(new ClipPosition());
      x = image.getWidth(this)/2;  //�ŏ��͒���
      y = image.getHeight(this)/2;
      setKeyboard();
   }

   protected void paintComponent(Graphics g){
      super.paintComponent(g); 
      Graphics2D g2 = (Graphics2D) g;
      maru.setFrame(x-r/2, y-r/2, r, r);
      path.reset();    //�p�X����ɂ���
      path.append(maru, false);  //�~���p�X�ɂ���
      g2.setClip(path);  //�N���b�s���O�p�X�̐ݒ�
      g.drawImage(image, 0, 0, this); //�摜��`��
   }

   class ClipPosition extends MouseMotionAdapter {//�}�E�X�h���b�O�̏���
      public void mouseDragged(MouseEvent e){ 
	 x = e.getX();
	 y = e.getY();
	 repaint();     
      }
   }

   public void actionPerformed(ActionEvent e) {
      String com = e.getActionCommand();
      if (com.equals("up")) { y -= 10; }
      else if (com.equals("down")) { y += 10; }
      else if (com.equals("right")) { x += 10; }
      else if (com.equals("left")) { x -= 10; }
      repaint();
   }

   void setKeyboard(){ //�L�[�ɃR�}���h�����w��
      registerKeyboardAction(this, "up", KeyStroke.getKeyStroke('u'),
				 JComponent.WHEN_IN_FOCUSED_WINDOW);
      registerKeyboardAction(this, "down", KeyStroke.getKeyStroke('d'),
				 JComponent.WHEN_IN_FOCUSED_WINDOW);
      registerKeyboardAction(this, "right", KeyStroke.getKeyStroke('r'),
				 JComponent.WHEN_IN_FOCUSED_WINDOW);
      registerKeyboardAction(this, "left", KeyStroke.getKeyStroke('l'),
				 JComponent.WHEN_IN_FOCUSED_WINDOW);
   }

   public static void main(String[] args){
      JFrame frame = new JFrame("Move clip area");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ClipByMouseKey h = new ClipByMouseKey();
      frame.add(h, BorderLayout.CENTER);
      frame.pack();               
      frame.setVisible(true);
   }   
}
