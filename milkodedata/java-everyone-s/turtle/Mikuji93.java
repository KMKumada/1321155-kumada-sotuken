public class Mikuji93 {
   public static void main(String[] args){
      try{
	 if(mikuji(args[0])){ 
	    System.out.println("������");
	 }else{
	    System.out.println("�͂���");
	 } 
      }catch(NumberFormatException e){
	 System.out.println("�����ɐ����w�肵�Ă�������");
      }
   }
   static boolean mikuji(String s){
      int number;
      number = Integer.parseInt(s);  
      return (number == 7);      // number �� 7 ����������� true,
   }                             // �������Ȃ���� false ���Ԃ�`
}

