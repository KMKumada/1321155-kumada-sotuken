public class Hoteisiki41{
   public static void main(String[] args){
      int x;
      for (x = 0; x < 100; x++){
         if(x * x - 145 * x + 3616 == 0)break; //���� break�������s������ 
      }                                        // 4�`6 �s�ڂ� for �����I������B
      if (x < 100) System.out.println(x); 
      else System.out.println("Not exist");
   }
}
