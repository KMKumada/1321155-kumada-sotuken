<?php

$text = "T22.java では、2 匹の亀（Turtle）で線画を描いています。これと
同じ線画を、１匹の亀（Turtle）で描きなさい。黒い線と赤い線も
T22.java と同じにしなさい。";
$exe_path = 'C:/"Program Files (x86)"/MeCab/bin/mecab.exe -O wakati';//-o wakati
//遅いけどアラートもきちんとでます。
//$exe_path = '"C:/Program Files (x86)/MeCab/bin/mecab.exe"';
//これがもとのやつ
$descriptorspec = array(
      0 => array('pipe', 'r'), 1 => array('pipe', 'w'),
);
$process = proc_open($exe_path, $descriptorspec, $pipes);
if (is_resource($process)) {
    fwrite($pipes[0], $text);
    fclose($pipes[0]);
    $result = stream_get_contents($pipes[1]);
    fclose($pipes[1]);
    proc_close($process);
    require('mecab_insert.php');
    echo $result;
}
ob_start();

print_r($result);

$buffer = ob_get_contents();
ob_end_clean();

$fp = fopen('mecab_output.txt', 'w');
fputs($fp, $buffer);
fclose($fp);

?>
