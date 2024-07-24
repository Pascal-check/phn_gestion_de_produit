package com.company;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

class Magasin {
    private Map<String, Produit> produits = new HashMap<>();

    public void ajouterProduit(Produit produit) {
        produits.put(produit.getId(), produit);
    }

    public void supprimerProduit(String id) throws ProduitNonTrouveException {
        if (produits.remove(id) == null) {
            throw new ProduitNonTrouveException("Produit avec l'ID " + id + " non trouvé.");
        }
    }

    public void modifierProduit(String id, String nouveauNom) throws ProduitNonTrouveException {
        Produit produit = produits.get(id);
        if (produit == null) {
            throw new ProduitNonTrouveException("Produit avec l'ID " + id + " non trouvé.");
        }
        produit.setNom(nouveauNom);
    }

    public Produit rechercherProduitParNom(String nom) throws ProduitNonTrouveException {
        for (Produit produit : produits.values()) {
            if (produit.getNom().equalsIgnoreCase(nom)) {
                return produit;
            }
        }
        throw new ProduitNonTrouveException("Produit avec le nom " + nom + " non trouvé.");
    }

    public void listerProduitsParLettre(char lettre) {
        for (Produit produit : produits.values()) {
            if (produit.getNom().charAt(0) == lettre) {
                System.out.println(produit);
            }
        }
    }

    public int nombreDeProduitsEnStock() {
        return produits.size();
    }

    public void sauvegarderProduits() throws SQLException {
        DatabaseGestion.sauvegarderProduits(produits);
    }

    public void chargerProduits() throws SQLException {
        produits = DatabaseGestion.chargerProduits();
    }
}