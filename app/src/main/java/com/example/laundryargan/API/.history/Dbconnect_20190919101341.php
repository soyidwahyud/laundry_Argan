<?php 

    class Dbconnect
    {
        private $con;
        function construnct()
        {

        }
        function connect()
        {
            include_once dirname(__FILE__). '/Constants.php';

            $this->con = new mysqli(DB_HOST, DB_USER,DB_PASS,DB_NAME);

            if(mysqli_connect_errno())
            {
                
            }
        }
    }
?>