<?php

$result＝NULL; //結果を初期化
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
    /*
      $dbh = new PDO($dsn, DB_USER, DB_PASS, $option);
      $dbh->setAttribute(PDO::MYSQL_ATTR_USE_BUFFERED_QUERY, true);
      $sql = 'SELECT * FROM situmon';
      $stmt = $dbh->query($sql);
      $stmt->execute();
      $count = $stmt->rowCount();
      $sql = null;
      $dbh = null;
      $stmt = null;
      */
    //行数を求めるプログラムの作成
    require('db_idcount.php');
    $pdo = new PDO($dsn, DB_USER, DB_PASS, $option);
    //pdoインスタンス生成(query)
    $sql = $pdo->prepare('INSERT INTO situmon (id, content) VALUES (:name, :pass)');
    //PDO::prepare — 文を実行する準備を行い、文オブジェクトを返す
    $sql->bindParam(':name', $name, PDO::PARAM_INT);
      $sql->bindParam(':pass', $pass, PDO::PARAM_STR);
    //変数を引数ならParam直接数字書くならValue
    $name = $count + 1; //数字
    $pass = $mojiretu; //グローバル変数を代入
    $sql->execute();
      $pdo = null;
      $sql = null;
    //DBに登録する部分
    //アロー演算子（->）はオブジェクトの変数に値を入れたり、オブジェクトの関数を実行したりする演算子
  } catch (PDOException $e) {
      echo $e->getMessage();
    //例外メッセージの文字列を取得します
    exit;
    //呼び出されたその場で終了
  }
