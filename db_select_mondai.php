<?php

include_once 'db_config.php';

  $option = array(
      PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
        // デフォルトのエラー発生時の処理方法を指定
      PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        // SELECT 等でデータを取得する際の型を指定
      PDO::MYSQL_ATTR_USE_BUFFERED_QUERY => true,
        // SELECT した行数を取得する関数 rowCount() が使える
      PDO::ATTR_EMULATE_PREPARES => false,
        // MySQLネイティブのプリペアドステートメント機能の代わりにエミュしたものを使う設定
      PDO::ATTR_STRINGIFY_FETCHES => false,
        // 取得時した内容を文字列型に変換するかのオプション,int型も文字列扱い
  );
  $dsn = 'mysql:dbname='.DB_NAME.';host='.DB_HOST.';charset=utf8';
  try {
      $pdo = new PDO($dsn, DB_USER, DB_PASS, $option);
    //pdoインスタンス生成(query)
    $sql = $pdo->prepare('SELECT * FROM mondai');
    $sql->execute();

    while($row = $sql->fetch()) {
    	$id = $row['id'];
    	$name = $row['question'];
      echo "<tr>";
      echo "<td>"."$id"."</td>";
      echo "<td>"."$name"."</td>";
      echo "</tr>";
    }
  } catch (PDOException $e) {
      echo $e->getMessage();
      exit;
  }
  $pdo=null;

  ?>
