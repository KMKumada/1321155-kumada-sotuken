public class Mikuji91 {
   public static void main(String[] args){
      if(mikuji(args[0])){ 
           System.out.println("������");
      }else{
           System.out.println("�͂���");
      } 
   }
   static boolean mikuji(String s){
      int number;
      number = Integer.parseInt(s);  
      return (number == 7);      // number �� 7 ����������� true,
   }                             // �������Ȃ���� false ���Ԃ�`
}
