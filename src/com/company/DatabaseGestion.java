package com.company;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

class DatabaseGestion {
    private static final String URL = "jdbc:freedb://localhost:3306/freedb_Connectivityjava";
    private static final String USER = "freedb_pascalkong";
    private static final String PASSWORD = "wwU3!!k%ydu#f5V";

    static {
        try {
            // Charger le pilote JDBC
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Échec du chargement du pilote JDBC", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static Map<String, Produit> chargerProduits() throws SQLException {
        Map<String, Produit> produits = new HashMap<>();
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM produits";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String nom = resultSet.getString("nom");
                    String type = resultSet.getString("type");
                    Produit produit = null;
                    if ("Electronique".equals(type)) {
                        produit = new Electronique(id, nom, resultSet.getString("marque"));
                    } else if ("Alimentaire".equals(type)) {
                        produit = new Alimentaire(id, nom, resultSet.getString("dateExpiration"));
                    } else if ("Vestimentaire".equals(type)) {
                        produit = new Vestimentaire(id, nom, resultSet.getString("taille"));
                    }
                    produits.put(id, produit);
                }
            }
        }
        return produits;
    }

    public static void executeQuery(String query) throws SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                // Traiter le résultat
                String id = resultSet.getString("id");
                String nom = resultSet.getString("nom");
                String type = resultSet.getString("type");
                System.out.println("ID: " + id + ", Nom: " + nom + ", Type: " + type);
            }
        }
    }
}