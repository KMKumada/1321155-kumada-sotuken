public class P48 {       
   public static void main(String[] args){
      int r = 12;     // ����
      int n = 4;      // ���p�`
      int size = 50;  // 1�ӂ̒���
      int distance = size/2;  // ���S���珑���o�����_�܂ł̋���
      int theta = 135;  // �����o�����_�ł̌X��
//  int distance = -size/2, theta = 0;    ���ȏ����̊G
//  int distance = size/2, theta = 0;     ���ȏ��E�̊G

      TurtleFrame f =  new TurtleFrame();  
      Turtle m = new Turtle(); 
      f.add(m);
      for(int i = 0; i < r; i++){
	 m.up();m.fd(distance); m.rt(theta);m.down();
	 for(int j = 0; j < n; j++){
	    m.fd(size);
	    m.rt(360/n);
	 }
	 m.up(); m.lt(theta);m.bk(distance); m.down();
	 m.rt(360/r);
      }
   }
}