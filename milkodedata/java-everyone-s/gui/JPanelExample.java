//  ���X�g 11.6 JPanel�̗� 
import java.awt.*;
import javax.swing.*;  

class JPanelExample extends JPanel{
  JPanelExample(){
     JPanel pa = new JPanel();
     pa.setLayout(new BoxLayout(pa, BoxLayout.Y_AXIS));
     pa.add(new JButton("�{�b�N�X��"));
     pa.add(new JButton("�{�b�N�X��"));
     pa.add(new JButton("�{�b�N�X��"));
     JPanel pb = new JPanel();
     pb.setLayout(new GridLayout(2,0));
     pb.add(new JButton("�i�q���� "));
     pb.add(new JButton("�i�q�E�� "));
     pb.add(new JButton("�i�q���� "));
     pb.add(new JButton("�i�q�E�� "));
     add(pa);
     add(pb);
  }
  public static void main(String[] args){
     JFrame f  = new JFrame("JPanel Example");
     JPanelExample example = new JPanelExample();
     f.getContentPane().add(example, BorderLayout.CENTER);
     f.pack();
     f.setVisible(true);
  }
}
