// ���X�g17.1 �t�@�C����ǂ݁AArrayList�����A���ς��v�Z
import java.io.*;
import java.util.*;

public class ArrayListAve{
   void dataCalc() throws IOException{ //�t�@�C����ǂ݁A�R���N�V�������
      String entry;
      double weight=0, sum=0;
      List<Double> listW = new ArrayList<Double>();
      BufferedReader din = new BufferedReader(new FileReader("listdata.txt"));
      while ((entry=din.readLine()) != null) { //1�s�ǂ�
	 Scanner sc = new Scanner(entry);
	 if(sc.hasNext()) sc.next();
	 if(sc.hasNextDouble())weight = sc.nextDouble();
	 listW.add(weight);
      }
      din.close();
      for(Double x: listW){
	  sum = sum + x;
      }
      System.out.printf("����: %5.1fKg\n", sum/listW.size());       
   }

   public static void main(String[] args){
      ArrayListAve r = new ArrayListAve();
      try{
          r.dataCalc();   
      }catch(IOException error) { System.out.println("IO�G���[����");}
   }
}
