<?php  
	include 'connect.php';


	if ($_SERVER['REQUEST_METHOD'] == 'POST') {
		$username = $_POST["username"];
		$password = $_POST["password"];

		$sql = "SELECT * FROM admin_account WHERE username = '$username' AND password = '$password'";
			$result = mysqli_query($koneksi, $sql);
			$row = mysqli_fetch_assoc($result);
			if ($username == $row['username'] && $password == $row['password']) {
			
				$namaAdmin = $row['username'];
				$idAdmin = $row['id'];
			
				echo json_encode(array('kode'=> 1, 'pesan'=>'Berhasil Login'));
			}else{
				echo json_encode(array('kode'=> 101, 'pesan'=>'Login Gagal'));
			}
	}else{
		echo json_encode(array('kode'=> 101, 'info'=>'Login Gagal'));
	}
	header('Content-Type: application/json');
?>