/** ���G�������\�b�h������Turtle �N���X�B
 */
public class MyTurtle extends HTurtle{
   /** n ���̉Ƃ�傫�� s �� w �̊Ԋu�ŕ`���B
       �R�����g��2���ȏ�ɂȂ��Ă���ꍇ�Cjavadoc �́C1�ڂ������T�v�ɍڂ���B*/ 
   public void houses(int n, int s, int w){
      for(int i = 0; i < n; i++){
	 house(s);
	 rt(90); up(); fd(w+s); down(); lt(90);
      }
   }

   /** n �p�`�̎����m �p�`��1�ӂ̒��� s �ŕ`���B*/ 
   public void ppolygon(int n, int m, int s){
      for(int j = 0; j < n; j++){
	 polygon(m, s);
	 fd(s);
	 lt(360/n);
      }
   }

   /** 1�ӂ̒��� s �� n �p�`�� r ���񂵂Ȃ���`���B*/ 
   public void flower(int n, int r, int s){
      for(int j = 0; j < r; j++){
	 polygon(n, s);
	 rt(360/r);
      }
   }
   /** 1�ӂ̒��� s �� n �p�`�� r ���񂵂Ȃ���`���B
       n �p�`�̈�̕ӂ́C��]�̒��S���� l �����ړ������ꏊ����
       d �����E��]���������Ɏn�܂�B*/ 
   public void rflower(int n, int r, int s, int l, int d){
      for(int j = 0; j < r; j++){
	 up(); fd(l);rt(d);down();
	 polygon(n, s);
	 up(); lt(d);bk(l);down();
	 rt(360/r);
      }
   }

   /** (x, y) �������̍��W�ɂ��C1�ӂ̒��� s �ŉƂ̊G��`���B*/ 
   public void house(int x, int y, int s){
      up(); moveTo(x, y, 0); down();
      house(s);
   }

   /** n ���̉Ƃ�傫�� s �� w �̊Ԋu�ŕ`���B*/ 
   public void houses(int x, int y, int n, int s, int w){
      up(); moveTo(x, y, 0); down();
      houses(n, s, w);
   }

   /** �R���X�g���N�^�C���K��� 7.8 �Œǉ��B*/
   public MyTurtle(int x, int y, int angle){
      super(x, y, angle);
   }
   public MyTurtle(){
      super();
   }
}