class SPolygon extends HTurtle implements Runnable {
   int n, s;
   SLock sl;
   SPolygon(int x, int y, int a, int n, int s, SLock sl){
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
   public static void main(String[] args)    {
      SLock sl = new SLock();
      TurtleFrame f = new TurtleFrame();
      SPolygon m1 = new SPolygon(100,50,90, 4, 40, sl);
      SPolygon m2 = new SPolygon(100,150,90, 5, 35, sl);
      f.add(m1);
      f.add(m2);
      Thread t1 = new Thread(m1);
      Thread t2 = new Thread(m2);
      t1.start();
      t2.start();
   }
}
