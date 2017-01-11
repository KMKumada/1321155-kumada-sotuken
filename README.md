# 1321155-sotuken
#卒業研究のプログラムです。
#プログラムの概要を記述します。


#main.html               クライアント側の画面です。検索フォームとデバッグ用にDBの中身が反映
#-new_ela.php            ElasticSearchの処理

#-main_form.php          サーバー側のメインファイル　ElasticSearchもここから呼び出せるようにするつもりです。
#-mecab.php             形態素解析MECABの処理
#-mecab_insert.php     形態素解析の結果をDBに格納
#-db_insert_situmon.php 入力された質問文を格納用DB

#db_select_mondai.php    DBの問題文をクライアント側に表示(問題文は手動でDB登録)
#db_select_situmon.php　 DBの質問文をクライアント側に表示(テスト用)

#db_config.php           DBに接続するためのconfig
#各種.txt                確認用
