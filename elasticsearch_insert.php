<?php

$exe_path = 'C:\elasticsearch-5.0.2\bin\elasticsearch.bat';

$descriptorspec = array(
      0 => array('pipe', 'r'), 1 => array('pipe', 'w'),
);
$process = proc_open($exe_path, $descriptorspec, $pipes);
//コマンドを実行し、入出力用にファイルポインタを開く
//$cmd　実行されるコマンド
//$descriptorsec　どのように小プロセスに渡すかオプション
//$pipes　PHP側で生成されたパイプの終端にあたるファイルポインタの配列
if (is_resource($process)) {
  //変数がリソースかどうかを調べるTORF
    //fwrite($pipes[0]);
    //fclose($pipes[0]);
    $result = stream_get_contents($pipes[1]);
    fclose($pipes[1]);
    proc_close($process);
    //プロセスの開放
}
ob_start();

print_r($result);

$buffer = ob_get_contents();
ob_end_clean();

$fp = fopen('elastic_output.txt', 'w');
fputs($fp, $buffer);
fclose($fp);
?>
