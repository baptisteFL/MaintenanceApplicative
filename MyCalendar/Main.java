import commands.*;
import events.CalendarManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalendarManager calendar = new CalendarManager();
        Scanner scanner = new Scanner(System.in);
        String utilisateur = null;
        boolean continuer = true;

        String[] utilisateurs = new String[99];
        String[] motsDePasses = new String[99];
        int nbUtilisateurs = 0;

        Map<String, Command> mainMenuCommands = new HashMap<>();
        mainMenuCommands.put("1", new SeConnecterCommand(scanner, utilisateurs, motsDePasses, nbUtilisateurs));
        mainMenuCommands.put("2", new CreerCompteCommand(scanner, utilisateurs, motsDePasses, nbUtilisateurs));

        while (true) {
            if (utilisateur == null) {
                System.out.println("  _____         _                   _                __  __");
                System.out.println(" / ____|       | |                 | |              |  \\/  |");
                System.out.println("| |       __ _ | |  ___  _ __    __| |  __ _  _ __  | \\  / |  __ _  _ __    __ _   __ _   ___  _ __");
                System.out.println("| |      / _` || | / _ \\| '_ \\  / _` | / _` || '__| | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__|");
                System.out.println("| |____ | (_| || ||  __/| | | || (_| || (_| || |    | |  | || (_| || | | || (_| || (_| ||  __/| |");
                System.out.println(" \\_____| \\__,_||_| \\___||_| |_| \\__,_| \\__,_||_|    |_|  |_| \\__,_||_| |_| \\__,_| \\__, | \\___||_|");
                System.out.println("                                                                                   __/ |");
                System.out.println("                                                                                  |___/");

                System.out.println("1 - Se connecter");
                System.out.println("2 - Créer un compte");
                System.out.println("Choix : ");

                String choix = scanner.nextLine();
                Command command = mainMenuCommands.get(choix);
                if (command != null) {
                    command.execute();
                    if (command instanceof SeConnecterCommand) {
                        utilisateur = ((SeConnecterCommand) command).getUtilisateur();
                    } else if (command instanceof CreerCompteCommand) {
                        utilisateur = ((CreerCompteCommand) command).getUtilisateur();
                        nbUtilisateurs = ((CreerCompteCommand) command).getNbUtilisateurs();
                    }
                }
            }

            while (continuer && utilisateur != null) {
                System.out.println("\nBonjour, " + utilisateur);
                System.out.println("=== Menu Gestionnaire d'Événements ===");
                System.out.println("1 - Voir les événements");
                System.out.println("2 - Ajouter un rendez-vous perso");
                System.out.println("3 - Ajouter une réunion");
                System.out.println("4 - Ajouter un évènement périodique");
                System.out.println("5 - Se déconnecter");
                System.out.print("Votre choix : ");

                String choix = scanner.nextLine();

                // Add event menu commands to the map
                Map<String, Command> eventMenuCommands = new HashMap<>();
                eventMenuCommands.put("1", new AfficherTousEvenementsCommand(calendar));
                eventMenuCommands.put("2", new AjouterRendezVousPersonnelCommand(calendar, scanner, utilisateur));
                // Add other commands similarly

                Command command = eventMenuCommands.get(choix);
                if (command != null) {
                    command.execute();
                } else {
                    System.out.println("Déconnexion ! Voulez-vous continuer ? (O/N)");
                    continuer = scanner.nextLine().trim().equalsIgnoreCase("oui");
                    utilisateur = null;
                }
            }
        }
    }
}