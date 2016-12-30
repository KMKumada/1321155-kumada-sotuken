<?php
//PDOを使うことでどのデータベースを使っているか隠ぺいできる

  if ($_POST) {
      $replyData = $_POST['content'];
      global $db_intext;
      global $mecab_intext;
      $db_intext = $replyData;
      $mecab_intext= $replyData;

      $replyData = 'POST確認-->'.$replyData;

      echo json_encode($replyData, JSON_FORCE_OBJECT);
     require('mecab.php');
  }
   require('db_insert_situmon.php');
?>
