# Password Cracker - Projet de Sécurité Informatique

## Description du Projet

Ce projet implémente un système de cassage de mots de passe éducatif en Java, démontrant deux techniques principales d'attaque : l'attaque par dictionnaire et l'attaque par force brute. L'application peut cibler des systèmes d'authentification locaux (Java) et distants (PHP via HTTP).

## Architecture Logicielle

### Diagramme de Classes UML

#### Diagramme de Classes Principal
![Diagramme de Classes UML - Vue d'ensemble](./docs/images/class-diagram-overview.png)

#### Diagramme des Patrons de Conception
![Diagrammes des Patrons - Factory et Strategy](./docs/images/patterns-diagram.png)

#### Architecture en Couches
![Architecture du Système](./docs/images/architecture-layers.png)

> **Note** : Les diagrammes UML sont disponibles dans le dossier `docs/images/`.Le fichier Readme du dépôt GitHub de votre projet devra contenir un rapport succinct 
contenant : 
o Une description de l’architecture logicielle (diagramme de classes UML) 
o Le choix des patrons de conception utilisés et leur justification. 
o Une explication des variantes implémentées. 
o D’éventuelles pistes d’amélioration. Le fichier Readme du dépôt GitHub de votre projet devra contenir un rapport succinct 
contenant : 
o Une description de l’architecture logicielle (diagramme de classes UML) 
o Le choix des patrons de conception utilisés et leur justification. 
o Une explication des variantes implémentées. Le fichier Readme du dépôt GitHub de votre projet devra contenir un rapport succinct 
contenant : 
o Une description de l’architecture logicielle (diagramme de classes UML) 
o Le choix des patrons de conception utilisés et leur justification. 
o Une explication des variantes implémentées. 
o D’éventuelles pistes d’amélioration. Le fichier Readme du dépôt GitHub de votre projet devra contenir un rapport succinct 
contenant : 
o Une description de l’architecture logicielle (diagramme de classes UML) 
o Le choix des patrons de conception utilisés et leur justification. 
o Une explication des variantes implémentées. 
o D’éventuelles pistes d’amélioration. Le fichier Readme du dépôt GitHub de votre projet devra contenir un rapport succinct 
contenant : 
o Une description de l’architecture logicielle (diagramme de classes UML) 
o Le choix des patrons de conception utilisés et leur justification. 
o Une explication des variantes implémentées. 
o D’éventuelles pistes d’amélioration. Le fichier Readme du dépôt GitHub de votre projet devra contenir un rapport succinct 
contenant : 
o Une description de l’architecture logicielle (diagramme de classes UML) 
o Le choix des patrons de conception utilisés et leur justification. 
o Une explication des variantes implémentées. 
o D’éventuelles pistes d’amélioration. Le fichier Readme du dépôt GitHub de votre projet devra contenir un rapport succinct 
contenant : 
o Une description de l’architecture logicielle (diagramme de classes UML) 
o Le choix des patrons de conception utilisés et leur justification. 
o Une explication des variantes implémentées. 
o D’éventuelles pistes d’amélioration. Le fichier Readme du dépôt GitHub de votre projet devra contenir un rapport succinct 
contenant : 
o Une description de l’architecture logicielle (diagramme de classes UML) 
o Le choix des patrons de conception utilisés et leur justification. 
o Une explication des variantes implémentées. 
o D’éventuelles pistes d’amélioration. Le fichier Readme du dépôt GitHub de votre projet devra contenir un rapport succinct 
contenant : 
o Une description de l’architecture logicielle (diagramme de classes UML) 
o Le choix des patrons de conception utilisés et leur justification. 
o Une explication des variantes implémentées. 
o D’éventuelles pistes d’amélioration. Le fichier Readme du dépôt GitHub de votre projet devra contenir un rapport succinct 
contenant : 
o Une description de l’architecture logicielle (diagramme de classes UML) 
o Le choix des patrons de conception utilisés et leur justification. 
o Une explication des variantes implémentées. 
o D’éventuelles pistes d’amélioration. Le fichier Readme du dépôt GitHub de votre projet devra contenir un rapport succinct 
contenant : 
o Une description de l’architecture logicielle (diagramme de classes UML) 
o Le choix des patrons de conception utilisés et leur justification. 
o Une explication des variantes implémentées. 
o D’éventuelles pistes d’amélioration. Le fichier Readme du dépôt GitHub de votre projet devra contenir un rapport succinct 
contenant : 
o Une description de l’architecture logicielle (diagramme de classes UML) 
o Le choix des patrons de conception utilisés et leur justification. 
o Une explication des variantes implémentées. 
o D’éventuelles pistes d’amélioration. Le fichier Readme du dépôt GitHub de votre projet devra contenir un rapport succinct 
contenant : 
o Une description de l’architecture logicielle (diagramme de classes UML) 
o Le choix des patrons de conception utilisés et leur justification. 
o Une explication des variantes implémentées. 
o D’éventuelles pistes d’amélioration. 

#### 1. Classe Principale (`App`)
- **Responsabilité** : Point d'entrée de l'application, validation des arguments, orchestration
- **Fonctionnalités** :
  - Validation des paramètres d'entrée
  - Sélection de la fabrique d'attaque appropriée
  - Lancement de l'attaque

#### 2. Hiérarchie des Attaques
- **`Attaque` (Classe abstraite)** : Définit l'interface commune pour toutes les attaques
- **`AttaqueDictionnaire`** : Implémente l'attaque par dictionnaire
- **`AttaqueBruteForce`** : Implémente l'attaque par force brute

#### 3. Hiérarchie des Fabriques
- **`FabriqueAttaque` (Classe abstraite)** : Définit l'interface de création d'attaques
- **`FabriqueAttaqueDictionnaire`** : Crée des instances d'attaque par dictionnaire
- **`FabriqueAttaqueBruteForce`** : Crée des instances d'attaque par force brute

#### 4. Classes Utilitaires
- **`HttpUtils`** : Gestion des requêtes HTTP pour les attaques distantes
- **`PasswordUtils`** : Génération de mots de passe pour les attaques par force brute

## Patrons de Conception Utilisés

### 1. Factory Method Pattern (Méthode Fabrique)

**Justification** :
- **Flexibilité** : Permet d'ajouter facilement de nouveaux types d'attaques sans modifier le code existant
- **Découplage** : Sépare la création d'objets de leur utilisation
- **Principe Ouvert/Fermé** : Ouvert à l'extension, fermé à la modification

**Implémentation** :
```java
// Fabrique abstraite
public abstract class FabriqueAttaque {
    public abstract Attaque creerAttaque();
}

// Fabriques concrètes
public class FabriqueAttaqueDictionnaire extends FabriqueAttaque {
    public Attaque creerAttaque() {
        return new AttaqueDictionnaire();
    }
}
```

### 2. Strategy Pattern (Patron Stratégie)

**Justification** :
- **Encapsulation** : Chaque algorithme d'attaque est encapsulé dans sa propre classe
- **Interchangeabilité** : Les stratégies peuvent être changées dynamiquement
- **Maintenance** : Facilite la modification et l'ajout de nouvelles stratégies

**Implémentation** :
```java
// Stratégie abstraite
public abstract class Attaque {
    public abstract void initier(String cible, String login);
}

// Stratégies concrètes
public class AttaqueDictionnaire extends Attaque { ... }
public class AttaqueBruteForce extends Attaque { ... }
```

### 3. Template Method Pattern (Patron Méthode Template)

**Justification** :
- **Réutilisation** : Structure commune pour les différents types d'attaques
- **Personnalisation** : Permet aux sous-classes de personnaliser certaines étapes

**Implémentation** :
Chaque classe d'attaque suit le même template :
1. Validation des paramètres
2. Sélection de la cible (local/remote)
3. Exécution de l'algorithme spécifique
4. Vérification du résultat

## Variantes Implémentées

### 1. Types d'Attaques

#### Attaque par Dictionnaire
- **Principe** : Teste une liste prédéfinie de mots de passe courants
- **Avantages** : Rapide, efficace contre les mots de passe faibles
- **Fichier** : `data/password.txt` contient la liste des mots de passe

#### Attaque par Force Brute
- **Principe** : Teste systématiquement toutes les combinaisons possibles
- **Avantages** : Théoriquement garantie de trouver le mot de passe
- **Note** : Implémentation partiellement complète (méthode `generateNextPassword()` à finaliser)

### 2. Types de Cibles

#### Cible Locale (Java)
- **Description** : Teste contre l'application Java `Login.java`
- **Mécanisme** : Exécution de processus externe et analyse du code de sortie
- **Authentification** : Login: "admin", Mot de passe: "passer"

#### Cible Distante (PHP/HTTP)
- **Description** : Teste contre une application web PHP
- **Mécanisme** : Requêtes HTTP POST vers `login.php`
- **Indicateur de succès** : Code de réponse HTTP 200

### 3. Gestion des Protocoles
- **HTTP/2** : Support du protocole HTTP/2 pour les attaques distantes
- **Timeouts** : Gestion des timeouts de connexion et de requête
- **Headers** : Configuration appropriée des en-têtes HTTP

## Utilisation

### Compilation
```bash
# Windows
.\compile.bat

# Ou manuellement
javac -cp src src/*.java src/utils/*.java -d out
```

### Exécution
```bash
java -cp out App <type> <cible> <login>
```

**Paramètres** :
- `<type>` : "dictionnary" ou "brute-force"
- `<cible>` : "local" ou "remote"
- `<login>` : nom d'utilisateur à tester

**Exemples** :
```bash
# Attaque par dictionnaire sur cible locale
java -cp out App dictionnary local admin

# Attaque par force brute sur cible distante
java -cp out App brute-force remote admin
```

## Pistes d'Amélioration

### 1. Implémentation et Fonctionnalités

#### Finalisation de l'Attaque par Force Brute
- **Priorité** : Haute
- **Description** : Compléter l'implémentation de `generateNextPassword()`
- **Suggestion** : Utiliser `PasswordUtils` pour la génération systématique

#### Optimisation des Performances
- **Threading** : Implémentation multi-thread pour paralléliser les tentatives
- **Gestion mémoire** : Génération de mots de passe à la volée plutôt qu'en liste
- **Cache** : Mise en cache des résultats pour éviter les répétitions

### 2. Sécurité et Robustesse

#### Gestion d'Erreurs Améliorée
- **Retry Logic** : Mécanisme de retry en cas d'échec réseau
- **Logging** : Système de logs détaillé pour le debug
- **Validation** : Validation plus stricte des entrées utilisateur

#### Rate Limiting
- **Délais** : Introduction de délais entre les tentatives
- **Détection** : Détection des mécanismes anti-brute force

### 3. Architecture et Extensibilité

#### Nouveaux Types d'Attaques
- **Attaque Hybride** : Combinaison dictionnaire + variations
- **Attaque par Masque** : Utilisation de masques de mots de passe
- **Attaque Rainbow Tables** : Support des tables arc-en-ciel

#### Support de Protocoles Additionnels
- **SSH** : Attaques contre les serveurs SSH
- **FTP** : Support du protocole FTP
- **Database** : Attaques contre les bases de données

#### Configuration Externalisée
- **Fichiers de configuration** : Externalisation des paramètres
- **Profils d'attaque** : Création de profils prédéfinis
- **Interface graphique** : Développement d'une GUI

### 4. Monitoring et Reporting

#### Métriques de Performance
- **Vitesse** : Mesure des tentatives par seconde
- **Progression** : Indicateur de progression pour les attaques longues
- **Statistiques** : Rapport détaillé des résultats

#### Génération de Rapports
- **Formats** : Export en JSON, XML, PDF
- **Visualisation** : Graphiques de performance
- **Historique** : Sauvegarde des résultats d'attaques

### 5. Considérations Éthiques et Légales

#### Avertissements et Limitations
- **Usage éducatif** : Clarification de l'usage purement éducatif
- **Autorisations** : Vérification des autorisations avant utilisation
- **Responsabilité** : Clauses de non-responsabilité

## Conclusion

Ce projet démontre l'implémentation effective de patrons de conception dans un contexte de sécurité informatique. L'architecture modulaire facilite l'extension et la maintenance, tandis que les patrons utilisés garantissent la flexibilité et la réutilisabilité du code. Les améliorations proposées permettraient de transformer ce prototype éducatif en un outil plus robuste et performant.

---

**Note importante** : Ce projet est destiné uniquement à des fins éducatives et de recherche en sécurité. Toute utilisation à des fins malveillantes est strictement interdite et peut être illégale.