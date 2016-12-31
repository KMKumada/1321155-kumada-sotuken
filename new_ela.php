<?php
//入力フォームからは受け取れています。確認用にコメントアウトしてます
 /*if ($_POST) {
      $replyData = $_POST['content'];
*/

//必ずelasticsearchの起動を確認してください
//elasticsearch起動する記述がありませんでした12/31
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
                      //変数でにする予定です12/31
                  ]
              ]
          ]
      ];
      $response = $client->search($params);

      echo json_encode($response, JSON_FORCE_OBJECT);
      //連想配列なのでJavaScriptで返すときは要注意
?>
