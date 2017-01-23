//���K��� 100�̉~�̃A�j���[�V����
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExpandCircle extends JPanel implements ActionListener{
   int x, y;
   int r=10; //�~�̒��a
   public ExpandCircle(){
      setBackground(Color.white);
      setPreferredSize(new Dimension(250, 250));//�]�ރT�C�Y��ݒ�
      Timer t = new Timer(100,this);
      t.start();
   }

    public void actionPerformed(ActionEvent e){
       r++;
       repaint();
    }

   protected void paintComponent(Graphics g){    
      super.paintComponent(g);

      for(int i=1; i<=10; i++){
         x = 20*i ;
         for(int j=1; j<=10; j++){
            y = 20*j;
            g.drawOval(x, y, r, r);
         }
      }
   }
	
   public static void main(String[] args){
      JFrame frame  = new JFrame("Expand Circles");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ExpandCircle h = new ExpandCircle(); 
      frame.add(h, BorderLayout.CENTER); 
      frame.pack();               //�t���[����K�v�ŏ��̑傫���ɂ���
      frame.setVisible(true);     //�t���[������ʂɌ�����
   }
}

