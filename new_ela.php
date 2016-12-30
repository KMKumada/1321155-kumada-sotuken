<?php
//  if ($_POST) {
/*      $replyData = $_POST['content'];

      $replyData = 'POST確認-->'.$replyData;
      */
      require 'vendor/autoload.php';
      use Elasticsearch\ClientBuilder;
      //クラスの初期化
      $client = ClientBuilder::create()->build();
      //new instance create
      $params = [
          'index' => 'testja',
          'body' => [
              'query' => [
                  'match' => [
                      'description' =>'渋め'
                  ]
              ]
          ]
      ];
      $response = $client->search($params);

      echo json_encode($response, JSON_FORCE_OBJECT);
      //連想配列なのでJavaScriptで返すときは要注意
?>
