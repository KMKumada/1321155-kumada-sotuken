// ���X�g11.5  JComboBox�̗�
import java.awt.*;             
import javax.swing.*;  

public class JComboBoxExample extends JPanel{
   JComboBox select;
   public JComboBoxExample() {
      setBackground(Color.white);
      String[] list = {"����", "�x��", "�|���", "�����オ��"};
      select = new JComboBox(list); //���ڂ��w�肵��JComboBox����
      add(select);                  //JComboBox���p�l���ɒu��
   }
   public static void main(String[] args){
      JFrame frame = new JFrame("JComboBox");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JComboBoxExample h = new JComboBoxExample();
      frame.add(h, BorderLayout.CENTER);
      frame.pack();               
      frame.setVisible(true);     
   }
}
