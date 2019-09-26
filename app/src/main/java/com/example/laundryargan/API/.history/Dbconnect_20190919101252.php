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

            $this->con = new mysqli(DB_HOST, DB_USER,)
        }
    }
?>