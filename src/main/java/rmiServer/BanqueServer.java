package rmiServer;
import rmiService.BanqueImpl;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
/**
 * La classe BanqueServer représente le serveur RMI pour les services bancaires.
 */
public class BanqueServer {

    public static void main(String[] args) {
        try {
            // Création d'une instance de l'implémentation des services bancaires (BanqueImpl)
            BanqueImpl banqueService = new BanqueImpl();

            // Création du registre RMI sur le port 1098
            LocateRegistry.createRegistry(1098);

            // Association de l'implémentation des services bancaires avec une URL RMI
            Naming.rebind("rmi://localhost:1098/BanqueService", (Remote) banqueService);

            // Affichage d'un message indiquant que le serveur RMI Banque est prêt
            System.out.println("Serveur RMI Banque prêt !");
        } catch (RemoteException e) {
            // En cas d'erreur liée à la communication RMI
            throw new RuntimeException(e);
        } catch (Exception e) {
            // En cas d'autres exceptions
            e.printStackTrace();
        }
    }
}
