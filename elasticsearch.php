<?php
require 'vendor/autoload.php';
use Elasticsearch\ClientBuilder;
//名前空間の宣言は必ず変数よりも先に記述
 if ($_POST) {
//Ajaxで入力フォームの値を取得
$replyData = $_POST['content'];
$pen=$replyData;//代理の変数を用意しています
$result="'".$pen."'";//シングルクォーテーションで囲む処理
//必ずelasticsearchの起動を確認してください

      $client = ClientBuilder::create()->build();
      $params = [
          'index' => 'testja',
          'body' => [
              'query' => [
                  'match' => [
                      'description' =>$result
                  ]
              ]
          ]
      ];
      $response = $client->search($params);
      //echo $response;
      //$pam= json_encode($response, JSON_FORCE_OBJECT);
      /*ob_start();

      print_r($pam);

      $buffer = ob_get_contents();
      ob_end_clean();

      $fp = fopen('elasticsearch.txt', 'w');
      fputs($fp, $buffer);
      fclose($fp);
      */
      echo json_encode($response, JSON_FORCE_OBJECT);
      //連想配列なのでJavaScriptで返すときは要注意
    }
?>
