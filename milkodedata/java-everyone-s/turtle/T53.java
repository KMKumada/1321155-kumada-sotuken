public class T53 {
   public static void main(String[] args){
      TurtleFrame f = new TurtleFrame(600,300);
      Turtle[][] tm = new Turtle[3][]; // �z��̔z��쐬
      for(int n = 0 ; n < tm.length; n++){
         tm[n] = new Turtle[n + 2];  //n �Ԗڂɂ́Cn+1 �̑傫���Ŕz��쐬
         for(int m = 0 ; m < tm[n].length; m++){
            tm[n][m] = new Turtle(m * 50 + 50,n * 50 + 50,0);
            f.add(tm[n][m]);
         }
      }
      for(int n = 0 ; n < tm.length; n++){
         for(int m = 0 ; m < tm[n].length; m++){
            for(int j = 0; j < n + 3; j++){
                tm[n][m].fd((m + 1) * 10);
                tm[n][m].rt(360/(n+3));
            }
         }
      }
   }
}
