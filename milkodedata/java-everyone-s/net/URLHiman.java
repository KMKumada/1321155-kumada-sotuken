// ���X�g16.7 URL�Ŏw�肳�ꂽCGI�v���O�����ƃf�[�^�����Ƃ�
import java.io.*;
import java.net.*;

public class URLHiman {
   public static void main(String[] args) throws Exception {
      if(args.length != 2){
	 System.out.println("���s���@: java URLHiman �̏d(Kg)�@�g��(cm)");
	 System.exit(1);
      }
      String strW = URLEncoder.encode(args[0], "UTF-8");
      String strH = URLEncoder.encode(args[1], "UTF-8");
      //CGI�v���O�����ւ�URL�͊e�����w�肵�Ă�������
      URL url = new URL("http://?????????????????/stdweight.cgi");
      URLConnection c = url.openConnection();
      c.setDoOutput(true);

      PrintWriter out = new PrintWriter(c.getOutputStream(), true);
      out.println("taiju=" + strW + "&shintyo=" + strH);
      BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
      String line;
      while ((line = in.readLine()) != null){ System.out.println(line); }
      out.close();
      in.close();
   }
}
