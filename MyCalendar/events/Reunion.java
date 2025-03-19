package events;

import java.time.LocalDateTime;

public class Reunion extends Event {
    public Reunion(TitreEvenement titre, ProprietaireEvenement proprietaire, DateEvenement dateDebut, DureeEvenement duree, LieuEvenement lieu, ParticipantsEvenement participants) {
        super(titre, proprietaire, dateDebut, duree, lieu, participants);
    }

    @Override
    public String description() {
        return getTitre() + " at " + getLieu() + " with " + getParticipants();
    }

    @Override
    public boolean isConflicting(Event other) {
        LocalDateTime fin1 = getDateDebut().plusMinutes(getDuree());
        LocalDateTime fin2 = other.getDateDebut().plusMinutes(other.getDuree());
        return getDateDebut().isBefore(fin2) && fin1.isAfter(other.getDateDebut());
    }
}