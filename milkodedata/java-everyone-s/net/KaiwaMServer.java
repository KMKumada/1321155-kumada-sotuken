// ���X�g16.4 �J�E���Z���[�T�[�o�@�}���`�N���C�A���g�T�|�[�g
import java.net.*;
import java.io.*;

public class KaiwaMServer {
   public static void main(String[] args) throws IOException {
      ServerSocket serverS = null;
      boolean end = true;
      try {
         serverS = new ServerSocket(50000);
      } catch (IOException e) {
         System.out.println("�|�[�g�ɃA�N�Z�X�ł��܂���B");
         System.exit(1);
      }
      while(end){
         new KaiwaMThread(serverS.accept()).start();
      }
      serverS.close();
   }
}


