//���X�g15.2 �����R�[�h�̕ϊ�
import java.io.*;
public class ChangeCode {
  void dataInOut() throws IOException{ 
       int c;
       InputStreamReader filein = new InputStreamReader(
               new FileInputStream("Text.txt"), "SJIS"); //���̓X�g���[��
       OutputStreamWriter fileout = new OutputStreamWriter(
               new FileOutputStream("Back.txt"), "ISO2022JP"); //�o�̓X�g���[��
       while((c = filein.read()) != -1) {//�t�@�C���̍Ō�܂�1�����ǂ݁A
            fileout.write(c);	   //����������o��
       }
       filein.close();
       fileout.close();
  }    
  public static void main(String[] args){
      ChangeCode r = new ChangeCode();
      try{
          r.dataInOut();   
        }catch(IOException error) { System.out.println("IO�G���[����");}
  }
}



