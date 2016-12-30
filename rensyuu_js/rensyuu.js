function rensyuu(){
    var msg='HelloWorld';
    //文字列はクォートで囲んで表す
    window.alert(msg);
}
function rands(){
  var rnd = Math.random();
  if(rnd<=0.5){
    var smg='今日はラッキー';
  }else if(rnd<=0.9){
    var smg='まあまあかな';
  }else{
    var smg ="落とし穴に落ちる";
  }
window.alert(smg);
}
function renketu(){
  window.alert('ohayou'+'とおはようございます');

}
function jyouken(){
  var point=60;
  window.alert(point>=70 ? '合格':'不合格');
}
function fors(){

  var i=0;
  for(i=0;i<=3;i++){
    window.alert(i);
  }
}
