<?php   
    session_start();
    class Mydatabase{ //??????????????
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
  /*phương thức header */
  function _header($title){
      $s=' <!DOCTYPE html>
      <html lang="en">
      <head>
          <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <title>'.$title.'</title>
          <link rel="stylesheet" href="web/assets/css/bootstrap.min.css">
          <script>src="web/assets/js/bootstrap.bundle.min.js"</script>
      </head>
      <body>';
      echo $s;
  }
  /*phương thức footer */
  function _footer(){
       $s=' 
      <footer class="text-center text-lg-start text-muted mt-3" style="background-color: #f5f5f5;">
     <!-- Section: Links  -->
     <section class="">
    <div class="container text-center text-md-start pt-4 pb-4">
      <!-- Grid row -->
      <div class="row mt-3">
        <!-- Grid column -->
        <div class="col-12 col-lg-3 col-sm-12 mb-2">
          <!-- Content -->
          <a href="https://mdbootstrap.com/" target="_blank" class="">
            <img src="https://mdbootstrap.com/img/logo/mdb-transaprent-noshadows.png" height="35" />
          </a>
          <p class="mt-2 text-dark">
            © 2023 Copyright: MDBootstrap.com
          </p>
        </div>
        <!-- Grid column -->

        <!-- Grid column -->
        <div class="col-6 col-sm-4 col-lg-2">
          <!-- Links -->
          <h6 class="text-uppercase text-dark fw-bold mb-2">
            Store
          </h6>
          <ul class="list-unstyled mb-4">
            <li><a class="text-muted" href="#">About us</a></li>
            <li><a class="text-muted" href="#">Find store</a></li>
            <li><a class="text-muted" href="#">Categories</a></li>
            <li><a class="text-muted" href="#">Blogs</a></li>
          </ul>
        </div>
        <!-- Grid column -->

        <!-- Grid column -->
        <div class="col-6 col-sm-4 col-lg-2">
          <!-- Links -->
          <h6 class="text-uppercase text-dark fw-bold mb-2">
            Information
          </h6>
          <ul class="list-unstyled mb-4">
            <li><a class="text-muted" href="#">Help center</a></li>
            <li><a class="text-muted" href="#">Money refund</a></li>
            <li><a class="text-muted" href="#">Shipping info</a></li>
            <li><a class="text-muted" href="#">Refunds</a></li>
          </ul>
        </div>
        <!-- Grid column -->

        <!-- Grid column -->
        <div class="col-6 col-sm-4 col-lg-2">
          <!-- Links -->
          <h6 class="text-uppercase text-dark fw-bold mb-2">
            Support
          </h6>
          <ul class="list-unstyled mb-4">
            <li><a class="text-muted" href="#">Help center</a></li>
            <li><a class="text-muted" href="#">Documents</a></li>
            <li><a class="text-muted" href="#">Account restore</a></li>
            <li><a class="text-muted" href="#">My orders</a></li>
          </ul>
        </div>
        <!-- Grid column -->

        <!-- Grid column -->
        <div class="col-12 col-sm-12 col-lg-3">
          <!-- Links -->
          <h6 class="text-uppercase text-dark fw-bold mb-2">Newsletter</h6>
          <p class="text-muted">Stay in touch with latest updates about our products and offers</p>
          <div class="input-group mb-3">
            <input type="email" class="form-control border" placeholder="Email" aria-label="Email" aria-describedby="button-addon2" />
            <button class="btn btn-light border shadow-0" type="button" id="button-addon2" data-mdb-ripple-color="dark">
              Join
            </button>
          </div>
        </div>
        <!-- Grid column -->
      </div>
      <!-- Grid row -->
    </div>
            </section>
            <!-- Section: Links  -->
 
           <div class="">
           <div class="container">
           <div class="d-flex justify-content-between py-4 border-top">
           <!--- payment --->
           <div>
           <i class="fab fa-lg fa-cc-visa text-dark"></i>
           <i class="fab fa-lg fa-cc-amex text-dark"></i>
           <i class="fab fa-lg fa-cc-mastercard text-dark"></i>
           <i class="fab fa-lg fa-cc-paypal text-dark"></i>
           </div>
           <!--- payment --->

           <!--- language selector --->
           <div class="dropdown dropup">
           <a class="dropdown-toggle text-dark" href="#" id="Dropdown" role="button" data-mdb-toggle="dropdown" aria-expanded="false"> <i class="flag-united-kingdom flag m-0 me-1"></i>English </a>

                  <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="Dropdown">
                 <li>
              <a class="dropdown-item" href="#"><i class="flag-united-kingdom flag"></i>English <i class="fa fa-check text-success ms-2"></i></a>
            </li>
            <li><hr class="dropdown-divider" /></li>
            <li>
              <a class="dropdown-item" href="#"><i class="flag-poland flag"></i>Polski</a>
            </li>
            <li>
              <a class="dropdown-item" href="#"><i class="flag-china flag"></i>中文</a>
            </li>
            <li>
              <a class="dropdown-item" href="#"><i class="flag-japan flag"></i>日本語</a>
            </li>
            <li>
              <a class="dropdown-item" href="#"><i class="flag-germany flag"></i>Deutsch</a>
            </li>
            <li>
              <a class="dropdown-item" href="#"><i class="flag-france flag"></i>Français</a>
            </li>
            <li>
              <a class="dropdown-item" href="#"><i class="flag-spain flag"></i>Español</a>
            </li>
            <li>
              <a class="dropdown-item" href="#"><i class="flag-russia flag"></i>Русский</a>
            </li>
           <li>
              <a class="dropdown-item" href="#"><i class="flag-portugal flag"></i>Português</a>
            </li>
          </ul>
        </div>
        <!--- language selector --->
        </div>
       </div>
       </div>
       </footer>
      </body>
      </html>';
      echo $s;
  }   
   function navbar(){
    $s = '
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">
      <img src="web/assets/icon/logo.jpg" width="75" height="75">
      </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0" style="margin:0 auto">
        <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="index.php">Home</a>
        </li>

        <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
        Category
        </a>
        <ul class="dropdown-menu">';

        // $q = Database::query("select * from categories"); 
        // while ($r = $q->fetch_array()){
        //     $s .= '<li><a class="dropdown-item" href="index.php?id_category='.$r['id'].'">'.$r['name'].'</a></li>';
        // }

        $s .='</ul>
        </li>';
        if(!isset($_SESSION['user']))
            $s .='<li class="nav-item">
            <a class="nav-link" href="login.php">Login</a>
            </li>';
        else{
          $s.='
        <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
        Hi'.splitName($_SESSION['user']['name']).'
        </a>
        <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Profile</a></li>
            <li><a class="dropdown-item" href="logout.php">Logout</a></li>
        </ul>
        </li>';
        }

        $s .='<li class="nav-item">
        <a class="nav-link" href="#">
        <img src="web/assets/icon/cart.png" width="25" height="25">
        <i> 0 </i>
        </a>
        </li>
        </ul>
    <form class="d-flex" role="search">
    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
    </div>
    </div>
    </nav>
    ';
    echo $s;
  }
  function jumbotron(){
    $s ='
    <div class="bg-primary text-white py-5">
    <div class="container py-5">
      <h1>';
      if(!isset($_GET['id_category']))
       $s .=' Best category & products <br />
        in our store';

      else{
        $q= Database::query("select * from categoies where id=" .$_GET['id_category']);
        $s .=' Best '.$q->fetch_array()['name'].' <br />
        in our store';
      }
      $s.='</h1>
      <p>
        Trendy Products, Factory Prices, Excellent Service
      </p>
      <button type="button" class="btn btn-outline-light">
        Learn more
      </button>
      <button type="button" class="btn btn-light shadow-0 text-primary pt-2 border border-white">
        <span class="pt-1">Purchase now</span>
      </button>
    </div>
   </div>
    ';
    echo $s;
  }
  function body(){ 
    $s='';
    if(!isset($_GET['id_category']))
    $q = Database::query("select * from categories");
    else
    $q = Database::query("select * from categories where id=".$_GET['id_category']);
    while ($r = $q->fetch_array()){
    $s= '<section>
   <div class="container my-5">
    <header class="mb-4">
      <h3>'.$r['name'].'</h3>
    </header>

    <div class="row">';
    if(!isset($_GET['id_category']))
      $q1 = Database::query("select * from products where status = true and id_category=" .$r['id']); 
        else
      $q1 = Database::query("select * from products where id_category=" .$r['id']); 

            while ($r1 = $q1->fetch_array()){
               if($r['id'] == $r1['id_category'] && $r1['status']== true)

      $s .='<div class="col-lg-3 col-md-6 col-sm-6 d-flex">
        <div class="card w-100 my-2 shadow-2-strong">
          <img src="web/assets/images/'.$r1['image'].'" class="card-img-top" style="aspect-ratio: 1 / 1" />
          <div class="card-body d-flex flex-column">
            <h5 class="card-title">'.$r1['name'].'</h5>
            <p class="card-text">'.$r1['price'].'</p>
            <div class="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">
              <a href="#!" class="btn btn-primary shadow-0 me-1">Add to cart</a>
              <a href="#!" class="btn btn-light border px-2 pt-2 icon-hover"><i class="fas fa-heart fa-lg text-secondary px-1"></i></a>
            </div>
          </div>
        </div>
      </div>';
            }
    $s .='</div>
          </div>
          </section>
    ';
    }
    echo $s;
  }
  function login(){
    if (isset($_POST['emailphone']) && isset($_POST['password'])){
      if(is_numeric($_POST['emailphone']))
          $x='phone';
      else $x = 'email';
      $q= Database::query("select * from users where ".$x."='".$_POST['emailphone']."' and password='" .$_POST['password']."'");
      //   $q= Database::query("select * from users where email='".$_POST['emailphone']."' and password='" .$_POST['password']."'");
      // if ($q->fetch_array()==null)
      //       $q= Database::query("select * from users where phone='" .$_POST['emailphone']."' and password='" .$_POST['password']."'");
      if ($r = $q->fetch_array()){
        if($r['role'] == 'admin'){
          header("location: admin.php"); exit();
        }else{
          $_SESSION['user']=$r;
          header("location: index.php"); exit();
        }
      }else{
        $_SESSION['login_fail']='Dữ liệu nhập không chính xác';
        header("location: login.php"); exit();
      }
       }
      
        $s='
     <section class="vh-100">
     <div class="container-fluid h-custom">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-md-9 col-lg-6 col-xl-5">
          <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
            class="img-fluid" alt="Sample image">
        </div>
        <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
          <form action="" method="post">
            
          <h2 style="padding: 40px 0 25px 0">login Information</h2>';
            // if($_SESSION['login_fail']){
            //   $s.='<div style="color: red;">'.$_SESSION['login_fail'].'</div>';
            // }
  
            $s .='<!-- Email input -->
            <div class="form-outline mb-4">
              <input type="text" name="emailphone" class="form-control form-control-lg"
                placeholder="Enter a valid email or phone number" />
              
            </div>
  
            <!-- Password input -->
            <div class="form-outline mb-3">
              <input type="password" name="password" class="form-control form-control-lg"
                placeholder="Enter password" />
              
            </div>
  
            <div class="d-flex justify-content-between align-items-center">
              <!-- Checkbox -->
              <div class="form-check mb-0">
                <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3" />
                <label class="form-check-label" for="form2Example3">
                  Remember me
                </label>
              </div>
              <a href="#!" class="text-body">Forgot password?</a>
            </div>
  
            <div class="text-center text-lg-start mt-4 pt-2">
              <button type="submit" class="btn btn-primary btn-lg"
                style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
              <p class="small fw-bold mt-2 pt-1 mb-0">Don\'t have an account? <a href="#!"
                  class="link-danger">Register</a></p>
            </div>
  
          </form>
        </div>
      </div>
      </div>
    
     </section>
    ';
    echo $s;
  }
  function splitName($str) { // từ cuối cùng của chuỗi họ tên
    $rs = NULL; // cái này cũng giúp kiểm tra chuỗi có ít nhất 2 từ hay không
    //nếu chỉ có một từ, nó sẽ trả về kết quả NULL
    $word = mb_split(' ', $str); // tách từ
    $n = count($word)-1; // lấy vị trí mảng của từ cuối cùng
    if ($n > 0) {$rs = $word[$n];} // lấy từ cuối cùng

    return $rs;
}
  ?>

