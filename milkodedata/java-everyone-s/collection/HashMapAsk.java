// ���X�g17.2 �t�@�C����ǂ݁AHashMap�����B�����Ŏw�肳�ꂽ�l�̃f�[�^��\������B
import java.io.*;
import java.util.*;
public class HashMapAsk{
   void dataCalc(String nn) throws IOException{
      String entry, name=" ";
      double weight=0, height=0;
      int index=0;
      Map<String, HData> map = new HashMap<String, HData>();  //Map�̕ϐ���錾,HashMap�𐶐�
      BufferedReader din = new BufferedReader(new FileReader("listdata.txt"));
      while ((entry=din.readLine()) != null) { //1�s�ǂ�
	 Scanner sc = new Scanner(entry);
	 if(sc.hasNext()) name = sc.next();
	 if(sc.hasNextDouble())weight = sc.nextDouble();
	 if(sc.hasNextDouble())height = sc.nextDouble();
	 map.put(name, new HData(weight, height)); //Map�ɗv�f��put
      }
      din.close();
      HData r = map.get(nn);  //Map����L�[�̒l������
      if(r==null){System.out.println("�f�[�^�͂���܂���");}
      else {System.out.println(nn + "����̃f�[�^: " + 
                                   r.w + "Kg, " + r.h + "cm"); 
      }
   }    
   public static void main(String[] args){
      HashMapAsk r = new HashMapAsk();
      if(args.length ==0){ System.out.println("���O���w�肵�Ă�������");}
      else {
         try{
              r.dataCalc(args[0]);   
         }catch(IOException error) { System.out.println("IO�G���[����");}
      }
   }

    class HData{  //�f�[�^�ێ��p�̃N���X
	double w; //�̏d
        double h; //�g��
        HData (double ww, double hh){
	    w = ww;
            h = hh;
	}
    }
}
