public class SLock3{
   int n = 3;     //�҂����킹�̌��B
   int num = 0;   // �I����đ҂��Ă���X���b�h�̌� true�B
   synchronized void syncro() {
      if(num == n-1){           // �҂��Ă�X���b�h�� n-1 �Ȃ�
	 num = 0;
         notifyAll();      // �N�����Ă�����
      }else{            // �����łȂ����
	 num += 1;
         try{
            wait();     //  �҂�
         }catch(InterruptedException e){}
      }
   }
   /* �R���X�g���N�^�[ */
   SLock3(){
   }
   SLock3(int n){
      this.n = n;
   }
}
