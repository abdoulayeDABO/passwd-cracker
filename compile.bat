@echo off
echo Compilation de la version amelioree du Password Cracker...
echo.

REM Compilation des classes principales
echo Compilation des classes principales...

cd passwdcracker
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
echo Compilation reussie! Les fichiers .class sont dans le dossier 'passwdcracker/out'
echo.
echo Exemples d'utilisation:
echo   cd passwdcracker
echo   java -cp out CrackerApp bruteForce local admin
echo   java -cp out CrackerApp dictionnary remote user
echo.


