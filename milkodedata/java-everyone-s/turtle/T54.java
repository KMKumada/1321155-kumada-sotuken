public class T54 {
   public static void main(String[] args){
      TurtleFrame f = new TurtleFrame(600,300);
      Turtle[] hm = new Turtle[10];            // �z��I�u�W�F�N�g�𐶐�
      for(int i = 0 ; i < 10; i++){
         hm[i] = new Turtle(i * 50 + 25,150,0); // �^�[�g���𐶐��C�z��̊e�v�f�ɑ��
         f.add(hm[i]);
      }
      for(Turtle m:hm){ 
	 for(int j = 0; j < 6; j++){
	    m.fd(10);     
	    m.rt(360/6);  
	 }
      }
   }
}
