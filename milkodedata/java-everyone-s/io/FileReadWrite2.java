//���X�g15.3 �t�@�C������s���ǂ�
import java.io.*;
public class FileReadWrite2{
  void dataInOut() throws IOException{   //��s���ǂ�ŕ\��
    BufferedReader din = new BufferedReader(new FileReader("Hello.java"));
    String s;
    while((s = din.readLine()) != null){//�t�@�C���̍Ō�܂ŁA1�s�ǂ�
	System.out.println(s);    //�W���o�͂֕\��
    }
    din.close();
  }    

  public static void main(String[] args){
      FileReadWrite2 r = new FileReadWrite2();
      try{
          r.dataInOut();   
        }catch(IOException error) { System.out.println("IO�G���[����");}
  }
}
