// ���K��� �t�@�C����ǂ݁AArrayList�����A�����Ŏw�肳�ꂽ���O�̑̏d���o��
import java.io.*;
import java.util.*;

public class AskWeight{
   

   void dataCalc(String nn) throws IOException{ //�t�@�C����ǂ݁A�R���N�V�������
      String entry, name=" ";
      double weight=0;
      int index=0;
      List<Double> listW = new ArrayList<Double>();
      List<String> listN = new ArrayList<String>();
      BufferedReader din = new BufferedReader(new FileReader("listdata.txt"));
      while ((entry=din.readLine()) != null) { //1�s�ǂ�
	 Scanner sc = new Scanner(entry);
	 if(sc.hasNext()) name = sc.next();
	 if(sc.hasNextDouble())weight = sc.nextDouble();
	 listN.add(name);
	 listW.add(weight);
      }
      din.close();
      index = listN.indexOf(nn);
      if(index == -1){System.out.println("�f�[�^�͂���܂���");}
      else {System.out.println(nn + "����̑̏d��" + listW.get(index) + "Kg"); }   }    

   public static void main(String[] args){
      AskWeight r = new AskWeight();
      if(args.length ==0){ System.out.println("���O���w�肵�Ă�������");}
      else {
         try{
              r.dataCalc(args[0]);   
         }catch(IOException error) { System.out.println("IO�G���[����");}
      }
   }
}
