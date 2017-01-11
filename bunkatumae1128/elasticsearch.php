<?php

$text = $mecab_intext;
$exe_path = 'C:\elasticsearch-5.0.2\bin\elasticsearch'
//elasticsearchの起動
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
    require('elasticsearch_insert.php');
}





>
