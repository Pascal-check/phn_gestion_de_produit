package com.company;

public class Electronique extends Produit {
    private String marque;

    public Electronique(String id, String nom, double prix, String marque) {
        super(id, nom, prix);
        this.marque = marque;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
        return "Electronique [id=" + id + ", nom=" + nom + ", prix=" + prix + ", marque=" + marque + "]";
    }
}
