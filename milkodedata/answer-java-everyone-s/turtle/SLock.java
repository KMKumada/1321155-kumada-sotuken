public class SLock{
   boolean lo  = false;  // �I����đ҂��Ă���X���b�h������� true;
   synchronized void syncro() {
      if(lo){           // �҂��Ă�X���b�h�������
         lo = false;    //�҂��Ă�X���b�h������Ƃ�������͂�����
         notify();      // �N�����Ă�����
      }else{            // �����łȂ����
         lo = true;     // �҂��Ă�X���b�h������Ƃ������t����
         try{
            wait();     //  �҂�
         }catch(InterruptedException e){}
      }
   }
}
