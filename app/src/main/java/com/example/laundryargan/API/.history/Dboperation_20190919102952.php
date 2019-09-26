<?php 
    class Dboperation
    {
        private $con;

        function __construct()
        {
            require_once dirname(__FILE__). '/Dbconnect.php';
            $db = new Dbconnect();

            $this->con = $db->connect();
        }
        function createPelanggan()
        {
            $stmt = $this->con->prepare("SELECT ID_Pelanggan, Nama_Pelanggan, No_Telp FROM pelanggan) VALUES (?,?,?)");

        }
    }
?>