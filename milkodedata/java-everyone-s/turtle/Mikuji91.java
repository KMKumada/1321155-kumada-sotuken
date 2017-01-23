public class Mikuji91 {
   public static void main(String[] args){
      if(mikuji(args[0])){ 
           System.out.println("‚ ‚½‚è");
      }else{
           System.out.println("‚Í‚¸‚ê");
      } 
   }
   static boolean mikuji(String s){
      int number;
      number = Integer.parseInt(s);  
      return (number == 7);      // number ‚Æ 7 ‚ª“™‚µ‚¯‚ê‚Î true,
   }                             // “™‚µ‚­‚È‚¯‚ê‚Î false ‚ª•Ô‚é`
}
