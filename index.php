<?php
    class Database{
        static $con;
        public static function getConnection(){
            if(self::$con == null)
                return new mysqli("localhost","root","","shopping");
                return null;
        }
        public static function query($s){
            return self::getConnection()->query($s);
        }
    }
?>


<body>
    <?php
    include('inc/database.php');
    _header('Home Page');
    navbar();
    jumbotron();
    body();
    
    _footer();
    ?>