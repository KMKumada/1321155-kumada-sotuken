public class Mikuji93 {
   public static void main(String[] args){
      try{
	 if(mikuji(args[0])){ 
	    System.out.println("‚ ‚½‚è");
	 }else{
	    System.out.println("‚Í‚¸‚ê");
	 } 
      }catch(NumberFormatException e){
	 System.out.println("ˆø”‚É”‚ğw’è‚µ‚Ä‚­‚¾‚³‚¢");
      }
   }
   static boolean mikuji(String s){
      int number;
      number = Integer.parseInt(s);  
      return (number == 7);      // number ‚Æ 7 ‚ª“™‚µ‚¯‚ê‚Î true,
   }                             // “™‚µ‚­‚È‚¯‚ê‚Î false ‚ª•Ô‚é`
}

