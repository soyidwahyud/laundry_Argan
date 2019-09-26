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
            $stmt->bind_param("ssis", $ID_Pelanggan, $Nama_Pelanggan, $No_Telp);
            if($stmt->execute())
                return true;
            return false;
        }
        function getPelanggan()
        {
            $stmt = $this->con->prepare("SELECT ID_Pelanggan, Nama_Pelanggan, No_Telp FROM pelanggan");
		    $stmt->execute();
		    $stmt->bind_result($ID_Pelanggan, $Nama_Pelanggan, $No_Telp);
		
            $pelanggan = array();
            while($stmt->fetch()){
                $pelanggan  = array();
                $pelanggan['Id_Pelanggan'] = $ID_Pelanggan; 
                $pelanggan['Nama_Pelanggan'] = $Nama_Pelanggan; 
                $pelanggan['No_Telp'] = $No_Telp; 
                
                array_push($pelanggan, $pelanggan); 
            }
            
            return $heroes;  
        }   
    }
?>