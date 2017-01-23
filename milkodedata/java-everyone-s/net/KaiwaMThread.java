// ���X�g16.5 �J�E���Z���[�T�[�o�@�ʐM�����X���b�h
import java.net.*;
import java.io.*;
import java.util.*;

public class KaiwaMThread extends Thread {
   Socket socket = null;

   public KaiwaMThread(Socket s) {
      super("KaiwaMSThread");
      socket = s;
   }

    public void run() {
      try{
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         BufferedReader in = new BufferedReader(
                           new InputStreamReader(socket.getInputStream()));

         String fromC, fromUser;
         Counsel c = new Counsel();
         out.println("���ł��b���Ă�������");
         while ((fromUser = in.readLine()) != null) {
            fromC = c.kaiwa(fromUser);
            out.println(fromC);
            if (fromC.equals("�ł͂܂��ɂ��܂��傤�B")) break;
         }
         in.close();
         out.close();
         socket.close();
      } catch (IOException e) { 
         System.out.println("run���\�b�h���s����O: " + e);
         System.exit(1);
      }
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
