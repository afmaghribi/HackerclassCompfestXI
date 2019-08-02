<?php
  include 'flag.php';
  if (isset($_POST['guess'])) {
    extract($_POST);
    if ($guess == $number) {
      die($flag);
    }
  }
?>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <div class="jumbotron">
  <a href="./index.txt" class="display-3" style="text-decoration:none;color:black">Guess The Number</a>
  
  <hr class="my-4">
  </div>

  <!-- Bootstrap -->
  <link href="css/bootstrap-grid.css" rel="stylesheet">
  <link href="css/bootstrap-grid.min.css " rel="stylesheet">
  <link href="css/bootstrap-reboot.css" rel="stylesheet">
  <link href="css/bootstrap-reboot.min.css" rel="stylesheet">
  <link href="css/bootstrap.css" rel="stylesheet">
  <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div>
    <form action="" method="POST">
      <h2> Guess: <h2> <input class="form-control form-control-lg" type="text" name="guess" >
      <br>
      <br>
      <input class="btn btn-primary btn-lg" type="submit" name="send">
    </form>
  </div>

</body>
</html>
