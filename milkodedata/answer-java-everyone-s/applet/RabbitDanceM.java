//���K��� ���y���A�j���[�V�����̊J�n�ƒ�~
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;  
import java.applet.*;
import java.net.*;

public class RabbitDanceM extends JPanel implements ActionListener {
   JButton b1, b2;
   RabbitAnimation area;

   public RabbitDanceM(){  
      JPanel p1 = new JPanel(); //�{�^����u���p�l��
      b1 = new JButton("�X�^�[�g");
      b2 = new JButton("�X�g�b�v");
      b1.addActionListener(this);
      b2.addActionListener(this);
      p1.add(b1);
      p1.add(b2);
 
      area = new RabbitAnimation();
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      add(area);//�㕔��RabbitAnimation�p�l����z�u
      add(p1);//�����Ƀ{�^����u�����p�l����z�u
   }

   public void actionPerformed(ActionEvent e) { //�A�N�V�����C�x���g����
      Object obj = e.getSource();
      if(obj == b1){          //b1�������ꂽ��
	 area.startDance();
      }
      else if(obj == b2){     //b2�������ꂽ��
         area.stopDance();
      }
   }
   public static void main(String[] args) {
      JFrame frame  = new JFrame("Animation");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      RabbitDanceM k = new RabbitDanceM();
      frame.add(k, BorderLayout.CENTER);
      frame.pack();
      frame.setVisible(true);
   }
}


class RabbitAnimation extends JPanel implements ActionListener {
   int number = -1;       //�\������摜�̔ԍ�
   int cell = 20;         //�摜�̐�
   int interval =300;     //�摜�̕\���Ԋu(�P�ʃ~���b)
   Timer timer;           //�^�C�}�[�p�ϐ�
   Image[] image;         //�摜���i�[����z��
   Image stage;           //�w�i�摜�p�ϐ�
   AudioClip clip;
   URL url;

   RabbitAnimation() {
      try{ stage = ImageIO.read(new File("rabbit/stage.gif")); //�摜�̃��[�h
      }catch(IOException e){System.out.println("�t�@�C�������[�h�ł��܂���");}

      image = new Image[cell];
      for (int i = 1; i <= cell; i++) {   //�摜�̃��[�h
         try{ 
            image[i-1] = ImageIO.read(new File("rabbit/rabbit" + i + ".gif"));
         }catch(IOException e){System.out.println("�t�@�C�������[�h�ł��܂���");}
      }
      try { //�����̃��[�h
         url = new URL("file:" + System.getProperty("user.dir") + "/usagid.mid");
      }catch(MalformedURLException e) {System.out.println("�����t�@�C����������܂���");}
      clip = Applet.newAudioClip(url);

      timer = new Timer(interval, this); //�^�C�}�[�̐���
      timer.setInitialDelay(0);          //�����Ɏn�߂�
      timer.setCoalesce(true);           //�C�x���g���܂Ƃ߂�
      setPreferredSize(new Dimension(stage.getWidth(this), stage.getHeight(this)));
    }

    void startDance(){
       if(!timer.isRunning()) {
          timer.start();
          clip.loop();
       }
    }
    void stopDance(){
       if(timer.isRunning()) {
          timer.stop();
          clip.stop();
       }
    }

    public void actionPerformed(ActionEvent e) { //�A�N�V�����C�x���g����
       number++;  
       number = number%cell;  //���ɕ\������摜�̔ԍ�
       repaint(); //�`��
    }

    public void paintComponent(Graphics g) {
       super.paintComponent(g); //�w�i�̕`��
       g.drawImage(stage, 0, 0, this);
       int x = getWidth()/2-30; //�E�B���h�E�̂قڒ����ɂ�������\��
       int y = getHeight()/2+20;
       try { //number��0-19�ȊO�̎��ɕ`�悪�Ă΂ꂽ���̗�O����
          g.drawImage(image[number], x, y, this);
       } catch (ArrayIndexOutOfBoundsException e) { 
            g.drawImage(image[0], x, y, this); }
    }
}






