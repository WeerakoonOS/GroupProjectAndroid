<?php
$con = mysqli_connect("localhost", "id2654721_admin", "admin", "id2654721_user")
	$name = $_POST["name"];
	$email = $_POST["email"];
	$password = $_POST["password"];
	
	$statement = mysqli_prepare($con, "INSERT INTO user (name, email, password) VALUES (?,?,?)");
	$mysqli_stmt_bind_param($statement, "siss", $name, $email, $password);
	
	$response = array();
	$response["success"] = true;
	echo json_encode($response);
	
?>
