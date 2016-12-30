<?php
//PDOを使うことでどのデータベースを使っているか隠ぺいできる

  if($_POST){
      $replyData = $_POST['content'];
      global $mojiretu;$mojiretu=$replyData;

      $replyData = $replyData . "表示確認";

      echo json_encode($replyData, JSON_FORCE_OBJECT);
/////////////////////////
      $text =$mojiretu;
      $exe_path = '"C:/Program Files (x86)/MeCab/bin/mecab.exe"';
      $descriptorspec = array(
            0 => array("pipe", "r")
          , 1 => array("pipe", "w")
      );
      $process = proc_open($exe_path, $descriptorspec, $pipes);
      if (is_resource($process)) {
          fwrite($pipes[0], $text);
          fclose($pipes[0]);
          $result = stream_get_contents($pipes[1]);
          fclose($pipes[1]);
          proc_close($process);
      }
      /*echo "<pre>";
      print_r($result);
      echo "</pre>";*/
      ob_start();

      print_r($result);

      $buffer = ob_get_contents();
      ob_end_clean();

      $fp = fopen("mecab_output.txt","w");
      fputs($fp,$buffer);
      fclose($fp);

///////////////////////////////
  }
  //DBにMysql、データベース名・testを指定。
  //シングルクォーテーション内では変数展開されないそのまま変数名が出力
  $result＝NULL;//結果を初期化
  include_once("db_config.php");

    $option = array(
        PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
          // デフォルトのエラー発生時の処理方法を指定
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
          // SELECT 等でデータを取得する際の型を指定
        PDO::MYSQL_ATTR_USE_BUFFERED_QUERY => true,
          // SELECT した行数を取得する関数 rowCount() が使える
        PDO::ATTR_EMULATE_PREPARES => false,
          // MySQLネイティブのプリペアドステートメント機能の代わりにエミュしたものを使う設定
        PDO::ATTR_STRINGIFY_FETCHES => false
          // 取得時した内容を文字列型に変換するかのオプション,int型も文字列扱い
    );

    $dsn = 'mysql:dbname='.DB_NAME.';host=' . DB_HOST . ';charset=utf8';

    try{
      $dbh = new PDO($dsn, DB_USER, DB_PASS, $option);
      $dbh->setAttribute(PDO::MYSQL_ATTR_USE_BUFFERED_QUERY, true);
      $sql = 'SELECT * FROM situmon';
      $stmt = $dbh->query($sql);
      $stmt->execute();
      $count=$stmt->rowCount();
      $sql=null;
      $dbh=null;
      $stmt=null;
      //行数を求めるプログラムの作成


      $pdo = new PDO($dsn, DB_USER, DB_PASS, $option);
      //pdoインスタンス生成(query)
      $sql = $pdo -> prepare("INSERT INTO situmon (id, content) VALUES (:name, :pass)");
      //PDO::prepare — 文を実行する準備を行い、文オブジェクトを返す
      $sql -> bindParam(':name', $name, PDO::PARAM_INT);
      $sql -> bindParam(':pass', $pass, PDO::PARAM_STR);
      //変数を引数ならParam直接数字書くならValue
      $name =$count + 1;//数字
      $pass=$mojiretu;//グローバル変数を代入
      $sql -> execute();
      $pdo=null;
      $sql=null;
      //DBに登録する部分
      //アロー演算子（->）はオブジェクトの変数に値を入れたり、オブジェクトの関数を実行したりする演算子

    } catch(PDOException $e){
      echo $e->getMessage();
      //例外メッセージの文字列を取得します
      exit;
      //呼び出されたその場で終了
    }
  ?>
