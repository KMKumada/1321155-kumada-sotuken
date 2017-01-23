public class MyBuffer{    
   boolean avail = false;		// “o˜^‚³‚ê‚Ä‚¢‚é‚©
   Object value;			// “o˜^‚³‚ê‚é’l
   synchronized void put(Object n) {
      if(avail){       // ‚·‚Å‚Éƒf[ƒ^‚ª“o˜^‚³‚ê‚Ä‚¢‚é‚È‚ç‚Î
	 try{	
	    wait();    //  Á”ï‚³‚ê‚é‚Ì‚ğ‘Ò‚Â
	 }catch(InterruptedException e){}
      }
      value = n;  avail = true;
      notify();
   }
   synchronized Object get() {
      if(!avail){      // ƒf[ƒ^‚ª“o˜^‚³‚ê‚Ä‚¢‚È‚¢‚È‚ç‚Î
	 try{	
	    wait();    //  ‘Ò‚Â
	 }catch(InterruptedException e){}
      }
      avail = false;
      notify();
      return value;
   }
}
