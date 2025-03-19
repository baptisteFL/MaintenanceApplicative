package events;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Event {
    private final TitreEvenement titre;
    private final ProprietaireEvenement proprietaire;
    private final DateEvenement dateDebut;
    private final DureeEvenement duree;
    private final LieuEvenement lieu;
    private final ParticipantsEvenement participants;

    public Event(TitreEvenement titre, ProprietaireEvenement proprietaire, DateEvenement dateDebut, DureeEvenement duree,
                 LieuEvenement lieu, ParticipantsEvenement participants) {
        this.titre = titre;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.duree = duree;
        this.lieu = lieu;
        this.participants = participants;
    }

    public String getTitre() {
        return titre.getTitre();
    }

    public String getProprietaire() {
        return proprietaire.getProprietaire();
    }

    public LocalDateTime getDateDebut() {
        return dateDebut.getDate();
    }

    public int getDuree() {
        return duree.getDureeMinutes();
    }

    public String getLieu() {
        return lieu.getLieu();
    }

    public List<String> getParticipants() {
        return participants.getParticipants();
    }

    public abstract String description();
    public abstract boolean isConflicting(Event other);
}