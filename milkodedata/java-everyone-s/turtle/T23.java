public class T23 {
   public static void main(String[] args){
      int d = 100, x, y, a;
      TurtleFrame f = new TurtleFrame(); 
      Turtle m = new Turtle(200,300,0);  
      f.add(m);                       
      m.fd(d);                        
      x = m.getX();                // m ��X ���W�̂Ƃ�o��
      y = m.getY();                // m ��Y ���W�̂Ƃ�o��
      a = m.getAngle() - 45;       // m �̊p�x�̂Ƃ�o��
      Turtle m1 = new Turtle(x, y, a); //m1 �̐���
      f.add(m1);              
      m1.fd(d);
      Turtle m2 = m.clone();       //m2 �̐���
      f.add(m2);                
      m.rt(45);                        
      m.fd(d);
      m2.tcolor = new java.awt.Color(0,255,255); // m2 �̋T�̐F�𐅐F�ɕς���
      m2.tscale = m2.tscale * 4;  // m2 �̋T�����݂� 4 �{�̑傫���ɂ���
      m2.fd(d);               
   }
}
