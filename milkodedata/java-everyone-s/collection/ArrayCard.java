// ���X�g17.3 �g�����v�J�[�h���ꖇ����
import java.util.*;

public class ArrayCard{
   public static void main(String[] args){
       String[] suit = {"�X�y�[�h", "�n�[�g", "�_�C��", "�N���u"};
       String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
       List<String> listC = new ArrayList<String>();
       for(String s : suit){
           for(String t : num){
	       listC.add(s + "��" + t);
           }
       }
       Collections.shuffle(listC);
       System.out.println(listC.get(0));
   }
}
