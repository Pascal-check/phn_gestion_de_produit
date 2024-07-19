package com.company;

public class Produit {
    protected String id;
    protected String nom;
    protected double prix;

    public Produit(String id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + "]";
    }
}
