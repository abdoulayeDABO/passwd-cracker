<?php
// Mot de passe et login
define("USERNAME", "admin");
define("PASSWORD", "passer");

// Valider les donnees utilisateurs
function is_inputs_valid()
{
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


    if ($username == USERNAME && $password == PASSWORD) {
        http_response_code(200);
        echo "Login successful!";
        exit();
    } else {
        http_response_code(401);
        echo "Invalid username or password.";
        exit();
    }
}
