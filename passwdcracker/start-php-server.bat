@echo off
echo ========================================
echo Demarrage du serveur PHP avec logs
echo ========================================
echo.

REM Verification de PHP
php --version >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo ERREUR: PHP n'est pas installe ou pas dans le PATH
    echo.
    echo Solutions:
    echo 1. Installer XAMPP/WAMP qui inclut PHP
    echo 2. Installer PHP standalone depuis https://php.net
    echo.
    pause
    exit /b 1
)

echo ✓ PHP detecte
echo.

REM Creation du dossier web s'il n'existe pas
if not exist "web" mkdir web
if not exist "web\app" mkdir web\app

REM Copie du fichier PHP avec logs
echo ^<?php > web\app\login.php
echo // Mot de passe et login >> web\app\login.php
echo define("USERNAME", "admin"); >> web\app\login.php
echo define("PASSWORD", "passer"); >> web\app\login.php
echo. >> web\app\login.php
echo // Log des tentatives d'authentification >> web\app\login.php
echo function log_attempt($username, $password, $success) { >> web\app\login.php
echo     $log = date('Y-m-d H:i:s') . " - Tentative: $username / $password - " . ($success ? "SUCCES" : "ECHEC") . PHP_EOL; >> web\app\login.php
echo     file_put_contents('auth_log.txt', $log, FILE_APPEND); >> web\app\login.php
echo     echo $log; >> web\app\login.php
echo } >> web\app\login.php
echo. >> web\app\login.php
echo // Valider les donnees utilisateurs >> web\app\login.php
echo function is_inputs_valid() { >> web\app\login.php
echo     if (isset($_POST['username']) ^&^& isset($_POST['password'])) { >> web\app\login.php
echo         if (!empty($_POST['username']) ^&^& !empty($_POST['password'])) { >> web\app\login.php
echo             return true; >> web\app\login.php
echo         } >> web\app\login.php
echo     } >> web\app\login.php
echo     return false; >> web\app\login.php
echo } >> web\app\login.php
echo. >> web\app\login.php
echo if ($_SERVER["REQUEST_METHOD"] == "POST") { >> web\app\login.php
echo     if (!is_inputs_valid()) { >> web\app\login.php
echo         http_response_code(404); >> web\app\login.php
echo         echo "Bad request"; >> web\app\login.php
echo         exit(); >> web\app\login.php
echo     } >> web\app\login.php
echo. >> web\app\login.php
echo     $username = $_POST['username']; >> web\app\login.php
echo     $password = $_POST['password']; >> web\app\login.php
echo. >> web\app\login.php
echo     $success = ($username == USERNAME ^&^& $password == PASSWORD); >> web\app\login.php
echo     log_attempt($username, $password, $success); >> web\app\login.php
echo. >> web\app\login.php
echo     if ($success) { >> web\app\login.php
echo         http_response_code(200); >> web\app\login.php
echo         echo "Login successful!"; >> web\app\login.php
echo         exit(); >> web\app\login.php
echo     } else { >> web\app\login.php
echo         http_response_code(401); >> web\app\login.php
echo         echo "Invalid username or password."; >> web\app\login.php
echo         exit(); >> web\app\login.php
echo     } >> web\app\login.php
echo } >> web\app\login.php
echo ?^> >> web\app\login.php

echo ✓ Fichier PHP avec logs cree
echo.

REM Demarrage du serveur PHP
echo Demarrage du serveur PHP sur http://localhost:8000
echo Le fichier login.php sera accessible sur http://localhost:8000/app/login.php
echo Les logs d'authentification seront affiches ici et dans auth_log.txt
echo.
echo Pour arreter le serveur, appuie sur Ctrl+C
echo.

cd web
php -S localhost:8000

echo.
echo Serveur arrete.
pause 