package commands;

import events.*;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AjouterRendezVousPersonnelCommand implements Command
{
    private final CalendarManager calendar;
    private final Scanner scanner;
    private final String utilisateur;

    public AjouterRendezVousPersonnelCommand(CalendarManager calendar, Scanner scanner, String utilisateur) {
        this.calendar = calendar;
        this.scanner = scanner;
        this.utilisateur = utilisateur;
    }

    @Override
    public void execute() {
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int moisRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jourRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());
        System.out.print("Durée (en minutes) : ");
        int duree = Integer.parseInt(scanner.nextLine());

        calendar.ajouterEvent(new RendezVousPersonnel(
                new TitreEvenement(titre),
                new ProprietaireEvenement(utilisateur),
                new DateEvenement(LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute)),
                new DureeEvenement(duree)
        ));

        System.out.println("Événement ajouté.");
    }
}