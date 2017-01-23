// ���X�g16.2 �J�E���Z���[�T�[�o
import java.net.*;
import java.io.*;

public class KaiwaServer {
   public static void main(String[] args) throws IOException {
      ServerSocket serverS = null;
      Socket clientS = null;
      try{ 
	 serverS = new ServerSocket(50000); 
      } catch (IOException e) {
         System.out.println("�|�[�g�ɃA�N�Z�X�ł��܂���B");
         System.exit(1);
      }
      try{ 
	 clientS = serverS.accept(); 
      } catch (IOException e) {
         System.out.println("Accept�Ɏ��s���܂����B");
         System.exit(1);
      }
      PrintWriter out = new PrintWriter(clientS.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(clientS.getInputStream()));
      String fromC, fromUser;
      Counsel c = new Counsel();
      out.println("���ł��b���Ă�������");
      while ((fromUser = in.readLine()) != null) {
         fromC = c.kaiwa(fromUser);
         out.println(fromC);
         if (fromC.equals("�ł͂܂��ɂ��܂��傤�B")) break;
      }
      in.close();  out.close();
      clientS.close();  serverS.close();
    }
}

class Counsel{
   int i, n=0;
   String[] henji = { 
       "����������܂��ˁB", 
       "�ق��A�����ł����B", 
       "�����ƕ������Ă��������B",
       "����͂���́B", 
       "�����?"};
   String kaiwa(String user){
      i = (int)(Math.random()* henji.length);
      n++;
      if(n>10) return  "�ł͂܂��ɂ��܂��傤�B";
      else if(i==0) return (user + "�Ƃ�" + henji[i]);
      else return henji[i];
   }
}  
