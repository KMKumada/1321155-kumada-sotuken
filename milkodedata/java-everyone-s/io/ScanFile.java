// ���X�g15.6 �t�@�C������ǂ񂾃f�[�^���CScanner�ŉ��
import java.io.*;
import java.util.*;

class ScanFile {
   void dataSum() throws IOException{   //���l��ǂ�ō��v
      Scanner sc = new Scanner(new BufferedReader(new FileReader("data.txt")));
      double sum = 0;
      while (sc.hasNextDouble()) { sum += sc.nextDouble(); } //double�^�̃f�[�^��ǂ�ō��v
      sc.close();
      System.out.println(sum);
   }

   public static void main(String[] args){
      ScanFile r = new ScanFile();
      try{ r.dataSum();   
      }catch(IOException error) { System.out.println("IO�G���[����");}
   }
}
