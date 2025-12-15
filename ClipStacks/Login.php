<?php
include("Connect.php");

$UserName = $_POST['UserName'];
$Password = $_POST['Password'];

$Query = $Connection->prepare("SELECT ID, UserName FROM users WHERE UserName=? AND Password=?");
$Query->bind_param("ss", $UserName, $Password);
$Query->execute();
$Result = $Query->get_result();

if ($Result->num_rows > 0) {
    $Row = $Result->fetch_assoc();
    echo json_encode([
        "Status" => "Success",
        "UserName" => $Row["UserName"]
    ]);
} else {
    echo json_encode(["Status" => "Failed"]);
}
?>
