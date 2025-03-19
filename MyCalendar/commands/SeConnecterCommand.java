package commands;

import java.util.Scanner;

public class SeConnecterCommand implements Command
{
    private final Scanner scanner;
    private final String[] utilisateurs;
    private final String[] motsDePasses;
    private final int nbUtilisateurs;
    private String utilisateur;

    public SeConnecterCommand(Scanner scanner, String[] utilisateurs, String[] motsDePasses, int nbUtilisateurs) {
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

        for (int i = 0; i < nbUtilisateurs; i++) {
            if (utilisateurs[i].equals(utilisateur) && motsDePasses[i].equals(motDePasse)) {
                utilisateur = utilisateurs[i];
                break;
            }
        }
    }

    public String getUtilisateur() {
        return utilisateur;
    }
}