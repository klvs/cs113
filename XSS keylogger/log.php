<?php
// keylogger.php
 $dir = 'yee';

 // create new directory with 744 permissions if it does not exist yet
 // owner will be the user/group the PHP script is run under
 // if ( !file_exists($dir) ) {
 //  mkdir ($dir, 0744);
 // }

 // file_put_contents ($dir.'/data.txt', 'Hello File');
// echo $_GET['c'];
  
if(!empty($_GET['c'])) {
	// echo $_GET['c'];
    // $logfile = fopen('data.txt', 'a+');
    // fwrite($logfile, $_GET['c']);
    // fclose($logfile);
}

?>