package rmiService;
import metier.Compte;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
/**
 * Implémentation de l'interface IBanque pour les opérations bancaires.
 */
public class BanqueImpl extends UnicastRemoteObject implements IBanque {
    // Liste pour stocker les comptes
    List<Compte> comptes = new ArrayList<>();

    public BanqueImpl() throws RemoteException {
        super();
    }
    @Override
    public String creerCompte(Compte c) {
        // Ajout du compte à la liste
        comptes.add(c);

        // Message de confirmation
        return "Le compte avec le code " + c.getCode() + " a été créé avec succès.";
    }
    @Override
    public String getInfoCompte(int code) {
        // Recherche du compte dans la liste
        Compte compteRecherche = rechercherCompteParCode(code);

        if (compteRecherche != null) {
            // Construction du message d'information sur le compte
            return "Informations sur le compte :\n" +
                    "Code: " + compteRecherche.getCode() + "\n" +
                    "Solde: " + compteRecherche.getSolde() + "\n" +
                    "Date de création: " + compteRecherche.getDateCreation();
        } else {
            // Message d'erreur si le compte n'est pas trouvé
            return "Le compte avec le code " + code + " n'a pas été trouvé.";
        }
    }
    // Méthode utilitaire pour rechercher un compte par son code
    private Compte rechercherCompteParCode(int code) {
        for (Compte compte : comptes) {
            if (compte.getCode() == code) {
                return compte;
            }
        }
        return null; // Retourne null si le compte n'est pas trouvé
    }
}

