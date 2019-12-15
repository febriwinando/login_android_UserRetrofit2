<?php 
	$servername = "localhost";
	$username = "root";
	$password = "";
	$db = "user_mrg";


	//membuat koneksi
	$koneksi = mysqli_connect($servername, $username, $password, $db);

	//memeriksa koneksi
	if (!$koneksi) {
		die("Connection failed".mysqli_connect_error());
	}
?>