# Guide de Test - Password Cracker Amélioré

## 🎯 **Informations de Test**

### **Mots de passe de test disponibles**

| Cible | Login | Mot de passe | Fichier |
|-------|-------|--------------|---------|
| **Locale** | `admin` | `passer` | `cibles/Login.java` |
| **En ligne** | `admin` | `passer` | `cibles/login.php` |

### **Dictionnaire de mots de passe**
Le fichier `data/password.txt` contient 15 mots de passe, dont `passer` qui correspond aux cibles de test.

## 🚀 **Tests Locaux (Recommandés)**

### **1. Test de base**
```bash
# Compilation
compile-improved.bat

# Test automatique complet
test-complet.bat
```

### **2. Tests manuels**

#### **Attaque par dictionnaire sur cible locale**
```bash
java -cp out CrackerApp dictionnary local admin
```
**Résultat attendu :** Le mot de passe `passer` devrait être trouvé rapidement.

#### **Attaque par force brute sur cible locale**
```bash
java -cp out CrackerApp bruteForce local admin
```
**Résultat attendu :** Le mot de passe `passer` devrait être trouvé après plusieurs tentatives.

## 🌐 **Tests En Ligne (Optionnels)**

### **1. Configuration du serveur web**

#### **Option A : Serveur Python (Recommandé)**
```bash
# Démarrer le serveur
start-server.bat
```
Le serveur sera accessible sur `http://localhost:8000/app/login.php`

#### **Option B : XAMPP/WAMP**
1. Installer XAMPP ou WAMP
2. Copier `cibles/login.php` dans le dossier `htdocs/app/`
3. Démarrer Apache
4. Le fichier sera accessible sur `http://localhost/app/login.php`

### **2. Tests en ligne**

#### **Attaque par dictionnaire sur cible en ligne**
```bash
java -cp out CrackerApp dictionnary remote admin
```

#### **Attaque par force brute sur cible en ligne**
```bash
java -cp out CrackerApp bruteForce remote admin
```

## 📊 **Scénarios de Test**

### **Scénario 1 : Test de validation**
```bash
# Sans arguments (doit afficher l'aide)
java -cp out CrackerApp

# Arguments invalides (doit rejeter)
java -cp out CrackerApp invalid local admin
java -cp out CrackerApp bruteForce invalid admin
```

### **Scénario 2 : Test de succès**
```bash
# Dictionnaire sur locale (rapide)
java -cp out CrackerApp dictionnary local admin

# Force brute sur locale (plus lent)
java -cp out CrackerApp bruteForce local admin
```

### **Scénario 3 : Test d'échec**
```bash
# Login inexistant
java -cp out CrackerApp dictionnary local inexistant

# Mot de passe non dans le dictionnaire
# (Modifier temporairement le mot de passe dans Login.java)
```

## 🔧 **Dépannage**

### **Erreur de compilation**
```bash
# Vérifier Java
java -version

# Nettoyer et recompiler
rmdir /s out
compile-improved.bat
```

### **Erreur de cible locale**
```bash
# Vérifier que Login.java est compilé
cd cibles
javac Login.java
cd ..
```

### **Erreur de cible en ligne**
```bash
# Vérifier le serveur web
curl http://localhost:8000/app/login.php

# Vérifier les logs du serveur
# Redémarrer le serveur si nécessaire
```

### **Erreur de dictionnaire**
```bash
# Vérifier que le fichier existe
dir data\password.txt

# Vérifier le contenu
type data\password.txt
```

## 📈 **Résultats Attendus**

### **Attaque par dictionnaire**
```
Démarrage de l'attaque par dictionnaire...
Tentative avec mot de passe: belier -> ECHEC
Tentative avec mot de passe: ananas -> ECHEC
...
Tentative avec mot de passe: passer -> SUCCES
Mot de passe trouve: passer
```

### **Attaque par force brute**
```
Démarrage de l'attaque par force brute...
Tentative avec mot de passe: a -> ECHEC
Tentative avec mot de passe: b -> ECHEC
...
Tentative avec mot de passe: passer -> SUCCES
Mot de passe trouve: passer
```

## 🎯 **Validation de l'Architecture**

### **Test de flexibilité**
```bash
# Tester toutes les combinaisons
java -cp out CrackerApp bruteForce local admin
java -cp out CrackerApp bruteForce remote admin
java -cp out CrackerApp dictionnary local admin
java -cp out CrackerApp dictionnary remote admin
```

### **Test d'extensibilité**
- Ajouter un nouveau mot de passe dans `data/password.txt`
- Modifier temporairement le mot de passe dans `Login.java`
- Vérifier que les attaques fonctionnent toujours

## 📝 **Notes Importantes**

1. **Sécurité** : Ce projet est une simulation éducative uniquement
2. **Performance** : L'attaque par force brute peut être lente
3. **Réseau** : Les tests en ligne nécessitent une connexion Internet
4. **Ports** : Le serveur web utilise le port 8000 par défaut

## 🏆 **Critères de Succès**

- ✅ Compilation sans erreur
- ✅ Validation des arguments fonctionne
- ✅ Attaque par dictionnaire trouve le mot de passe
- ✅ Attaque par force brute trouve le mot de passe
- ✅ Tests en ligne fonctionnent (si serveur configuré)
- ✅ Aucun switch sur les types dans le code
- ✅ Architecture modulaire et extensible

---

**Bon test !** 🚀 