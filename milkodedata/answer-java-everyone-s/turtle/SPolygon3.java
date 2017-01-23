class SPolygon3 extends HTurtle implements Runnable {
   int n, s;
   SLock3 sl;
   SPolygon3(int x, int y, int a, int n, int s, SLock3 sl){
      super(x, y, a);
      this.n = n; this.s = s; this.sl = sl;
   }
   public void run(){
      while(true){
         speed((int)(Math.random() * 40)); // ����X�s�[�h��ς���
         polygon(n, s);   // ���p�`��`����
         fd(s);           // �ꏊ���ړ�����
         sl.syncro();     // ����̓���̏I����҂�
      }
   }
/* �����ŁC�����̃^�[�g���������s�����邩�w�肵�Ă��������B */
   public static void main(String[] args)    {
      int numclient = 3;
      if(args.length > 0) numclient = Integer.parseInt(args[0]);
      SLock3 sl = new SLock3(numclient);
      TurtleFrame f = new TurtleFrame();
      SPolygon3 m[] = new SPolygon3[numclient];
      for(int i = 0; i < numclient; i++){
	 m[i] = new SPolygon3(100,50 + 100 * i,90, i+3, 120/(i+2), sl);
	 f.add(m[i]);
	 (new Thread(m[i])).start();
      }
   }
}
