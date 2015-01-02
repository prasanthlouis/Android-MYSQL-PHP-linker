<?php

$response=array();
if((isset($_POST['name'])) && (isset($_POST['price'])) && (isset($_POST['des'])))
{
$name=$_POST['name'];
$price=$_POST['price'];
$des=$_POST['des']; 
require_once __DIR__ . '/connection.php';
$db=new DB_CONNECT();
$result=my_sqlquery("INSERT INTO products(name,price,description) VALUES ('$name','$price','$des')");
if($result)
{
  //NOTE: DO NOT REMOVE THE STATUS VARIABLES. By using the JSONResponse, we're checking if a row has been entered or not in
  //the android app.
response["success"]=1;
response["message"]="It has been entered";
}
else
{
response["success"]=0;
response["message"]="It hasn't been entered";
}
}
else
{
response["success"]=0;
response["message"]="You haven't entered all the data";
}
echo json_encode($reponse);
?>
