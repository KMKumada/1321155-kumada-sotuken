//練習問題11.3 
//ボタン部分を別パネルに配置し、中央に入れる(レイアウトの入れ子)

import java.awt.*;             
import javax.swing.*;  

public class HelloNewLayout extends JPanel{ 
   JLabel label; //ラベル用の変数
   JPanel flowPanel;  //パネル用の変数
   JButton b1, b2;//ボタン用の変数

   public HelloNewLayout(){  
      label = new JLabel("こんにちは");  
      flowPanel = new JPanel(); 
      b1 = new JButton("ボタン1");  
      b2 = new JButton("ボタン2");  
      flowPanel.add(b1); //別パネル上にボタンを置く
      flowPanel.add(b2); 
      setLayout(new BorderLayout());   //配置方式の設定
      add(label, BorderLayout.NORTH);  //ラベルを置く
      add(flowPanel, BorderLayout.CENTER); //ボタンを載せたパネルを置く
   }

   public static void main(String[] args){
      JFrame frame = new JFrame();//JFrameオブジェクトを生成
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      HelloNewLayout h = new HelloNewLayout();  //オブジェクトを生成
      frame.add(h, BorderLayout.CENTER);//フレームにオブジェクトを置く
      frame.pack();               //フレームを必要最小の大きさにする
      frame.setVisible(true);     //フレームを画面に見せる
   }
}

