import java.io.*;
public class MyBuffern{    
   /*  values �Ƀf�[�^���L�������B�C���f�b�N�X0 ���珇�ɋL������C
    *   size �̑傫���܂ŋL�������ƁC�擪�ɖ߂��ċL�������Btopp ��
    *   �L���̐擪�Cbotomp ����Ԑ̂ɋL������Ă܂������ĂȂ����́B
    */
   int size;
   Object values[];	      
   int topp = 0, botomp = 0;  
   MyBuffern(int size){
      this.size = size;
      values = new Object[size];
   }
   synchronized void put(Object n) {
      if(botomp == (topp + 1)%size){       // ���łɃf�[�^����t�Ȃ�
	 try{	
	    wait();    //  ������̂�҂�
	 }catch(InterruptedException e){}
      }
      values[topp] = n;
      topp= (topp+1)%size;
      notify();
   }
   synchronized Object get() {
      if(botomp ==topp){      // �f�[�^���S���Ȃ��Ȃ��Ȃ��
	 try{	
	    wait();    //  �҂�
	 }catch(InterruptedException e){}
      }
      Object v = values[botomp];
      botomp = (botomp+1)%size;
      notify();
      return v;
   }

   /* �T���v���v���O�����B���͂��ꂽ������i���s�ŏI���j���L�����Ȃ�
    * ��C1�b�����ɑ啶���ɕϊ����ĂP�Â\������B�L�����Ă��镶����
    * ���Ȃ���΁C���͂�҂B5�ȏ�L����v�������ƁC�҂��Ă���L��
    * ����B���̊Ԃɓ��͂��ꂽ��������COS �ɂ���ċL�������̂ŁC����
    * �ڂɂ́C�҂��Ă��邱�Ƃ�������Ȃ��B
    */

   public static void main(String[] args) {
      final MyBuffern b = new MyBuffern(5);
      Thread p = new Thread(){   //�����ł́C�����N���X���g���Ă݂�B
	    public void run(){   // Thread �N���X�̃T�u�N���X�ł��� run ����`���ꂽ
	       try{              // �N���X���`���C���̃I�u�W�F�N�g��1�쐬����Ƃ���
		  while(true){   // �Ӗ��ɂȂ�B
		     Thread.sleep(1000); 
		     System.out.println(((String)(b.get())).toUpperCase());
		  }             // b ������o�������̂̕\������������B
	       }catch(InterruptedException e){}
	    }
	 };                      //�����܂ł������N���X�̒�`
      p.start();
      String c;
      BufferedReader bin = new BufferedReader(  // ���o�͂ɂ��Ă�15�͎Q�ƁB
	 new InputStreamReader(System.in));
      try{
	 while(true){
	    c = bin.readLine();            // ���͂��ꂽ������� b �ɓo�^���Â���B
	    b.put(c);
	 }
      }catch(IOException e){}
   }
}