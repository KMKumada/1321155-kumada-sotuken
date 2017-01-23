//���X�g15.5 �e�L�X�g�G�f�B�^�̘g�g
// ����̃t�@�C���̕\���̂�
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class TextEditor extends JPanel{
    JTextArea text;
    String filename = "Hello.java";  //�ҏW����t�@�C��
    JButton open, save;

    TextEditor() { 
        JPanel p = new JPanel(); //�{�^����u���p�l��
        open = new JButton("�J��");
        save = new JButton("�ۑ�");
        p.setBackground(Color.WHITE);
        p.add(open);
        p.add(save);
        text = new JTextArea(); //JTextArea�I�u�W�F�N�g
        JScrollPane pane = new JScrollPane(text);  //text��JScrollPane�ɓ����
        pane.setPreferredSize(new Dimension(300, 300));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(pane);//�㕔��JScrollPane
        add(p);//�����Ƀ{�^����u�����p�l����z�u

        try{ dataRead();   
        }catch(IOException error){System.out.println("�t�@�C���G���[");}
    }

    void dataRead() throws IOException{   //��s���ǂ�ŕ\��
       BufferedReader din = new BufferedReader(new FileReader(filename));
       String s;
       while((s = din.readLine()) != null){//�t�@�C���̏I���܂ŁA1�s�ǂ݁A
          text.append(s);  //�t�@�C���̍s��text�ɒǉ�
          text.append("\n");
       }
        din.close();
    }    

    public static void main(String[] args){
      JFrame frame = new JFrame("Text Editor");//JFrame�I�u�W�F�N�g�𐶐�
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      TextEditor h = new TextEditor();  
      frame.add(h, BorderLayout.CENTER); 
      frame.pack();
      frame.setVisible(true); 
   }
}

