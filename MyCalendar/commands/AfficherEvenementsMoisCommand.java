package commands;

import events.CalendarManager;
import events.Event;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class AfficherEvenementsMoisCommand implements Command
{
    private final CalendarManager calendar;
    private final Scanner scanner;

    public AfficherEvenementsMoisCommand(CalendarManager calendar, Scanner scanner) {
        this.calendar = calendar;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeMois = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int mois = Integer.parseInt(scanner.nextLine());

        LocalDateTime debutMois = LocalDateTime.of(anneeMois, mois, 1, 0, 0);
        LocalDateTime finMois = debutMois.plusMonths(1).minusSeconds(1);

        afficherListe(calendar.eventsDansPeriode(debutMois, finMois));
    }

    private void afficherListe(List<Event> evenements) {
        if (evenements.isEmpty()) {
            System.out.println("Aucun événement trouvé pour cette période.");
        } else {
            System.out.println("Événements trouvés : ");
            for (Event e : evenements) {
                System.out.println("- " + e.description());
            }
        }
    }
}