public class Mikuji92 {
   public static void main(String[] args){
      if(mikuji(args[0])){ 
           System.out.println("������");
      }else{
           System.out.println("�͂���");
      } 
   }
   static boolean mikuji(String s){
      int number;
      try{
	 number = Integer.parseInt(s);
      }catch(NumberFormatException e){
	 System.out.println(e.getMessage());
	 System.out.println("�����ɐ����w�肵�Ă�������");
	 number = -1;
      }
      return (number == 7);      // number �� 7 ����������� true,
   }                             // �������Ȃ���� false ���Ԃ�`
}



