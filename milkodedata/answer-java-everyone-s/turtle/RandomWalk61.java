public class RandomWalk61 {
   public static void main(String[] args){
      TurtleFrame f = new TurtleFrame();
      Turtle m = new Turtle();
      f.add(m);
      for(;;){   // ��������₱�����̂ŁCwhile ���ł͂Ȃ��������[�v�ɂ���
                 // break �łʂ��邱�Ƃɂ����B
	 int x = m.getX();
	 int y = m.getY();
	 System.out.println("("+ x +","+ y +")");
	 if(x < 0 || x > 400 || y < 0 || y > 400) break; 
	 m.fd((int)(Math.random()*50));
	 m.rt((int)(Math.random()*360));
      }
   }
}

