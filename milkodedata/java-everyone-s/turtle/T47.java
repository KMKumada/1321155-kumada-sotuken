public class T47 {
   public static void main(String[] args){
      TurtleFrame f = new TurtleFrame();
      Turtle m = new Turtle();
      f.add(m);
      for(int i = 0; i < 12; i++){
	 if(i % 3 == 0){             // i �� 3 �̔{���̂Ƃ�
	    m.setColor(java.awt.Color.red);
	 }else if (i % 3 == 1) {    // i �� 3 �Ŋ����ė]��1�̂Ƃ�
	    m.setColor(java.awt.Color.green);
	 }else{                    // ����ȊO�i3 �Ŋ����ė]��2�j�̂Ƃ�
	    m.setColor(java.awt.Color.yellow);
	 }
	 m.lt(30);
	 m.fd(50);
      }
   }
}





