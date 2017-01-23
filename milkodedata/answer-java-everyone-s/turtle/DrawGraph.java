/* —ûK–â‘è 7.10 ` 7.13, —ûK–â‘è 8.6 */

import java.awt.Color;

public class DrawGraph extends Turtle implements Drawable{
   /** gr ‚Ì”z—ñ‚Å—^‚¦‚ç‚ê‚½Ü‚êü‚ğ•`‚­ */
   public void draw(int x, int y, int[] gr){
      up(); 
      for (int i=0;i< gr.length/2;i++) {
	 moveTo(gr[i*2] + x,gr[i*2+1] + y);
	 down();
      }
   }

   /** gr ‚Å—^‚¦‚ç‚ê‚½Ü‚êü‚Ì”z—ñ‚ğ•`‚­ */
   public void draw(int x, int y, int[][] grs){
      for (int i=0;i< grs.length ;i++) {
	 draw(x, y, grs[i]);
      }
   }

   /** Turtle ƒNƒ‰ƒX‚Ì‚Á‚Ä‚¢‚é3•C‚Ì‹T‚ÌŠG‚ğ•`‚­ */
   public void draw(){
      setColor(Color.red); draw(150,200, turtleFig);
      setColor(Color.blue); draw(200,200, turtleRFig);
      setColor(Color.green); draw(250,200, turtleLFig);
   }

   /** ŒÄ‚Î‚ê‚é“x‚É, ˆÙ‚È‚éŠG‚ğ•`‚­ */
   int turn = 0;
   int[][][] figs = {turtleFig, turtleRFig, turtleLFig};

   public void draw(int x, int y){
      draw(x, y, figs[turn++ % 3]);
   }

   /** Ü‚êü‚ÌÀ•Wî•ñ‚ğ•ÏŠ·‚µ‚½Ü‚êü‚ğ¶¬ */
   static int[] trans(int[] gr, int th, double s){
      int xx, yy;
      double ra = th * Math.PI / 180;
      int[] na = new int[gr.length];
      for (int i=0;i< gr.length/2;i++) {
	 xx = gr[i * 2]; yy = gr[i * 2 + 1];
	 na[i * 2] = (int)(s * (xx * Math.cos(ra) - yy * Math.sin(ra)));
	 na[i * 2 + 1] = (int)(s * (xx * Math.sin(ra) + yy * Math.cos(ra)));
      }
      return na;
   }

   /** Ü‚êü‚Ì”z—ñ‚É‘Î‚µ‚Ä“¯‚¶‚±‚Æ‚ğs‚¤ */
   static int[][] trans(int[][] gr, int th, double s){
      int[][] aaa = new int[gr.length][];
      for (int i=0;i< gr.length;i++) {
	 aaa[i] =  trans(gr[i], th, s);
      }
      return aaa;
   } 

  /** Šeƒƒ\ƒbƒh‚ª³í‚É“®‚¢‚Ä‚¢‚é‚©’²‚×‚é‚½‚ß‚ÌƒTƒ“ƒvƒ‹ƒvƒƒOƒ‰ƒ€ */
   public static void main(String[] args){
      TurtleFrame f = new TurtleFrame();
      DrawGraph m = new DrawGraph();  f.add(m);
      m.draw();
      m.draw(100,100);
      m.draw(150,100);
      m.draw(200,100);
      m.draw(250,100);
      m.setColor(Color.pink); 
      m.draw(50,300, trans(turtleFig, 0, 0.3));
      m.draw(100,300, trans(turtleFig, 30, 0.5));
      m.draw(150,300, trans(turtleFig, 60, 0.7));
      m.draw(200,300, trans(turtleFig, 90, 1.0));
      m.draw(300,300, trans(turtleFig, 120, 2.0));
   }
}

