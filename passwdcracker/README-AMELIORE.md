# Password Cracker - Version Améliorée avec Abstract Factory

## 🎯 Objectif du Projet

Ce projet implémente un système de cassage de mots de passe utilisant les **patterns de conception Factory Method** et **Abstract Factory**. Il simule deux techniques d'attaque (Brute Force et Dictionnaire) sur deux types de cibles (locale et en ligne).

## 🏗️ Architecture Améliorée

### Patterns Utilisés

#### 1. **Abstract Factory Pattern**
- **FabriqueCible** : Fabrique abstraite pour créer des cibles d'authentification
  - `FabriqueCibleLocale` : Crée des cibles locales (process Java)
  - `FabriqueCibleEnLigne` : Crée des cibles en ligne (HTTP)

#### 2. **Factory Method Pattern**
- **FabriqueAttaque** : Fabrique abstraite pour créer des stratégies d'attaque
  - `FabriqueAttaqueBruteForce` : Crée des attaques par force brute
  - `FabriqueAttaqueDictionnaire` : Crée des attaques par dictionnaire

### Avantages de cette Architecture

✅ **Séparation des responsabilités** : Chaque fabrique a une responsabilité unique  
✅ **Extensibilité** : Facile d'ajouter de nouveaux types d'attaques ou de cibles  
✅ **Flexibilité** : Combinaison libre entre attaques et cibles  
✅ **Maintenabilité** : Code modulaire et bien structuré  
✅ **Testabilité** : Chaque composant peut être testé indépendamment  

## 📁 Structure du Projet

```
passwdcracker/
├── src/
│   ├── CibleAuthentification.java          # Interface pour les cibles
│   ├── CibleLocale.java                    # Implémentation locale
│   ├── CibleEnLigne.java                   # Implémentation en ligne
│   ├── FabriqueCible.java                  # Fabrique abstraite pour les cibles
│   ├── FabriqueCibleLocale.java            # Fabrique concrète locale
│   ├── FabriqueCibleEnLigne.java           # Fabrique concrète en ligne
│   ├── Attaque.java                        # Classe abstraite des attaques
│   ├── AttaqueBruteForce.java              # Attaque par force brute
│   ├── AttaqueDictionnaire.java            # Attaque par dictionnaire
│   ├── FabriqueAttaque.java                # Fabrique abstraite pour les attaques
│   ├── FabriqueAttaqueBruteForce.java      # Fabrique concrète brute force
│   ├── FabriqueAttaqueDictionnaire.java    # Fabrique concrète dictionnaire
│   ├── CrackerApp.java                     # Point d'entrée principal
│   └── utils/                              # Utilitaires
│       ├── ConsoleUtils.java               # Affichage coloré
│       ├── FileUtils.java                  # Opérations sur fichiers
│       ├── HttpUtils.java                  # Requêtes HTTP
│       └── PasswordUtils.java              # Génération de mots de passe
├── cibles/
│   ├── Login.java                          # Cible locale (Java)
│   └── login.php                           # Cible en ligne (PHP)
├── data/
│   └── password.txt                        # Dictionnaire de mots de passe
├── web/
│   └── app/
│       ├── login.php
│       └── index.html   # Mini-site de test HTML
├── compile-improved.bat                    # Script de compilation
├── start-php-server.bat # Serveur PHP avec logs
├── test-server.bat      # Script de test manuel du serveur
└── README-AMELIORE.md                      # Ce fichier
```

## 🚀 Installation et Compilation

### Prérequis
- Java JDK 8 ou supérieur
- Serveur web local (pour les tests en ligne)

### Compilation
```bash
# Windows
compile-improved.bat

# Linux/Mac
chmod +x compile-improved.sh
./compile-improved.sh
```

## 🎮 Utilisation

### Syntaxe
```bash
java -cp out CrackerApp <type_attaque> <type_cible> <login>
```

### Paramètres
- **type_attaque** : `bruteForce` ou `dictionnary`
- **type_cible** : `local` ou `remote`
- **login** : Nom d'utilisateur à tester

### Exemples
```bash
# Attaque par force brute sur cible locale
java -cp out CrackerApp bruteForce local admin

# Attaque par dictionnaire sur cible en ligne
java -cp out CrackerApp dictionnary remote user

# Attaque par force brute sur cible en ligne
java -cp out CrackerApp bruteForce remote test
```

## 🌐 Démo en ligne : Mini-site HTML

Pour tester manuellement l’authentification en ligne, un mini-site HTML est fourni :

1. Lance le serveur PHP :
   ```bash
   cd web
   php -S localhost:8000
   ```
