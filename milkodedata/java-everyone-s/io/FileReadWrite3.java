//���X�g15.4 �L�[�{�[�h����ǂ�
import java.io.*;
public class FileReadWrite3{
  void dataInOut() throws IOException{   //�L�[�{�[�h����̓��͂�\��
    BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
    String s;
    while((s = din.readLine()) != null){//1�s�ǂ�
	System.out.println(s);    //�W���o�͂֕\��
    }
    din.close();
  }    

  public static void main(String[] args){
      FileReadWrite3 r = new FileReadWrite3();
      try{
          r.dataInOut();   
        }catch(IOException error) { System.out.println("IO�G���[����");}
  }
}
