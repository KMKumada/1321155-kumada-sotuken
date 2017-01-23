// ���K���  �얞�x����N���C�A���g
import java.io.*;
import java.net.*;

public class HimanClient {
   public static void main(String[] args) throws IOException {

   Socket himanS = null;
   BufferedReader in = null;
   PrintWriter out = null;

   try{
      himanS = new Socket(InetAddress.getLocalHost(), 50001);
      in = new BufferedReader(new InputStreamReader(himanS.getInputStream()));
      out = new PrintWriter(himanS.getOutputStream(), true);
      } catch (UnknownHostException e) {
          System.out.println("�z�X�g�ɐڑ��ł��܂���B");
          System.exit(1);
      } catch (IOException e) {
          System.out.println("IO�R�l�N�V�����𓾂��܂���B");
          System.exit(1);
      }

    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    String fromS;
    String fromU;

    System.out.println(in.readLine());  //�J�n���b�Z�[�W��ǂ�ŕ\��
    System.out.println(in.readLine()); //�̏d���̓v�����v�g
    fromU = stdIn.readLine();        //�̏d
    out.println(fromU);   
    System.out.println(in.readLine()); //�g�����̓v�����v�g
    fromU = stdIn.readLine();        //�g��
    out.println(fromU);   
    fromS=in.readLine();             //�����ǂ�
    System.out.println(fromS);       //�����\��

    out.close();
    in.close();
    stdIn.close();
    himanS.close();
    }
}



