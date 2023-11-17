package rmiClient;
import metier.Compte;
import rmiService.IBanque;
import java.rmi.Naming;
import java.rmi.NotBoundException;
/**
 * La classe BanqueClient représente un client RMI pour accéder aux services bancaires.
 */
public class BanqueClient {
    public static void main(String[] args) {
        try {
            // Recherche et récupération de l'objet distant IBanque via RMI
            IBanque banqueService = (IBanque) Naming.lookup("rmi://localhost:1098/BanqueService");
            // Création d'un compte avec des données initiales
            Compte compte1 = new Compte(123, 1000.0, null);
            // Appel de la méthode distante creerCompte pour créer un compte bancaire
            String resultatCreation = banqueService.creerCompte(compte1);
            System.out.println(resultatCreation);
            // Récupération des informations sur le compte à l'aide de la méthode distante getInfoCompte
            int codeCompte = 123; // Code du compte que vous souhaitez récupérer
            String infoCompte = banqueService.getInfoCompte(codeCompte);
            System.out.println(infoCompte);
        } catch (NotBoundException e) {
            // Gestion de l'exception si le service n'est pas trouvé
            throw new RuntimeException(e);
        } catch (Exception e) {
            // Gestion d'autres exceptions potentielles
            e.printStackTrace();
        }
    }
}
