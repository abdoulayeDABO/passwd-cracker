@echo off
echo ========================================
echo Test du serveur web
echo ========================================
echo.

echo Test 1: Verification que le serveur repond...
powershell -Command "try { $response = Invoke-WebRequest -Uri 'http://localhost:8000/app/login.php' -Method POST -Body 'username=admin&password=wrong' -ContentType 'application/x-www-form-urlencoded' -TimeoutSec 5; Write-Host 'Serveur repond - Status:' $response.StatusCode; Write-Host 'Contenu:' $response.Content } catch { Write-Host 'ERREUR: Serveur non accessible -' $_.Exception.Message }"

echo.
echo Test 2: Test avec mauvais mot de passe...
powershell -Command "try { $response = Invoke-WebRequest -Uri 'http://localhost:8000/app/login.php' -Method POST -Body 'username=admin&password=wrong' -ContentType 'application/x-www-form-urlencoded' -TimeoutSec 5; Write-Host 'Status:' $response.StatusCode; Write-Host 'Reponse:' $response.Content } catch { Write-Host 'ERREUR:' $_.Exception.Message }"

echo.
echo Test 3: Test avec bon mot de passe...
powershell -Command "try { $response = Invoke-WebRequest -Uri 'http://localhost:8000/app/login.php' -Method POST -Body 'username=admin&password=passer' -ContentType 'application/x-www-form-urlencoded' -TimeoutSec 5; Write-Host 'Status:' $response.StatusCode; Write-Host 'Reponse:' $response.Content } catch { Write-Host 'ERREUR:' $_.Exception.Message }"

echo.
echo ========================================
echo Verification des logs
echo ========================================
echo.

if exist "web\auth_log.txt" (
    echo Fichier de logs trouve:
    type web\auth_log.txt
) else (
    echo Aucun fichier de logs trouve.
    echo Cela peut indiquer que:
    echo 1. Le serveur PHP n'est pas demarre
    echo 2. Le serveur Python ne peut pas executer PHP
    echo 3. Les requetes n'atteignent pas le serveur
)

echo.
pause 