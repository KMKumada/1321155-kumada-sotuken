//���X�g15.1 �t�@�C�����R�s�[����
import java.io.*;
public class FileReadWrite {
   void dataInOut() throws IOException{   //�ꕶ�����R�s�[
      int c;
      FileReader filein = new FileReader("Hello.java"); //���̓X�g���[��
      FileWriter fileout = new FileWriter("Back.java"); //�o�̓X�g���[��

      while((c = filein.read()) != -1) {//�t�@�C���̍Ō�܂�1�����ǂ݁A
         fileout.write(c);	   //����������o��
      }
      filein.close();
      fileout.close();
   }    
   public static void main(String[] args){
      FileReadWrite r = new FileReadWrite();
      try{
         r.dataInOut();   
      }catch(IOException error) { System.out.println("IO�G���[����");}
   }
}


