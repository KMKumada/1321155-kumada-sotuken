<?php
if($_POST){

  $text = $_POST['content'];
  $exe_path = 'gmilk'.' '.$text;
  //indexはmilk listで登録されたところから検索
  //milk　web で登録されたパッケージを参照可能
  $descriptorspec = array(
        0 => array('pipe', 'r'),
        1 => array('pipe', 'w'),
  );
  $process = proc_open($exe_path, $descriptorspec, $pipes);
  //コマンドを実行し、入出力用にファイルポインタを開く
  //引数は左から　$cmd $descriptorspec $pipes
  //実行されるコマンド　数値添え字配列０が標準入力　１が標準出力
  //ＰＨＰ側で生成されたパイプの終端にあたるファイルポインタ
  if (is_resource($process)) {

      fwrite($pipes[0], $text);
      fclose($pipes[0]);
      $result = stream_get_contents($pipes[1]);
      fclose($pipes[1]);
      proc_close($process);
  }
  echo json_encode($result, JSON_FORCE_OBJECT);

}

?>
