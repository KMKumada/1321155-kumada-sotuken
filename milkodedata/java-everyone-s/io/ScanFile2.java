// ���X�g15.7 �t�@�C������ǂ񂾃f�[�^���C�p�^�[�����g���ĉ��
import java.io.*;
import java.util.*;
public class ScanFile2 {
  void dataRead() throws IOException{   //�p�^�[���œǂ�
     Scanner s = new Scanner(new BufferedReader(new FileReader("listdata.txt")));
     String str;
     String p = "(\\S+)(\\s)(\\d+).(\\d+)(\\s)(\\d+).(\\d+)"; //���K�\����\��������
     while( (str = s.findInLine(p)) != null){
        System.out.println(str);
        s.skip("(\\s+)");  //�s���L����ǂݔ�΂�
     }
      s.close();
    }

  public static void main(String[] args){
      ScanFile2 r = new ScanFile2();
      try{ r.dataRead();   
        }catch(IOException error) { System.out.println("IO�G���[����");}
  }
}
