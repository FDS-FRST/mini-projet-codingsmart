import java.util.Scanner;

public class Jeu {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenue dans le Jeu de Combat !\n");

        // ----- Phase 1 : Création des joueurs -----
        System.out.print("Joueur 1, entre ton nom : ");
        Joueur j1 = new Joueur();
        j1.setNom(sc.nextLine());

        System.out.print("Joueur 2, entre ton nom : ");
        Joueur j2 = new Joueur();
        j2.setNom(sc.nextLine());

        // Création des équipes
        j1.creerEquipe(sc);
        System.out.println();
        j2.creerEquipe(sc);

        int tour = 1;

        // ----- Phase 2 : Boucle de combat -----
        while (j1.aEncoreDesPersonnagesVivants() && j2.aEncoreDesPersonnagesVivants()) {

            System.out.println("\n--- TOUR " + tour + " ---");

            // Tour du joueur 1
            System.out.println("\n" + j1.getNom() + " attaque !");
            j1.afficherEquipe();
            Personnage attaquant1 = j1.choisirPersonnageVivant(sc, "Choisis ton attaquant (1-3) : ");

            j2.afficherEquipe();
            Personnage cible1 = j2.choisirPersonnageVivant(sc, "Choisis une cible (1-3) : ");

            attaquant1.attaquer(cible1);

            // Vérification si le joueur 2 a perdu
            if (!j2.aEncoreDesPersonnagesVivants()) break;

            // Tour du joueur 2
            System.out.println("\n" + j2.getNom() + " attaque !");
            j2.afficherEquipe();
            Personnage attaquant2 = j2.choisirPersonnageVivant(sc, "Choisis ton attaquant (1-3) : ");

            j1.afficherEquipe();
            Personnage cible2 = j1.choisirPersonnageVivant(sc, "Choisis une cible (1-3) : ");

            attaquant2.attaquer(cible2);

            tour++;
        }

        // ----- Fin du jeu -----
        System.out.println("\n===== FIN DU JEU =====");

        if (j1.aEncoreDesPersonnagesVivants()) {
            System.out.println("Victoire de " + j1.getNom() + " ! Tous les personnages de " + j2.getNom() + " sont éliminés.");
        } else {
            System.out.println("Victoire de " + j2.getNom() + " ! Tous les personnages de " + j1.getNom() + " sont éliminés.");
        }

        sc.close();
    }
}
