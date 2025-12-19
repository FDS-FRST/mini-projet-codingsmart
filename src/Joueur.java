import java.util.Scanner;

public class Joueur {
    private String nom;
    private Personnage[] equipe; // tableau pour 3 personnages

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

    public void creerEquipe(Scanner sc) {
        equipe = new Personnage[3]; // initialisation du tableau
        System.out.println(nom + ", crée ton équipe :");

        for (int i = 0; i < 3; i++) {
            System.out.print("Nom du personnage " + (i + 1) + " : ");
            String pNom = sc.nextLine();
            equipe[i] = new Personnage(pNom, 100, 20); // vie = 100, attaque = 20
        }
    }


}