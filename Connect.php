<?php
$Host = "localhost";
$User = "root";
$Password = "";
$Database = "clipstacks_db";

$Connection = new mysqli($Host, $User, $Password, $Database);

if ($Connection->connect_error) {
    die("ConnectionFailed");
}
?>
