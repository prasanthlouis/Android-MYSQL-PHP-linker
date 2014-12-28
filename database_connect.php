<?php
class DB_CONNECT {
    function __construct() { //this is the constructor function
        $this->connect();
    }
    function __destruct() {  //this is the destructor function
        $this->close();
    }
 
    function connect() {
         require_once __DIR__ . '/database_configuration.php';  //its checking to include the db_config file, and if already included, not to include it again
		$con = mysql_connect(DB_SERVER, DB_USER, DB_PASSWORD) or die(mysql_error()); //parameters are server, username, password
		$db = mysql_select_db(DB) or die(mysql_error()) or die(mysql_error());  //selection of the database
		return $con; //this is a cursor returned once connected
    }
    function close() {
        mysql_close();
    }
}
?>
