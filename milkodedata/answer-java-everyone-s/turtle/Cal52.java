public class Cal52 {
   public static void main(String[] args){
      int m = 8;
      int d = 20;

      int[] mon = {0,31,28,31,30,31,30,31,31,30,31,30,31};
      String[] week = {"���j��","���j��","�Ηj��","���j��","�ؗj��","���j��","�y�j��"};
      int gantan = 1;

      int sum = 0;
      for(int i = 1; i < m; i++){
	 sum += mon[i];
      }
      sum += d;
      System.out.println(sum);
      int wday = (sum - 1 + gantan) % 7;

      System.out.println(week[wday]);
   }
}