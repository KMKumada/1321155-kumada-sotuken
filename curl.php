<?php
if($_POST){
  $count=$_POST['content'];
  if($count==1){
    $u="http://localhost:9200/_cat/indices?v";
  }else if($count==2){
    $u="http://localhost:9200/sampledata/_mapping?pretty";
  }else if($count==3){
    $u="http://localhost:9200/sampledata/_search?pretty";
  }else{
  }
  $ch = curl_init(); // init
  curl_setopt($ch, CURLOPT_URL, $u); // URLをセット
  curl_setopt($ch, CURLOPT_RETURNTRANSFER, true); // curl_exec()の結果を文字列で返す
  curl_setopt($ch, CURLOPT_HEADER, true); // ヘッダも出力したい場合
  $c = curl_exec($ch); // 実行
  curl_close($ch); // おまじない
  echo json_encode($c, JSON_FORCE_OBJECT);

}

?>
