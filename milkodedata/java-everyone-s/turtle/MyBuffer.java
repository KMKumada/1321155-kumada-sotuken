public class MyBuffer{    
   boolean avail = false;		// �o�^����Ă��邩
   Object value;			// �o�^�����l
   synchronized void put(Object n) {
      if(avail){       // ���łɃf�[�^���o�^����Ă���Ȃ��
	 try{	
	    wait();    //  ������̂�҂�
	 }catch(InterruptedException e){}
      }
      value = n;  avail = true;
      notify();
   }
   synchronized Object get() {
      if(!avail){      // �f�[�^���o�^����Ă��Ȃ��Ȃ��
	 try{	
	    wait();    //  �҂�
	 }catch(InterruptedException e){}
      }
      avail = false;
      notify();
      return value;
   }
}
