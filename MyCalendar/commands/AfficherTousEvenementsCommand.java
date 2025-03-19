package commands;

import events.CalendarManager;

public class AfficherTousEvenementsCommand implements Command
{
    private final CalendarManager calendar;

    public AfficherTousEvenementsCommand(CalendarManager calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute() {
        calendar.afficherEvenements();
    }
}