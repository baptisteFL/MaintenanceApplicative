import java.util.Scanner;

public class CreerCompteCommand implements Command {
    private final Scanner scanner;
    private final String[] utilisateurs;
    private final String[] motsDePasses;
    private int nbUtilisateurs;
    private String utilisateur;

    public CreerCompteCommand(Scanner scanner, String[] utilisateurs, String[] motsDePasses, int nbUtilisateurs) {
        this.scanner = scanner;
        this.utilisateurs = utilisateurs;
        this.motsDePasses = motsDePasses;
        this.nbUtilisateurs = nbUtilisateurs;
    }

    @Override
    public void execute() {
        System.out.print("Nom d'utilisateur: ");
        utilisateur = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();
        System.out.print("Répéter mot de passe: ");
        if (scanner.nextLine().equals(motDePasse)) {
            utilisateurs[nbUtilisateurs] = utilisateur;
            motsDePasses[nbUtilisateurs] = motDePasse;
            nbUtilisateurs++;
        } else {
            System.out.println("Les mots de passes ne correspondent pas...");
            utilisateur = null;
        }
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public int getNbUtilisateurs() {
        return nbUtilisateurs;
    }
}