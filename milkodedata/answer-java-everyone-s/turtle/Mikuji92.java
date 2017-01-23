public class Mikuji92 {
   public static void main(String[] args){
      if(mikuji(args[0])){ 
           System.out.println("‚ ‚½‚è");
      }else{
           System.out.println("‚Í‚¸‚ê");
      } 
   }
   static boolean mikuji(String s){
      int number;
      try{
	 number = Integer.parseInt(s);
      }catch(NumberFormatException e){
	 System.out.println(e.getMessage());
	 System.out.println("ˆø”‚É”‚ğw’è‚µ‚Ä‚­‚¾‚³‚¢");
	 number = -1;
      }
      return (number == 7);      // number ‚Æ 7 ‚ª“™‚µ‚¯‚ê‚Î true,
   }                             // “™‚µ‚­‚È‚¯‚ê‚Î false ‚ª•Ô‚é`
}



