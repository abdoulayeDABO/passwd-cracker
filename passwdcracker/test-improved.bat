@echo off
echo ========================================
echo Test de la version amelioree du projet
echo ========================================
echo.

REM Verification de la compilation
echo [1/4] Compilation du projet...
call compile-improved.bat
if %ERRORLEVEL% NEQ 0 (
    echo ERREUR: La compilation a echoue!
    pause
    exit /b 1
)
echo ✓ Compilation reussie
echo.

REM Verification de la presence des fichiers compiles
echo [2/4] Verification des fichiers compiles...
if not exist "out\CrackerApp.class" (
    echo ERREUR: CrackerApp.class manquant!
    pause
    exit /b 1
)
if not exist "out\CibleAuthentification.class" (
    echo ERREUR: CibleAuthentification.class manquant!
    pause
    exit /b 1
)
if not exist "out\FabriqueCible.class" (
    echo ERREUR: FabriqueCible.class manquant!
    pause
    exit /b 1
)
if not exist "out\FabriqueAttaque.class" (
    echo ERREUR: FabriqueAttaque.class manquant!
    pause
    exit /b 1
)
echo ✓ Tous les fichiers principaux sont presents
echo.

REM Test de validation des arguments
echo [3/4] Test de validation des arguments...
java -cp out CrackerApp
if %ERRORLEVEL% EQU 0 (
    echo ERREUR: Le programme devrait afficher un message d'erreur sans arguments!
    pause
    exit /b 1
)
echo ✓ Validation des arguments fonctionne
echo.

REM Test avec arguments invalides
echo [4/4] Test avec arguments invalides...
java -cp out CrackerApp invalid local admin
if %ERRORLEVEL% EQU 0 (
    echo ERREUR: Le programme devrait rejeter les arguments invalides!
    pause
    exit /b 1
)
echo ✓ Rejet des arguments invalides fonctionne
echo.

echo ========================================
echo ✓ TOUS LES TESTS SONT PASSES!
echo ========================================
echo.
echo Le projet est pret pour utilisation.
echo.
echo Exemples de commandes:
echo   java -cp out CrackerApp bruteForce local admin
echo   java -cp out CrackerApp dictionnary remote user
echo.
pause 