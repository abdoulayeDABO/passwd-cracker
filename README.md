

### Factory method
classDiagram
    class StrategieAttaque {
        <<abstract>>
        +attaquer()*
    }

    class AttaqueBruteForce {
        +attaquer()
    }

    class AttaqueDictionnaire {
        +attaquer()
    }

    class FabriqueStrategieAttaque {
        <<abstract>>
        +creerStrategieAttaque() StrategieAttaque*
    }

    class FabriqueAttaqueBruteForce {
        +creerStrategieAttaque() StrategieAttaque
    }

    class FabriqueAttaqueDictionnaire {
        +creerStrategieAttaque() StrategieAttaque
    }

    StrategieAttaque <|-- AttaqueBruteForce
    StrategieAttaque <|-- AttaqueDictionnaire
    FabriqueStrategieAttaque <|-- FabriqueAttaqueBruteForce
    FabriqueStrategieAttaque <|-- FabriqueAttaqueDictionnaire
    FabriqueAttaqueBruteForce --> AttaqueBruteForce
    FabriqueAttaqueDictionnaire --> AttaqueDictionnaire





### Abstract Factory 

classDiagram
    class StrategieAttaque {
        <<abstract>>
        +attaquer()*
    }

    class Cible {
        <<abstract>>
        +authentifier(motDePasse: String)* Boolean
    }

    class AttaqueBruteForce {
        +attaquer()
    }

    class AttaqueDictionnaire {
        +attaquer()
    }

    class CibleLocale {
        +authentifier(motDePasse: String) Boolean
    }

    class CibleEnLigne {
        +authentifier(motDePasse: String) Boolean
    }

    class FabriqueCasseur {
        <<abstract>>
        +creerStrategieAttaque() StrategieAttaque*
        +creerCible() Cible*
    }

    class FabriqueBruteForceLocale {
        +creerStrategieAttaque() StrategieAttaque
        +creerCible() Cible
    }

    class FabriqueDictionnaireEnLigne {
        +creerStrategieAttaque() StrategieAttaque
        +creerCible() Cible
    }

    StrategieAttaque <|-- AttaqueBruteForce
    StrategieAttaque <|-- AttaqueDictionnaire
    Cible <|-- CibleLocale
    Cible <|-- CibleEnLigne
    FabriqueCasseur <|-- FabriqueBruteForceLocale
    FabriqueCasseur <|-- FabriqueDictionnaireEnLigne
    FabriqueBruteForceLocale --> AttaqueBruteForce
    FabriqueBruteForceLocale --> CibleLocale
    FabriqueDictionnaireEnLigne --> AttaqueDictionnaire
    FabriqueDictionnaireEnLigne --> CibleEnLigne





https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/package-summary.html