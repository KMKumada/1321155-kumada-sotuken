// ���K��� �t�@�C����ǂ݁A�̏d���L�[��TreeMap�����B
// �̏d�Ń\�[�g���ꂽ�ꗗ��\������B
import java.io.*;
import java.util.*;
public class SortWeight{
   void dataCalc() throws IOException{
      String entry, name=" ";
      double weight=0;
      int index=0;
      Map<Double, String> map;  //Map�̕ϐ���錾
      map = new TreeMap<Double, String>();//TreeMap�𐶐�
      BufferedReader din = new BufferedReader(new FileReader("listdata.txt"));
      while ((entry=din.readLine()) != null) { //1�s�ǂ�
	 Scanner sc = new Scanner(entry);
	 if(sc.hasNext()) name = sc.next();
	 if(sc.hasNextDouble())weight = sc.nextDouble();
	 map.put(weight, name); //Map�ɗv�f��put
      }
      din.close();
      Set<Double> c = map.keySet(); //�L�[�̃R���N�V���������o��
      for(Double d: c){ //�ϐ�d�ɃL�[�ł���Double�^�̃I�u�W�F�N�g����������
        System.out.println(map.get(d) + "����̃f�[�^: " + d + "Kg");
      }
   }    
   public static void main(String[] args){
      SortWeight r = new SortWeight();
      try{
              r.dataCalc();   
      }catch(IOException error) { System.out.println("IO�G���[����");}
   }
}
