/* answer �̒��̂��̃t�@�C���ł́C
���K��� 10.3 �̂��߂ɁCsynchronized ���e���\�b�h�ɂ��Ă���B */

public class HTurtle extends Turtle {    //Turtle ���g������ 
   synchronized public void polygon(int n, int s){   //polygon���\�b�h�̒�` 
      int a = 360/n;                     //�Ȃ���p�x�����߂Ă��� 
      for(int j = 0; j < n; j++){        //n ��J��Ԃ� 
         fd(s);                           //s �O�ɐi���
         rt(a);                           //a �Ȃ���̂�
      }
   }
   synchronized public void house(int s){   //house ���\�b�h�̒�`
      polygon(4,s);                      //polygon �𗘗p
      fd(s); rt(30);
      polygon(3,s);
      lt(30); bk(s);                     //���̏ꏊ�ɖ߂��Ă���
   }

   // �R���X�g���N�^�[�C���K���7.8�Œǉ��B 
   public HTurtle(int x, int y, int angle){
      super(x, y, angle);
   }
   public HTurtle(){
      super();
   }
} 
