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
    }
}
