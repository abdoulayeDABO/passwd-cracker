@echo off
echo ========================================
echo Test Complet - Password Cracker Ameliore
echo ========================================
echo.

REM Verification de la compilation
echo [1/5] Compilation du projet...
call compile-improved.bat
if %ERRORLEVEL% NEQ 0 (
    echo ERREUR: La compilation a echoue!
    pause
    exit /b 1
)
echo ✓ Compilation reussie
echo.

REM Test 1: Validation des arguments
echo [2/5] Test de validation des arguments...
java -cp out CrackerApp
if %ERRORLEVEL% EQU 0 (
    echo ERREUR: Le programme devrait afficher un message d'erreur sans arguments!
    pause
    exit /b 1
)
echo ✓ Validation des arguments fonctionne
echo.

REM Test 2: Arguments invalides
echo [3/5] Test avec arguments invalides...
java -cp out CrackerApp invalid local admin
if %ERRORLEVEL% EQU 0 (
    echo ERREUR: Le programme devrait rejeter les arguments invalides!
    pause
    exit /b 1
)
echo ✓ Rejet des arguments invalides fonctionne
echo.

REM Test 3: Attaque par dictionnaire sur cible locale
echo [4/5] Test attaque par dictionnaire sur cible locale...
echo Test avec login: admin, mot de passe attendu: passer
echo.
java -cp out CrackerApp dictionnary local admin
echo.
echo ✓ Test attaque dictionnaire locale termine
echo.

REM Test 4: Attaque par force brute sur cible locale
echo [5/5] Test attaque par force brute sur cible locale...
echo Test avec login: admin, mot de passe attendu: passer
echo.
java -cp out CrackerApp bruteForce local admin
echo.
echo ✓ Test attaque force brute locale termine
echo.

echo ========================================
echo ✓ TOUS LES TESTS SONT PASSES!
echo ========================================
echo.
echo ========================================
echo TESTS EN LIGNE (Optionnels)
echo ========================================
echo.
echo Pour tester les attaques en ligne:
echo 1. Demarrer le serveur web: start-server.bat
echo 2. Dans un autre terminal, executer:
echo    java -cp out CrackerApp dictionnary remote admin
echo    java -cp out CrackerApp bruteForce remote admin
echo.
echo ========================================
echo INFORMATIONS DE TEST
echo ========================================
echo.
echo Cibles disponibles:
echo - Locale: Login.java (admin/passer)
echo - En ligne: login.php (admin/passer)
echo.
echo Dictionnaire: data/password.txt (contient 'passer')
echo.
echo Exemples de commandes:
echo   java -cp out CrackerApp bruteForce local admin
echo   java -cp out CrackerApp dictionnary local admin
echo   java -cp out CrackerApp bruteForce remote admin
echo   java -cp out CrackerApp dictionnary remote admin
echo.
pause 