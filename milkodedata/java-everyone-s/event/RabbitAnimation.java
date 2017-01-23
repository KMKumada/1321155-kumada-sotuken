// ���X�g13.10 �������̃_���X�A�j���[�V����
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;  

class RabbitAnimation extends JPanel implements ActionListener {
   int number = 0;       //�\������摜�̔ԍ�
   int cell = 20;         //�摜�̐�
   int interval =300;     //�摜�̕\���Ԋu(�P�ʃ~���b)
   Timer timer;           //�^�C�}�[�p�ϐ�
   Image[] image;         //�摜���i�[����z��
   Image stage;           //�w�i�摜�p�ϐ�

   RabbitAnimation() {
      try{ stage = ImageIO.read(new File("rabbit/stage.gif")); //�摜�̃��[�h
      }catch(IOException e){System.out.println("�t�@�C�������[�h�ł��܂���");}

      image = new Image[cell];
      for (int i = 1; i <= cell; i++) {   //�摜�̃��[�h
         try{ 
            image[i-1] = ImageIO.read(new File("rabbit/rabbit" + i + ".gif"));
         }catch(IOException e){System.out.println("�t�@�C�������[�h�ł��܂���");}
      }
      timer = new Timer(interval, this); //�^�C�}�[�̐���
      setBackground(Color.white);       //�p�l���̔w�i�F
      setPreferredSize(new Dimension(stage.getWidth(this), stage.getHeight(this)));
      timer.start();                    //�A�j���[�V�����̊J�n
   }

   public void actionPerformed(ActionEvent e) { //�A�N�V�����C�x���g����
      repaint(); //�`��
      number++;  
      number = number%cell;  //���ɕ\������摜�̔ԍ�
   }

   protected void paintComponent(Graphics g) {
      super.paintComponent(g); //�w�i�̕`��
      g.drawImage(stage, 0, 0, this);
      int x = getWidth()/2-30; //�E�B���h�E�̂قڒ����ɂ�������\��
      int y = getHeight()/2+20;
      g.drawImage(image[number], x, y, this);
   }

   public static void main(String[] args) {
      JFrame frame  = new JFrame("Animation");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      RabbitAnimation panel = new RabbitAnimation();
      frame.add(panel, BorderLayout.CENTER);
      frame.pack();
      frame.setVisible(true);
   }
}






