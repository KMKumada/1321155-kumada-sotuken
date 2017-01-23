//  ���K��� �얞�x����T�[�o
import java.net.*;
import java.io.*;
import java.util.*;

public class HimanServer {
   public static void main(String[] args) throws IOException {
      ServerSocket serverS = null;
      Socket clientS = null;
      try{
          serverS = new ServerSocket(50001);
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

      String fromS, fromU;
      HimandoHantei calc = new HimandoHantei();

      out.println("�얞�x�𔻒肵�܂��B");
      out.println("�얞�x����T�[�o: ���Ȃ��̑̏d(Kg)����͂��Ă��������B");
      fromU = in.readLine();  //�N���C�A���g�����͂����̏d��ǂ�

      try{
         calc.w = Double.parseDouble(fromU);  //�̏d��ݒ�
      } catch (NumberFormatException error){ calc.w = 0.0;}    
      
      out.println("�얞�x����T�[�o: ���Ȃ��̐g��(cm)����͂��Ă��������B");
      fromU = in.readLine();  //�N���C�A���g�����͂����g����ǂ�
      try{
         calc.h = Double.parseDouble(fromU);  //�g����ݒ�
      } catch (NumberFormatException error){ calc.h = 0.0;}    

      fromS = "�얞�x����T�[�o: ���Ȃ��̕W���̏d��" + calc.calcStdWeight() + "Kg�B" + "�얞�x��" + calc.judgeHiman() + "�ł��B";
      out.println(fromS);     //������N���C�A���g�ɓn��

      in.close();
      out.close();
      clientS.close();
      serverS.close();
    }
}


class HimandoHantei{
   double w, h; //�̏d�Ɛg��
   double calcStdWeight(){ //�W���̏d���v�Z
      return h/100 * h/100 * 22; 
   }

   double calcHimando(){  //�얞�x���v�Z
      return w /((h/100)*(h/100));
   }

   String judgeHiman(){  //�얞�x�𔻒�
      double him = calcHimando();
      if (him<=15) return "��������";
      else if (him>15 && him<=20) return "��������";
      else if (him>20 && him<=25) return "����";
      else if (him>25 && him<=30) return "���肬��";
      else return "���肷��";
   }
}
