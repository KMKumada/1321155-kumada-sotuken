//  ���X�g14.3 �������Đ�����A�v���b�g
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.AudioClip;

public class SoundExample extends JApplet implements ActionListener{
   AudioClip clip;     // �I�[�f�B�I�N���b�v�p�̕ϐ���錾 
   boolean looped;     // �Đ������ۂ��̃t���O false:��~�� true:�Đ���
   JButton loopB, stopB;
   public void init(){
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      c.setBackground(Color.white);
      loopB = new JButton("�Đ�");
      stopB = new JButton("��~");
      loopB.addActionListener(this);
      stopB.addActionListener(this);
      add(loopB);   add(stopB);
      stopB.setEnabled(false);         // ��~�{�^���𖳌��ɂ���
      clip = getAudioClip(getCodeBase(), "usagid.mid"); // �I�[�f�B�I�N���b�v�����
   }

   public void stop(){  // �u���E�U���ʂ�Web�y�[�W�Ɉڂ����� 
      if(looped){  clip.stop(); } // �J�ԍĐ����Ȃ�I�[�f�B�I�N���b�v�̍Đ��𒆎~����    
   }
   public void start(){   // �A�v���b�g���܂ރy�[�W���\�����ꂽ��
      if(looped){  clip.loop(); } // �Đ����Ȃ�I�[�f�B�I�N���b�v�̍Đ����ĊJ����
   }

   public void actionPerformed(ActionEvent e){
      Object obj = e.getSource();
      if(obj == loopB){    // �J�ԍĐ��{�^���������ꂽ��
         looped = true;         // �Đ��t���O��on�ɐݒ�
         clip.loop();           // �I�[�f�B�I�N���b�v���J�Ԃ��Đ�����
         loopB.setEnabled(false);  // �J�ԃ{�^���𖳌��ɂ���
         stopB.setEnabled(true);   // ��~�{�^����L���ɂ���
         stopB.requestFocus();  //��~�{�^���ɃL�[�{�[�h�t�H�[�J�X���ڂ�
         showStatus("Play sound continuously"); 
      }
      else if (obj == stopB){  // ��~�{�^���������ꂽ��
         looped = false;       // �Đ��t���O��off�ɐݒ�
         clip.stop();          // �I�[�f�B�I�N���b�v�̍Đ��𒆎~���� 
         loopB.setEnabled(true);       // �J�ԃ{�^����L���ɂ���
         stopB.setEnabled(false);      // ��~�{�^���𖳌��ɂ���
         showStatus("Stop sound");
      }
   }    
}
