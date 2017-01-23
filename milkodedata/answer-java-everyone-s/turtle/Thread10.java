/* answer �̒��� HTurtle.java ��
���K��� 10.3 �̂��߂ɁCsynchronized ���e���\�b�h�ɂ��Ă���̂ŁC
���X�g10.4�Ɠ��삪�Ⴄ���Ƃɒ��ӁB
 */

public class Thread10 extends Thread{
   int n, s;
   HTurtle mh;
   Thread10(int n, int s, HTurtle m)  {
      this.n = n;
      this.s = s;
      this.mh = m;
   }
   public void run(){
      mh.polygon(n,s);
      mh.house(s);    
   }
   public static void main(String[] args)    {
      TurtleFrame f = new TurtleFrame();
      HTurtle m = new HTurtle();
      f.add(m);
      Thread10 t1 = new Thread10(3,50,m);
      Thread10 t2 = new Thread10(5,40,m);
      t1.start();
      t2.start();
      System.out.println("Main method finished."); 
   }
}
