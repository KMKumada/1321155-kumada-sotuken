// ���X�g16.3 �J�E���Z���[�N���C�A���g
import java.io.*;
import java.net.*;

public class KaiwaClient {
   public static void main(String[] args) throws IOException {
   Socket kaiwaS = null;
   BufferedReader in = null;
   PrintWriter out = null;
   try{
      kaiwaS = new Socket(InetAddress.getLocalHost(), 50000);
      in = new BufferedReader(new InputStreamReader(kaiwaS.getInputStream()));
      out = new PrintWriter(kaiwaS.getOutputStream(), true);
      } catch (UnknownHostException e) {
         System.out.println("�z�X�g�ɐڑ��ł��܂���B");
         System.exit(1);
      } catch (IOException e) {
         System.out.println("IO�R�l�N�V�����𓾂��܂���B");
         System.exit(1);
      }

    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    String fromServer;
    String fromUser;
    while ((fromServer = in.readLine()) != null) {
       System.out.println("�J�E���Z���[: " + fromServer);
       if (fromServer.equals("�ł͂܂��ɂ��܂��傤�B"))break;
       System.out.print("���Ȃ�: ");
       fromUser = stdIn.readLine();
       out.println(fromUser);
    }
 
    out.close();  in.close();
    stdIn.close();  kaiwaS.close();
    }
}


