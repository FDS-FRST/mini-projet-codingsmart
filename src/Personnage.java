public class Personnage {

    // Attributs
    private String nom;
    private int vie;
    private int attaque;

    // Constructeur
    public Personnage(String nom, int vie, int attaque) {
        this.nom = nom;
        this.vie = vie;
        this.attaque = attaque;
    }

    // Méthode pour attaquer un autre personnage
    public void attaquer(Personnage cible) {
        if (!this.estVivant()) {
            System.out.println(this.nom + " est mort et ne peut pas attaquer !");
            return;
        }

        System.out.println(this.nom + " attaque " + cible.nom + " !");
        cible.vie -= this.attaque;

        if (cible.vie < 0) {
            cible.vie = 0;
        }

        System.out.println(cible.nom + " perd " + this.attaque + " points de vie.");
    }

    // Vérifie si le personnage est vivant
    public boolean estVivant() {
        return this.vie > 0;
    }

    // Affiche l'état du personnage
    public void afficherEtat() {
        System.out.println(this.nom + " - " + this.vie + " HP");
    }
}