2. Ouvre [http://localhost:8000/app/index.html](http://localhost:8000/app/index.html)
3. Utilise le formulaire pour tester la connexion (login: `admin`, mot de passe: `passer`)

## 🧪 Distinguer les attaques dans les logs

Le serveur PHP ne sait pas directement si l’attaque est par brute force ou dictionnaire. Mais tu peux le deviner en regardant les logs générés dans `web/auth_log.txt` :

- **Attaque par dictionnaire** :
  - Les mots de passe testés sont issus du fichier `data/password.txt` (ex: belier, ananas, passer, ...)
  - Exemple de log :
    ```
    2024-07-20 15:00:01 - Tentative: admin / belier - ECHEC
    2024-07-20 15:00:02 - Tentative: admin / ananas - ECHEC
    2024-07-20 15:00:03 - Tentative: admin / passer - SUCCES
    ```
- **Attaque par brute force** :
  - Les mots de passe testés sont générés automatiquement, souvent courts ou de forme séquentielle (ex: a, b, c, aa, ab, ...)
  - Exemple de log :
    ```
    2024-07-20 15:01:10 - Tentative: admin / a - ECHEC
    2024-07-20 15:01:11 - Tentative: admin / b - ECHEC
    2024-07-20 15:01:12 - Tentative: admin / passer - SUCCES
    ```

**Astuce** :
- Le type d’attaque dépend de la commande utilisée côté client :
  - `java -cp out CrackerApp bruteForce remote admin` → brute force
  - `java -cp out CrackerApp dictionnary remote admin` → dictionnaire
- Pour la soutenance, montre les deux types d’attaque et compare les logs !

## 🔧 Configuration

### Cible Locale
La cible locale utilise le fichier `cibles/Login.java` qui doit être compilé et accessible.

### Cible En Ligne
La cible en ligne nécessite :
1. Un serveur web local (Apache, XAMPP, etc.)
2. Le fichier `cibles/login.php` accessible à `http://localhost/app/login.php`
3. Configuration PHP appropriée

### Dictionnaire
Le fichier `data/password.txt` contient les mots de passe à tester pour l'attaque par dictionnaire.

## 📊 Comparaison avec l'Ancienne Version

| Aspect | Ancienne Version | Nouvelle Version |
|--------|------------------|------------------|
| **Architecture** | Factory Method uniquement | Factory Method + Abstract Factory |
| **Couplage** | Switch sur les types | Injection de dépendances |
| **Extensibilité** | Modifications dans le code principal | Ajout de nouvelles classes |
| **Testabilité** | Difficile à mocker | Facile à tester unitairement |
| **Flexibilité** | Combinaisons prédéfinies | Combinaisons dynamiques |

## 🎨 Diagramme UML

```
┌─────────────────┐    ┌──────────────────┐    ┌─────────────────┐
│   CrackerApp    │    │  FabriqueAttaque │    │  FabriqueCible  │
│                 │    │   (Abstract)     │    │   (Abstract)    │
└─────────────────┘    └──────────────────┘    └─────────────────┘
         │                       │                       │
         │                       │                       │
         ▼                       ▼                       ▼
┌─────────────────┐    ┌──────────────────┐    ┌─────────────────┐
│     Attaque     │    │ FabriqueAttaque  │    │ FabriqueCible   │
│   (Abstract)    │    │   BruteForce     │    │    Locale       │
└─────────────────┘    └──────────────────┘    └─────────────────┘
         │                       │                       │
         │                       │                       │
    ┌────┴────┐            ┌─────┴─────┐            ┌────┴────┐
    │         │            │           │            │         │
    ▼         ▼            ▼           ▼            ▼         ▼
┌─────────┐ ┌─────────┐ ┌─────────┐ ┌─────────┐ ┌─────────┐ ┌─────────┐
│Attaque  │ │Attaque  │ │Fabrique │ │Fabrique │ │Fabrique │ │Fabrique │
│Brute    │ │Dictio   │ │Attaque  │ │Attaque  │ │Cible    │ │Cible    │
│Force    │ │nnaire   │ │Brute    │ │Dictio   │ └─────────┘ └─────────┘
└─────────┘ └─────────┘ └─────────┘ └─────────┘
```

## 🧪 Tests

### Test de Compilation
```bash
# Vérifier que tout compile
compile-improved.bat
```

### Test Fonctionnel
```bash
# Test avec cible locale
java -cp out CrackerApp bruteForce local admin

# Test avec cible en ligne (serveur requis)
java -cp out CrackerApp dictionnary remote user
```

## 🔍 Points d'Amélioration Futurs

1. **Ajout de nouveaux types d'attaques** : Rainbow Tables, Attaque par timing
2. **Support de nouvelles cibles** : API REST, Base de données
3. **Interface graphique** : GUI pour une utilisation plus conviviale
4. **Parallélisation** : Exécution multi-thread pour améliorer les performances
5. **Logging avancé** : Système de logs détaillés
6. **Configuration externe** : Fichier de configuration JSON/YAML

## 📝 Notes Techniques

- **Thread Safety** : Les classes sont thread-safe pour permettre la parallélisation future
- **Gestion d'erreurs** : Gestion robuste des exceptions avec messages informatifs
- **Performance** : Optimisations pour les attaques par force brute (génération efficace)
- **Sécurité** : Simulation uniquement, pas d'utilisation malveillante

## 🤝 Contribution

Pour contribuer à l'amélioration du projet :
1. Créer une nouvelle branche
2. Implémenter les améliorations
3. Tester avec les cas d'usage existants
4. Documenter les changements
5. Soumettre une pull request

---

