public class T81{
   public static void main(String[] args){
      TurtleFrame f = new TurtleFrame();
      Turtle m;  
      if(args.length > 0){     // �R�}���h���s���Ɉ������^�������
         m = new HTurtle();    // HTurtle �𐶐����� m �ɑ��
      }else{                   // �����łȂ���� 
         m = new Turtle();     // Turtle �𐶐����� m �ɑ��
      }
      f.add(m);
      m.fd(100); m.rt(36);     //m �� HTurtle �� Turtle �Ɨ����̉\������
      turtleStar(m); 
   }
   static void turtleStar(Turtle t){ 
      for(int i = 0; i < 5; i++){
         t.fd(100); t.rt(144);
      }
   }
}
