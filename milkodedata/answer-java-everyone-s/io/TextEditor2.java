// �e�L�X�g�G�f�B�^
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class TextEditor2 extends JPanel implements ActionListener{
    JTextArea text;
    String filename;  //�ҏW����t�@�C��
    JButton open, save;
    JFileChooser chooser;
    TextEditor2() { 
        JPanel p = new JPanel(); //�{�^����u���p�l��
        open = new JButton("�J��");
        save = new JButton("�ۑ�");
        open.addActionListener(this);
        save.addActionListener(this);
        p.setBackground(Color.WHITE);
        p.add(open);
        p.add(save);
        text = new JTextArea(); //JTextArea�I�u�W�F�N�g
        JScrollPane pane = new JScrollPane(text);  //text��JScrollPane�ɓ����
        pane.setPreferredSize(new Dimension(300, 300));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(pane);//�㕔��JScrollPane
        add(p);//�����Ƀ{�^����u�����p�l����z�u

        chooser = new JFileChooser();
        chooser.addActionListener(this);
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

    void dataWrite() throws IOException{  //�t�@�C���փf�[�^������
      BufferedWriter dout = new BufferedWriter(new FileWriter(filename));
      dout.write(text.getText());
      dout.close();
    }    

    public void actionPerformed(ActionEvent e) {
       Object obj = e.getSource();
       if( obj == open){
	   chooser.showOpenDialog(this);
           if(filename != null){
	       text.setText(null);//�e�L�X�g��̃N���A
             try{
               dataRead();   //�t�@�C������f�[�^��ǂ�
             }catch(IOException error) 
                    { System.out.println("�t�@�C�����ǂ߂܂���ł����B");}
           }
       }else if(obj == save && filename != null){
          try{
             dataWrite();   //�t�@�C���փf�[�^������
           }catch(IOException error) { System.out.println("�������݃G���[");}
       }else if(obj == chooser){
           File ff = chooser.getSelectedFile(); //�I�����ꂽ�t�@�C��
           if(ff!=null) filename = ff.getAbsolutePath();//�I�����ꂽ�t�@�C���̃p�X
	   System.out.println(filename);
       }

    }

    public static void main(String[] args){
      JFrame frame = new JFrame("Text Editor");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      TextEditor2 h = new TextEditor2();  
      frame.add(h, BorderLayout.CENTER); 
      frame.pack();
      frame.setVisible(true); 
   }
}

