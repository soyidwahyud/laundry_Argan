<?php 
    class Dboperation
    {
        private $con;

        function __construct()
        {
            require_once dirname(__FILE__). '/Dbconnect.php';
            $db = new Dbconnect();

            $this->con = $db;
        }
    }
?>