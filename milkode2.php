<?php
if($_POST){

  $descriptorspec = array(
     0 => array("pipe", "r"),  // stdin は、子プロセスが読み込むパイプです。
     1 => array("pipe", "w"),  // stdout は、子プロセスが書き込むパイプです。
     2 => array("file", "/tmp/error-output.txt", "a") // はファイルで、そこに書き込みます。
  );

  $cwd = 'C:/';
  $env = array('some_option' => 'aeiou');

  $process = proc_open('php', $descriptorspec, $pipes, $cwd, $env);

  if (is_resource($process)) {
      // $pipes はこの時点で次のような形を取っています。
      // 0 => 子プロセスの stdin に繋がれた書き込み可能なハンドル
      // 1 => 子プロセスの stdout に繋がれた読み込み可能なハンドル
      // すべてのエラー出力は /tmp/error-output.txt に書き込みされます。

      fwrite($pipes[0], '<?php print_r($_ENV); ?>');
      fclose($pipes[0]);

      echo stream_get_contents($pipes[1]);
      fclose($pipes[1]);

      // デッドロックを避けるため、proc_close を呼ぶ前に
      // すべてのパイプを閉じることが重要です。
      $return_value = proc_close($process);

    echo json_encode($return_value, JSON_FORCE_OBJECT);
  }
}
?>
