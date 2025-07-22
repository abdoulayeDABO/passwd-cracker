<?php 
// Mot de passe et login 
define("USERNAME", "admin"); 
define("PASSWORD", "passer"); 
 
// Log des tentatives d'authentification 
function log_attempt($username, $password, $success) { 
    $log = date('Y-m-d H:i:s') . " - Tentative: $username / $password - " . ($success ? "SUCCES" : "ECHEC") . PHP_EOL; 
    file_put_contents('auth_log.txt', $log, FILE_APPEND); 
    echo $log; 
} 
 
// Valider les donnees utilisateurs 
function is_inputs_valid() { 
    if (isset($_POST['username']) && isset($_POST['password'])) { 
        if (!empty($_POST['username']) && !empty($_POST['password'])) { 
            return true; 
        } 
    } 
    return false; 
} 
 
if ($_SERVER["REQUEST_METHOD"] == "POST") { 
    if (!is_inputs_valid()) { 
        http_response_code(404); 
        echo "Bad request"; 
        exit(); 
    } 
 
    $username = $_POST['username']; 
    $password = $_POST['password']; 
 
    $success = ($username == USERNAME && $password == PASSWORD); 
    log_attempt($username, $password, $success); 
 
    if ($success) { 
        http_response_code(200); 
        echo "Login successful!"; 
        exit(); 
    } else { 
        http_response_code(401); 
        echo "Invalid username or password."; 
        exit(); 
    } 
} 
?> 
