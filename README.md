# Password Cracker - Projet de Design Pattern

## Description du Projet

Ce projet implémente un système de cassage de mots de passe éducatif en Java, démontrant deux techniques principales d'attaque : l'attaque par dictionnaire et l'attaque par force brute. L'application peut cibler des systèmes d'authentification locaux (Java) et distants (PHP via HTTP).


## Description de l'architecture

### 📁 Structure du Projet

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
## Choix des patrons de conception utilisés et leur justification
### 1. Pattern Factory Method (Patron Fabrique)
Choix du pattern
Nous avons opté pour l'implémentation du Factory Method plutôt que l'Abstract Factory pour ce projet.
Justification technique
Problématique adressée :
Le projet nécessite de créer dynamiquement différentes combinaisons de stratégies d'attaque (Brute Force, Dictionnaire) avec différents types de cibles (locale, en ligne). Sans pattern Factory, nous aurions eu un couplage fort entre le client et les classes concrètes, avec de nombreuses conditions if/else ou switch pour instancier les bonnes combinaisons.
Avantages apportés :

Découplage : Le code client n'a pas besoin de connaître les classes concrètes d'attaques
Extensibilité : Ajout facile de nouvelles méthodes d'attaque ou types de cibles sans modifier le code existant
Respect du principe Ouvert/Fermé : Le système est ouvert à l'extension mais fermé à la modification
Configuration dynamique : Possibilité de choisir la stratégie d'attaque via les arguments en ligne de commande


### 2. Pattern Strategy (Patron Stratégie)
Justification du choix complémentaire
Bien que non explicitement demandé, le pattern Strategy s'est naturellement intégré à notre architecture pour gérer les différents algorithmes d'attaque.
Problématique :
Les méthodes Brute Force et Dictionnaire ont des algorithmes complètement différents, mais partagent la même interface de base (attaquer une cible avec des identifiants).
Avantages :

Interchangeabilité : Possibilité de changer d'algorithme d'attaque à l'exécution
Isolation des algorithmes : Chaque stratégie est encapsulée dans sa propre classe
Testabilité améliorée : Chaque stratégie peut être testée indépendamment

### 3. Synergie Factory Method + Strategy
La combinaison des deux patterns crée une architecture particulièrement robuste :

Le Factory Method gère la création des objets selon la configuration
Le Strategy gère le comportement des algorithmes d'attaque

Cette synergie permet une flexibilité maximale : on peut facilement ajouter de nouvelles stratégies d'attaque (Rainbow Tables, Hybrid Attack) ou de nouveaux types de cibles (base de données, API REST) sans impacter le code existant.
### 4. Alternative considérée : Abstract Factory
Pourquoi pas Abstract Factory ?
L'Abstract Factory aurait été pertinent si nous avions eu des familles de produits plus complexes (par exemple : différents types d'encodage pour chaque type d'attaque). Dans notre cas, le Factory Method est suffisant et moins complexe à maintenir.
### 5. Respect des principes SOLID

    S (Single Responsibility) : Chaque factory ne crée qu'un type spécifique de cracker
    O (Open/Closed) : Nouvelles stratégies ajoutables sans modification du code existant
    L (Liskov Substitution) : Toutes les implémentations respectent le contrat de l'interface
    I (Interface Segregation) : Interfaces spécialisées pour chaque type d'opération
    D (Dependency Inversion) : Le code client dépend des abstractions, pas des implémentations concrètes


### Diagramme de Classes UML
![Diagramme de Classes UML - Vue d'ensemble](./diagramme.png)

## Choix des patrons de conception utilisés et leur justification

## Explication

## Pistes d'Amélioration

- **Threading** : Implémentation multi-thread pour paralléliser les tentatives
- **Gestion mémoire** : Génération de mots de passe à la volée plutôt qu'en liste
- **Cache** : Mise en cache des résultats pour éviter les répétitions
- **Retry Logic** : Mécanisme de retry en cas d'échec réseau
- **Logging** : Système de logs détaillé pour le debug
- **Validation** : Validation plus stricte des entrées utilisateur
- **Délais** : Introduction de délais entre les tentatives
- **Détection** : Détection des mécanismes anti-brute force
- **Attaque Hybride** : Combinaison dictionnaire + variations
- **Attaque par Masque** : Utilisation de masques de mots de passe
- **Attaque Rainbow Tables** : Support des tables arc-en-ciel
- **SSH** : Attaques contre les serveurs SSH
- **FTP** : Support du protocole FTP
- **Database** : Attaques contre les bases de données
- **Fichiers de configuration** : Externalisation des paramètres
- **Profils d'attaque** : Création de profils prédéfinis
- **Interface graphique** : Développement d'une GUI
- **Vitesse** : Mesure des tentatives par seconde
- **Progression** : Indicateur de progression pour les attaques longues
- **Statistiques** : Rapport détaillé des résultats
- **Formats** : Export en JSON, XML, PDF
- **Visualisation** : Graphiques de performance
- **Historique** : Sauvegarde des résultats d'attaques


## 🚀 Installation et Compilation

### Prérequis
- Java JDK 8 ou supérieur
- Serveur web local (pour les tests en ligne)


### **Confuguration pour tester les attaques remote**
1. Installer XAMPP ou WAMP
2. Copier `cibles/login.php` dans le dossier `htdocs/app/`
3. Démarrer Apache
4. Le fichier sera accessible sur `http://localhost/app/login.php`

### **Comment Executer ?**
```bash
# Tester toutes les combinaisons
java -cp out CrackerApp bruteForce local admin
java -cp out CrackerApp bruteForce remote admin
java -cp out CrackerApp dictionnary local admin
java -cp out CrackerApp dictionnary remote admin
```


## Conclusion

Ce projet démontre l'implémentation effective de patrons de conception dans un contexte de sécurité informatique. L'architecture modulaire facilite l'extension et la maintenance, tandis que les patrons utilisés garantissent la flexibilité et la réutilisabilité du code. Les améliorations proposées permettraient de transformer ce prototype éducatif en un outil plus robuste et performant.

