// ���X�g12.5�@�N���b�s���O�p�X�̐ݒ�
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;  
import java.io.*;
import javax.imageio.*;  
public class ClipDraw extends JPanel{
   Image image;
   GeneralPath path;
   public ClipDraw(){  
      setPreferredSize(new Dimension(250, 188));
      path = new GeneralPath(); //��̃p�X�𐶐�
      Ellipse2D maru = new Ellipse2D.Double(20, 45, 100, 100); //�~�𐶐�
      path.append(maru, false); //�~�̃p�X��ǉ�
      path.moveTo(170f, 30f); //�O�p�`�̃p�X��ǉ�
      path.lineTo(100f, 170f); 
      path.lineTo(240f, 170f); 
      path.closePath(); 
      try{ image = ImageIO.read(new File("kame.jpg"));
      }catch(IOException e){}
   }

   protected void paintComponent(Graphics g){
      super.paintComponent(g); 
      Graphics2D g2 = (Graphics2D) g;
      g2.setClip(path);  //�N���b�s���O�p�X�̐ݒ�
      g.drawImage(image, 0, 0, this); //�摜��`��
   }

   public static void main(String[] args){
      JFrame frame = new JFrame("Set clip and draw");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ClipDraw h = new ClipDraw();
      frame.add(h, BorderLayout.CENTER);
      frame.pack();               
      frame.setVisible(true);
   }   
}
