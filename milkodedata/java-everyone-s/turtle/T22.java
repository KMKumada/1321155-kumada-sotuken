public class T22 {
   public static void main(String[] args){   
      int x = 300, y = 200, d = 100;           //  int �^�̕ϐ���p��
      TurtleFrame f = new TurtleFrame(700,500);//�����̂���R���X�g���N�^�ďo��
      Turtle m = new Turtle(x,y,180);   
      Turtle m1 = new Turtle(x+ d,y+ d,0);    
      java.awt.Color c = new java.awt.Color(255,0,0);// �ԐF�I�u�W�F�N�g�𐶐�
      m1.setColor(c);                         // m1 �̐F��ԐF�Ɏw��
      f.add(m);                                 
      f.add(m1);                                
      m.fd(d);                                  
      m1.fd(d);                                 
      m.lt(90);                                 
      m1.lt(90);                                
      d = d / 2;   //d �̒l�� d/2 �ɕύX        
      m.fd(d);                                  
      m1.fd(d);                                 
      m1.moveTo(m);                             
   }
}
