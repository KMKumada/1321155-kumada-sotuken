// ���X�g16.6 URL ���g����HTTP �N���C�A���g
import java.io.*;
import java.net.*;

public class HttpClientByURL {
   public static void main(String[] args) throws IOException {
      URL url;
      BufferedReader in = null;
      String host = "www.google.co.jp";
      url = new URL("http://" + host + "/index.html");
      in = new BufferedReader(new InputStreamReader(url.openStream()));

      String line;
      while ((line = in.readLine()) != null) {
	 System.out.println(line);
      }
      in.close();
   }
}
