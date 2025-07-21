@echo off
echo ========================================
echo Demarrage du serveur web de test
echo ========================================
echo.

REM Verification de Python
python --version >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo ERREUR: Python n'est pas installe ou pas dans le PATH
    echo.
    echo Solutions:
    echo 1. Installer Python depuis https://python.org
    echo 2. Ou utiliser XAMPP/WAMP pour Apache
    echo.
    pause
    exit /b 1
)

echo ✓ Python detecte
echo.

REM Creation du dossier web s'il n'existe pas
if not exist "web" mkdir web
if not exist "web\app" mkdir web\app

REM Copie du fichier PHP dans le dossier web
copy "cibles\login.php" "web\app\login.php" >nul

echo ✓ Fichiers web copies
echo.

REM Demarrage du serveur
echo Demarrage du serveur web sur http://localhost:8000
echo Le fichier login.php sera accessible sur http://localhost:8000/app/login.php
echo.
echo Pour arreter le serveur, appuie sur Ctrl+C
echo.

cd web
python -m http.server 8000

echo.
echo Serveur arrete.
pause 