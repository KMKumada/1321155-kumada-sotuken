public class Janken41 {
   public static void main(String[] args){
      double c = Math.random();
      if(c < 1.0/3){
	 System.out.println("�O�[");
      }else if(c < 2.0/3){
	 System.out.println("�`���L");
      }else{
	 System.out.println("�p�[");
      }
   }
}