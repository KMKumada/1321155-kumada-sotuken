<?php

$path = '"C:/Program Files (x86)/MeCab/bin/mecab.exe"';
//パスシングルとダブル同時で動きました。

$input = "PHPでMeCabを使いたい";//形態素解析をしたい文字列

//パイプ処理
$descriptorspec = array(
0 => array("pipe","r"),
1 => array("pipe","w")
);
$process = proc_open($path, $descriptorspec, $pipes);
if(is_resource($process)) {
fwrite($pipes[0], $input);
fclose($pipes[0]);
while(!feof($pipes[1])){
$output[] = fgets($pipes[1]);
}
fclose($pipes[1]);
proc_close($process);
}

echo "<pre>";
print_r($output);//形態素解析の結果の出力
echo "</pre>";

?>
