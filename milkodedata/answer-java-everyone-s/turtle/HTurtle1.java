public class HTurtle1 extends Turtle {    //Turtle ���g������ 
   public int polygon(int n, int s){   //polygon���\�b�h�̒�` 
      int a = 360/n;                     //�Ȃ���p�x�����߂Ă��� 
      for(int j = 0; j < n; j++){        //n ��J��Ԃ� 
         fd(s);                           //s �O�ɐi���
         rt(a);                           //a �Ȃ���̂�
      }
      return n * s;
   }
   public int house(int s){   //house ���\�b�h�̒�`
      int d = 0;
      d += polygon(4,s);                      //polygon �𗘗p
      fd(s); rt(30);
      d += polygon(3,s);
      lt(30); bk(s);                     //���̏ꏊ�ɖ߂��Ă���
      return d;
   }
} 
