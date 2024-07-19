package com.company;

import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Magasin magasin = new Magasin();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Ajouter un produit");
            System.out.println("2. Supprimer un produit");
            System.out.println("3. Modifier un produit");
            System.out.println("4. Rechercher un produit par nom");
            System.out.println("5. Lister les produits par lettre");
            System.out.println("6. Afficher le nombre de produits");
            System.out.println("7. Afficher les produits moins chers que");
            System.out.println("8. Afficher les produits par catégorie");
            System.out.println("9. Afficher tous les produits");
            System.out.println("0. Quitter");
            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le saut de ligne

            switch (choix) {
                case 1:
                    System.out.print("Entrez l'id: ");
                    String id = scanner.nextLine();
                    System.out.print("Entrez le nom: ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez le prix: ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine(); // Consommer le saut de ligne

                    System.out.println("Type de produit (1: Electronique, 2: Alimentaire, 3: Vestimentaire): ");
                    int type = scanner.nextInt();
                    scanner.nextLine(); // Consommer le saut de ligne
                    Produit produit = null;

                    switch (type) {
                        case 1:
                            System.out.print("Entrez la marque: ");
                            String marque = scanner.nextLine();
                            produit = new Electronique(id, nom, prix, marque);
                            break;
                        case 2:
                            System.out.print("Entrez la date d'expiration: ");
                            String dateExpiration = scanner.nextLine();
                            produit = new Alimentaire(id, nom, prix, dateExpiration);
                            break;
                        case 3:
                            System.out.print("Entrez la taille: ");
                            String taille = scanner.nextLine();
                            produit = new Vestimentaire(id, nom, prix, taille);
                            break;
                        default:
                            System.out.println("Type de produit invalide.");
                    }

                    if (produit != null) {
                        magasin.ajouterProduit(produit);
                    }
                    break;
                case 2:
                    System.out.print("Entrez l'id du produit à supprimer: ");
                    String idSupprimer = scanner.nextLine();
                    magasin.supprimerProduit(idSupprimer);
                    break;
                case 3:
                    System.out.print("Entrez l'id du produit à modifier: ");
                    String idModifier = scanner.nextLine();
                    System.out.print("Entrez le nouveau nom: ");
                    String nouveauNom = scanner.nextLine();
                    System.out.print("Entrez le nouveau prix: ");
                    double nouveauPrix = scanner.nextDouble();
                    magasin.modifierProduit(idModifier, nouveauNom, nouveauPrix);
                    break;
                case 4:
                    System.out.print("Entrez le nom du produit à rechercher: ");
                    String nomRechercher = scanner.nextLine();
                    magasin.rechercherProduitParNom(nomRechercher);
                    break;
                case 5:
                    System.out.print("Entrez la lettre: ");
                    char lettre = scanner.next().charAt(0);
                    magasin.listerProduitsParLettre(lettre);
                    break;
                case 6:
                    magasin.afficherNombreProduits();
                    break;
                case 7:
                    System.out.print("Entrez le prix maximum: ");
                    double prixMax = scanner.nextDouble();
                    magasin.afficherProduitsMoinsChersQue(prixMax);
                    break;
                case 8:
                    System.out.println("Catégorie de produit (1: Electronique, 2: Alimentaire, 3: Vestimentaire): ");
                    int categorie = scanner.nextInt();
                    Class<?> classeCategorie = null;
                    switch (categorie) {
                        case 1:
                            classeCategorie = Electronique.class;
                            break;
                        case 2:
                            classeCategorie = Alimentaire.class;
                            break;
                        case 3:
                            classeCategorie = Vestimentaire.class;
                            break;
                        default:
                            System.out.println("Catégorie invalide.");
                    }

                    if (classeCategorie != null) {
                        magasin.afficherProduitsParCategorie(classeCategorie);
                    }
                    break;
                case 9:
                    magasin.afficherTousProduits();
                    break;
                case 0:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Option invalide.");
            }
        }
    }
}
