package com.company;

public class Alimentaire extends Produit {
    private String dateExpiration;

    public Alimentaire(String id, String nom, double prix, String dateExpiration) {
        super(id, nom, prix);
        this.dateExpiration = dateExpiration;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    @Override
    public String toString() {
        return "Alimentaire [id=" + id + ", nom=" + nom + ", prix=" + prix + ", dateExpiration=" + dateExpiration + "]";
    }
}
