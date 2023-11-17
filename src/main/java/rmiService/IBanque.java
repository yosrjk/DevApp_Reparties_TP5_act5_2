package rmiService;

import metier.Compte;

import java.rmi.Remote;
import java.rmi.RemoteException;

// L'interface IBanque étend l'interface Remote pour indiquer qu'elle peut être utilisée à distance.
public interface IBanque extends Remote {

    // Méthode permettant de créer un compte bancaire.
    // Prend en paramètre un objet Compte représentant les informations du compte à créer.
    // Renvoie une chaîne de caractères indiquant le résultat de l'opération.
    String creerCompte(Compte c) throws RemoteException;

    // Méthode permettant d'obtenir des informations sur un compte bancaire en fonction de son code.
    // Prend en paramètre le code du compte à rechercher.
    // Renvoie une chaîne de caractères contenant les informations sur le compte ou
    // un message d'erreur si lecompte n'est pas trouvé.
    String getInfoCompte(int code) throws RemoteException;

}
