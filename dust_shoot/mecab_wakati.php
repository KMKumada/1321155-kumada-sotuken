<?php
$text =$mecab_intext;
//$exe_path = 'C:/"Program Files (x86)"/MeCab/bin/mecab.exe -o mecab_output.txt -O wakati';
//方法で分かち書き出力
$exe_path = 'C:/"Program Files (x86)"/MeCab/bin/mecab.exe -o mecab_output.txt';
//この方法で通常出力
$descriptorspec = array(
        0 => array("pipe", "r"), 1 => array("pipe", "w")
);
$process = proc_open($exe_path, $descriptorspec, $pipes);
if (is_resource($process)) {
    fwrite($pipes[0], $text);
    fclose($pipes[0]);
    $result = stream_get_contents($pipes[1]);
    fclose($pipes[1]);
    proc_close($process);
}
$result = rtrim($result);
$values = explode(' ', $result);
var_dump($values);
?>
