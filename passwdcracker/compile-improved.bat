@echo off
echo Compilation de la version amelioree du Password Cracker...
echo.

REM Creation du dossier de sortie s'il n'existe pas
if not exist "out" mkdir out

REM Compilation des classes principales
echo Compilation des classes principales...
javac -d out -cp "src" src/*.java src/utils/*.java

if %ERRORLEVEL% NEQ 0 (
    echo ERREUR: Compilation echouee!
    pause
    exit /b 1
)

REM Compilation de la cible locale
echo Compilation de la cible locale...
javac -d out cibles/Login.java

if %ERRORLEVEL% NEQ 0 (
    echo ERREUR: Compilation de la cible locale echouee!
    pause
    exit /b 1
)

echo.
echo Compilation reussie! Les fichiers .class sont dans le dossier 'out'
echo.
echo Exemples d'utilisation:
echo   java -cp out CrackerApp bruteForce local admin
echo   java -cp out CrackerApp dictionnary remote user
echo.
pause 