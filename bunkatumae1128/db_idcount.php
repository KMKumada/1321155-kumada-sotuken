<?php
try{
$count=null;
$dbh = new PDO($dsn, DB_USER, DB_PASS, $option);
$dbh->setAttribute(PDO::MYSQL_ATTR_USE_BUFFERED_QUERY, true);
$sql = 'SELECT * FROM situmon';
$stmt = $dbh->query($sql);
$stmt->execute();
$count = $stmt->rowCount();
$sql = null;
$dbh = null;
$stmt = null;
}catch (PDOException $e) {
    echo $e->getMessage();
  //例外メッセージの文字列を取得します
  exit;
  //呼び出されたその場で終了
}
?>
