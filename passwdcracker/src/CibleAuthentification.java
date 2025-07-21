// Package par défaut (aucun package spécifique)

public interface CibleAuthentification {
    /**
     * Tente d'authentifier le login/mot de passe sur la cible.
     * Retourne true si succès, false sinon.
     */
    boolean testerMotDePasse(String login, String motDePasse);
} 