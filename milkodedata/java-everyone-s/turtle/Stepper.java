public class Stepper extends Turtle{
   public int n;                   //���J���ꂽ�C���X�^���X�ϐ� n �̐錾
   public int size;                //���J���ꂽ�C���X�^���X�ϐ� size �̐錾
   private int j = 0;              //�i����J�j�C���X�^���X�ϐ� j �̐錾
   public void step() { 
      if(j >= n)
         return;      //�`���I���Ă����Ȃ炷���I��
      fd(size);
      rt(360/n);
      j++;            //j �̒l�� 1 ���₷
   }
}
