import java.util.Scanner;

public class Joueur {
    private String nom;
    private Personnage[] equipe; // Tableau contenant les 3 personnages du joueur

    // -------------------------------
    // Getters et Setters
    // -------------------------------
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Personnage[] getEquipe() {
        return this.equipe;
    }

    public void setEquipe(Personnage[] equipe) {
        this.equipe = equipe;
    }

    // -------------------------------
    // Méthodes principales
    // -------------------------------

    /**
     * Crée et initialise l'équipe du joueur.
     * Chaque joueur a 3 personnages avec vie = 100 et attaque = 20.
     * Les noms des personnages sont saisis par l'utilisateur.
     *
     * @param sc Scanner pour lire les entrées console
     */
    public void creerEquipe(Scanner sc) {
        equipe = new Personnage[3]; // Initialisation du tableau de personnages
        System.out.println(nom + ", crée ton équipe :");

        for (int i = 0; i < 3; i++) {
            System.out.print("Nom du personnage " + (i + 1) + " : ");
            String pNom = sc.nextLine();
            equipe[i] = new Personnage(pNom, 100, 20); // Création du personnage
        }
    }

    /**
     * Permet au joueur de choisir un personnage vivant dans son équipe.
     * La méthode vérifie que le choix est valide et que le personnage choisi est vivant.
     *
     * @param sc Scanner pour lire les entrées console
     * @param message Message affiché pour inviter le joueur à choisir
     * @return Le personnage choisi et vivant
     */
    public Personnage choisirPersonnageVivant(Scanner sc, String message) {
        int choix;
        do {
            System.out.print(message);
            choix = sc.nextInt();
            sc.nextLine(); // Consomme le retour à la ligne restant

            if (choix < 1 || choix > equipe.length) {
                System.out.println("Choix invalide !");
                continue;
            }

            if (!equipe[choix - 1].estVivant()) {
                System.out.println("Ce personnage est mort !");
            } else {
                break;
            }
        } while (true);

        return equipe[choix - 1];
    }

    /**
     * Vérifie si le joueur a encore au moins un personnage vivant.
     *
     * @return true si au moins un personnage est vivant, false sinon
     */
    public boolean aEncoreDesPersonnagesVivants() {
        for (Personnage p : equipe) {
            if (p.estVivant()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Affiche l'état de tous les personnages du joueur.
     * Affiche le numéro, le nom et les points de vie de chaque personnage.
     */
    public void afficherEquipe() {
        System.out.println("Équipe de " + nom + " :");
        for (int i = 0; i < equipe.length; i++) {
            System.out.print((i + 1) + ". ");
            equipe[i].afficherEtat();
        }
    }
}
