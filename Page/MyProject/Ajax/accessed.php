<?php
    $user=$_POST['user'];
    $password=$_POST['password'];

    if($user == 'lrl' && $password == '123456'){
        echo '{"result":true}';
    }else{
       echo '{"result":false}';
    }

?>