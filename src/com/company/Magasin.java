package com.company;


import com.company.Produit;

import java.util.HashMap;

public class Magasin {
    private HashMap<String, Produit> produits = new HashMap<String, Produit>();

    public void ajouterProduit(Produit produit) {
        produits.put(produit.getId(), produit);
        System.out.println("Produit ajouté: " + produit);
    }

    public void supprimerProduit(String id) {
        Produit produit = produits.remove(id);
        if (produit != null) {
            System.out.println("Produit supprimé: " + produit);
        } else {
            System.out.println("Produit avec l'id " + id + " non trouvé.");
        }
    }

    public void modifierProduit(String id, String nouveauNom, double nouveauPrix) {
        Produit produit = produits.get(id);
        if (produit != null) {
            produit.setNom(nouveauNom);
            produit.setPrix(nouveauPrix);
            System.out.println("Produit modifié: " + produit);
        } else {
            System.out.println("Produit avec l'id " + id + " non trouvé.");
        }
    }

    public void rechercherProduitParNom(String nom) {
        for (Produit produit : produits.values()) {
            if (produit.getNom().equalsIgnoreCase(nom)) {
                System.out.println("Produit trouvé: " + produit);
                return;
            }
        }
        System.out.println("Produit avec le nom " + nom + " non trouvé.");
    }

    public void listerProduitsParLettre(char lettre) {
        boolean found = false;
        for (Produit produit : produits.values()) {
            if (produit.getNom().charAt(0) == lettre) {
                System.out.println(produit);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Aucun produit trouvé commençant par la lettre " + lettre);
        }
    }

    public void afficherNombreProduits() {
        System.out.println("Nombre de produits en stock: " + produits.size());
    }

    // Trois autres fonctionnalités utiles
    public void afficherProduitsMoinsChersQue(double prix) {
        for (Produit produit : produits.values()) {
            if (produit.getPrix() < prix) {
                System.out.println(produit);
            }
        }
    }

    public void afficherProduitsParCategorie(Class<?> categorie) {
        for (Produit produit : produits.values()) {
            if (categorie.isInstance(produit)) {
                System.out.println(produit);
            }
        }
    }

    public void afficherTousProduits() {
        for (Produit produit : produits.values()) {
            System.out.println(produit);
        }
    }
}
