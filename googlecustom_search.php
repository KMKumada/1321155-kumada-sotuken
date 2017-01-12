<?php
/*
 if ($_POST) {
    // 初期値設定
    $search_query = $_POST['content'];

    //APIキー
    $api_key = "AIzaSyC3NTdlDSsPQjXq4HzIhOjbakg07ukitfo";

    //検索エンジンID
    $cx = "003341137288545180779:a0u51xvm5sw";

    //検索用URL
    $tmp_url = "https://www.googleapis.com/customsearch/v1?";


    // 検索パラメタ発行
    $params_list = array('q'=>$search_query,'key'=>$api_key,'cx'=>$cx,'alt'=>'json','start'=>'1');

    // リクエストパラメータ作成
    $req_param = http_build_query($params_list);

    // リクエスト本体作成
    $request = $tmp_url.$req_param;

    // jsonデータ取得
    $json = file_get_contents($request,true);
    $json_d = json_decode($json,true);

    // urlを取得
    for ($i=0; $i<10; $i++){
    $get_url = $json_d["items"][$i]["link"];
    //echo "$get_url\n";
    echo json_encode($get_url, JSON_FORCE_OBJECT);
    }
}*/
if ($_POST) {

//APIキー
$apiKey = "AIzaSyC3NTdlDSsPQjXq4HzIhOjbakg07ukitfo";

//検索エンジンID
$searchEngineId = "003341137288545180779:a0u51xvm5sw";

// 検索用URL
$baseUrl = "https://www.googleapis.com/customsearch/v1?";

//取得開始位置
$startNum = 1;

//$query = $_POST['q'];
//$query = $_GET['q'];
$query = $_POST['content'];

//------------------------------------
// リクエストパラメータ生成
//------------------------------------
$paramAry = array(
                'q' => $query,
                'key' => $apiKey,
                'cx' => $searchEngineId,
                'alt' => 'json',
                'start' => $startNum
        );
$param = http_build_query($paramAry);

//------------------------------------
// 実行＆結果取得
//------------------------------------
$reqUrl = $baseUrl . $param;
$retJson = file_get_contents($reqUrl, true);
//$ret = json_decode($retJson, true);
$ret = json_encode($retJson, JSON_FORCE_OBJECT);
//json文字列をデコードする連想配列形式
//------------------------------------
// 結果表示
//------------------------------------

//画面表示
//var_dump($ret);

//JSON形式でファイル出力
//file_put_contents(dirname(__FILE__) . "/data/ret_" . $startNum . "_" . date('Ymd_His') . ".txt", $retJson);

//項目を画面表示
/*
$num = $startNum;
foreach($ret['items'] as $value){
    echo "順位:" . $num . "<br>\n";
    echo "タイトル:" . $value['title'] . "<br>\n";
    echo "URL:" . $value['link'] . "<br>\n";
    echo "-------------------------------------------------------------------------<br>\n";

    $num++;
}*/
ob_start();

print_r($ret);

$buffer = ob_get_contents();
ob_end_clean();

$fp = fopen('google_output3.txt', 'w');
fputs($fp, $buffer);
fclose($fp);
  echo json_encode($retJson, JSON_FORCE_OBJECT);
}
?>
