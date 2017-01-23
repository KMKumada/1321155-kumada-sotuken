/* ���ȏ��̗��ɑ΂��C Spinner �𗘗p���Cabort �{�^����ǉ����Ă���B

Spinner �̗��p���@�F
   new JSpinner(); �ō���� spinner �́C�l�ɐ������Ȃ��B
   �����l v, �ŏ��l min, �ő�l max, �X�e�b�v s �� spinner �́C
   spinner = new JSpinner(new SpinnerNumberModel(v,min,max,s));
   �ō쐬����B

   spinner �́CChangeEvent �C�x���g�𔭐�����BChangeEvent �ɂ��Ă�
   P185 �̐������Q�ƁB


abort �{�^�����쐬����ɂ́F

    �{�^���������ꂽ�Ȃǂ� GUI �̏����͈�̃��\�b�h�ōs���Ă���̂ŁC
    ���̃{�^���ɂ��N�����ꂽ���\�b�h�����s���Ă���Ԃ́C���̃��\�b�h
    ���N���ł��Ȃ��B����āC���ݍs���Ă��鏈�����~�߂邽�߂� abort �{
    �^���́C���̂܂܂ł͎����ł��Ȃ��B�����ł́C�`�揈���́CGUI ����N
    �����ꂽ���\�b�h�ł͂Ȃ��C�ʃ��\�b�h�Ɏ��������Ă���Babort �{�^��
    ���������ƁC���ꂪ�����ꂽ���Ƃ������ϐ� stop �� true �ɂ��C�`��
    �����̃��\�b�h�͂��̒l�����āC�r���ŏ������I������B�������I������
    �̂ɁC��O�𔭐��ithrow�j�����Ă���B

*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;   //ChangeListener �𗘗p���鎞�ɂ��� import ���K�v
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;

public class LevyPanel extends JPanel implements ActionListener, ChangeListener{
   int n = 0;               // `�J��Ԃ���`
   int M = 250;           // 1�ӂ̒���(�I�t�X�N���[����)
   // M ��ύX���ăR���p�C�����Ȃ����΁C���ׂ����摜������B
   int W = M * 3, H = M * 3; // �I�t�X�N���[���̉摜�̃T�C�Y
   int WW = 800, WH = 800;
   BufferedImage bi;
   Graphics2D bg;
   Canvas v;
   JSpinner spinner;
   JButton abort;
   Thread th;
   boolean stop = false;

   JRadioButton single, multi;
   ButtonGroup gr;

   double zoom = 1.0;
   JButton zoomin, zoomout;
   JScrollPane sp;

   LevyPanel(){
      v = new Canvas();
      bi = new BufferedImage(W, H, BufferedImage.TYPE_INT_RGB);
      bg = (Graphics2D) bi.createGraphics();
      bg.fillRect(0,0,W,H); 
      bg.setColor(Color.black); 
      v.setPreferredSize(new Dimension(W, H)); 

      sp = new JScrollPane(v);
      sp.setPreferredSize(new Dimension(WW, WH));
      setLayout(new BorderLayout());
      add(sp,BorderLayout.CENTER);

      JPanel cp = new JPanel(new GridLayout(0,1));
      single = new JRadioButton("single", true);
      multi =  new JRadioButton("multi");
      gr = new ButtonGroup();
      gr.add(single);  gr.add(multi);
      cp.add(single); cp.add(multi);
      single.addActionListener(this);
      multi.addActionListener(this);
      cp.add(new JLabel(""));
      spinner = new JSpinner(new SpinnerNumberModel(0,0,50,1)); spinner.addChangeListener(this); cp.add(spinner);
      cp.add(new JLabel(""));
      abort = new JButton("abort"); abort.addActionListener(this);
      cp.add(abort);

      zoomin = new JButton("Zoom in"); zoomin.addActionListener(this); cp.add(zoomin);
      zoomout = new JButton("Zoom out"); zoomout.addActionListener(this); cp.add(zoomout);

      JPanel cpp = new JPanel(new FlowLayout());
      cpp.add(cp);
      add(cpp, BorderLayout.EAST);
      paintit();
   }
   public void zooming(double zoom){
      double origzoom = this.zoom;
      this.zoom = zoom;
      Point p = sp.getViewport().getViewPosition(); //����̍��W
      v.setPreferredSize(new Dimension((int)(W * zoom), (int)(H * zoom))); 
      v.revalidate();
      sp.getViewport().setViewPosition(new Point((int)(p.x*zoom/origzoom) , (int)(p.y*zoom/origzoom)));   //���Ɠ����_������̍��W�ɗ���悤�ɒ����B
   }



   public void stateChanged(ChangeEvent e){  
             //JSpinner �̏�Ԃ��ς�������̃C�x���g
      paintit();
   }

   public void actionPerformed(ActionEvent e){ 
      Object orig = e.getSource();
      if(orig == abort) {
	 if (th != null) stop = true; 
	 return;
              // �X���b�h���I��������̂ɁC�����狭���I������̂ł͂Ȃ��C
              //stop �Ƃ����ϐ��̒l��ݒ肷�邾���Ƃ���B�X���b�h��������
              //stop �̒l�����āC�K�v�Ȃ�I������BP103, �T���U
      }
      if(orig == zoomin){ zooming(zoom * 1.2); repaint(); return;}
      if(orig == zoomout){ zooming(zoom / 1.2); repaint(); return;}
   }
   public void paintit(){
      // �ʃX���b�h�������Ă�����C�������Ȃ��B
      if(th != null) return;

      n = (Integer)(spinner.getValue());
      bg.setColor(Color.white); 
      bg.fillRect(0,0,W,H); 
      th = new Thread(){ // �����N���X�Ƃ��āCThread�̃T�u�N���X���`
	                 // ���Ȃ���C���̃I�u�W�F�N�g�𐶐�  (P75)
	    public void run() {
	       try{
		  if(multi.isSelected()){
		     for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
			   bg.setColor(Color.getHSBColor((float)(i*3+j)/9,0.6f,0.6f));
			   levy(i*M, j*M, i*M, (j+1)*M, n);
			   bg.setColor(Color.getHSBColor((float)((i*3+j+2)%9)/9,0.8f,0.8f));
			   levy(i*M, (j+1)*M, (i+1)*M, (j+1)*M, n);
			   bg.setColor(Color.getHSBColor((float)((i*3+j+4)%9)/9,0.7f,0.7f));
			   levy((i+1)*M, (j+1)*M, (i+1)*M, j*M, n);
			   bg.setColor(Color.getHSBColor((float)((i*3+j+6)%9)/9,1.0f,1.0f));
			   levy((i+1)*M, j*M, i*M, j*M, n);
			}
		     }
		  }
		  bg.setColor(Color.black);
		  levy(M,2*M,2*M,2*M,n);
	       }catch(Exception e) {   // ���� throw �ŁC�����܂łʂ��Ă���B
		  System.out.println("CATCH STOP");
		  stop = false;}
	       th = null;
	       stop = false;
	    }

	    public void levy(float x1, float y1, float x2, float y2, int n) throws Exception{
	       if(stop){ // stop �� true �Ȃ�C�����ŃX���b�h���I������B
		  System.out.println("STOP");
		  throw(new Exception());  // ��O���N�����āC�����Ȃ�ʂ���B(P97)
	       }
	       float x3 = (x2 + x1)/2 + (y2-y1)/2;
	       float y3 = (y2+y1)/2 - (x2 - x1)/2;
      
	       if(n == 0){
		  if (x1+x2+x3 < 0){ x1 += W; x2 += W; x3 += W;}
		  if (x1+x2+x3 > 3*W){ x1 -= W; x2 -= W; x3 -= W;}
		  if (y1+y2+y3 < 0){ y1 += H; y2 += H; y3 += H;}
		  if (y1+y2+y3 > 3*H){ y1 -= H; y2 -= H; y3 -= H;}
		  int[] xx = new int[]{(int)x1,(int)x2,(int)x3};
		  int[] yy = new int[]{(int)y1,(int)y2,(int)y3};
		  bg.fillPolygon(xx, yy, 3);
		  bg.drawPolygon(xx, yy, 3);
	       }else{
		  levy(x1, y1, x3,y3, n-1);
		  levy(x3, y3, x2,y2, n-1);
	       }
	       repaint();
	       // �`��ƕʃX���b�h�Ȃ̂ŁC�����ɓ����Ɠr���o�߂��`��
	       // �����B
	    }

	 };// �����܂ł������N���X�̒�`�ƃI�u�W�F�N�g���� (run �� levy �͂��̃��\�b�h)
      th.start();
   }

   class Canvas extends JPanel{
      Canvas(){
	 setBackground(Color.white);  
      }
      protected void paintComponent(Graphics g){
	 super.paintComponent(g); 
	 g.drawImage(bi, 0, 0, (int)(W * zoom), (int)(H * zoom), this);
      }
   }
   public static void main(String args[]){
      JFrame.setDefaultLookAndFeelDecorated(true);
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      LevyPanel h = new LevyPanel();
      frame.add(h, BorderLayout.CENTER);
      frame.pack();               
      frame.setVisible(true);
    }
}


