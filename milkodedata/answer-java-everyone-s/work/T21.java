import tg.*;
/** �ŏ��̃v���O�����̗� */
public class T21 {         
   public static void main(String[] args){
      TurtleFrame f;             // �ϐ� f �̌^�錾
      f =  new TurtleFrame();    // TurtleFrame�𐶐���f�ɑ��
      Turtle m = new Turtle();   // Turtle �𐶐����Cm �̏����l�Ƃ��đ��
      Turtle m1 = new Turtle();  // ������������Cm1 �̏����l�Ƃ��đ��
      f.add(m);                  // f �� m ��ǉ�
      f.add(m1);                 // f �� m1 ��ǉ�
      m.fd(100);                 // m ��O�� 100 �i��
      m.rt(90);                  // m ��E�� 90 �x���
      m.fd(150);                 // m ��O�� 150 �i��
      m1.rt(90);                 // m1 ��E�� 90 �x���
      m1.fd(100);                // m1 ��O�� 150 �i��
   }
}   
