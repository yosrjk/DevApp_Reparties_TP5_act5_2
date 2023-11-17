package metier;

import java.io.Serializable;
import java.util.Date;
/**
 * Classe représentant un compte avec un code, un solde et une date de création.
 * Cette classe implémente l'interface Serializable pour permettre la sérialisation.
 */
public class Compte implements Serializable {
    // Caractéristiques du compte
     private int code ;
     private double solde;
     private Date dateCreation ;
    // Getters et Setters pour accéder aux attributs privés

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Constructeur de la classe Compte.
     *
     * @param code          Le code du compte.
     * @param solde         Le solde du compte.
     * @param dateCreation  La date de création du compte.
     */

    public Compte(int code, double solde, Date dateCreation) {
        this.code = code;
        this.solde = solde;
        this.dateCreation = dateCreation;
    }
    @Override
    public String toString() {
        return "Compte{" +
                "code=" + code +
                ", solde=" + solde +
                ", dateCreation=" + dateCreation +
                '}';
    }

}
