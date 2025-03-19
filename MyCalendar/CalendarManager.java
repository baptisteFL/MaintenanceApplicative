import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    public List<Event> events;

    public CalendarManager() {
        this.events = new ArrayList<>();
    }

    public void ajouterEvent(TypeEvenement type, TitreEvenement titre, ProprietaireEvenement proprietaire, DateEvenement dateDebut, DureeEvenement duree,
                             LieuEvenement lieu, ParticipantsEvenement participants, FrequenceJoursEvenement frequenceJours) {
        Event e = new Event(type, titre, proprietaire, dateDebut, duree, lieu, participants, frequenceJours);
        events.add(e);
    }

    public List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Event> result = new ArrayList<>();
        for (Event e : events) {
            if (e.getType().equals("PERIODIQUE")) {
                LocalDateTime temp = e.getDateDebut();
                while (temp.isBefore(fin)) {
                    if (!temp.isBefore(debut)) {
                        result.add(e);
                        break;
                    }
                    temp = temp.plusDays(e.getFrequenceJours());
                }
            } else if (!e.getDateDebut().isBefore(debut) && !e.getDateDebut().isAfter(fin)) {
                result.add(e);
            }
        }
        return result;
    }

    public boolean conflit(Event e1, Event e2) {
        LocalDateTime fin1 = e1.getDateDebut().plusMinutes(e1.getDuree());
        LocalDateTime fin2 = e2.getDateDebut().plusMinutes(e2.getDuree());

        if (e1.getType().equals("PERIODIQUE") || e2.getType().equals("PERIODIQUE")) {
            return false; // Simplification abusive
        }

        return e1.getDateDebut().isBefore(fin2) && fin1.isAfter(e2.getDateDebut());
    }

    public void afficherEvenements() {
        for (Event e : events) {
            System.out.println(e.description());
        }
    }
}