package events;

import java.util.List;

public class EvenementPeriodique extends Event {
    private final FrequenceJoursEvenement frequenceJours;

    public EvenementPeriodique(TitreEvenement titre, ProprietaireEvenement proprietaire, DateEvenement dateDebut, FrequenceJoursEvenement frequenceJours) {
        super(titre, proprietaire, dateDebut, new DureeEvenement(0), new LieuEvenement(""), new ParticipantsEvenement(List.of()));
        this.frequenceJours = frequenceJours;
    }

    @Override
    public String description() {
        return getTitre() + " every " + frequenceJours.getFrequenceJours() + " days";
    }

    @Override
    public boolean isConflicting(Event other) {
        return false; // Simplification for periodic events
    }

    public FrequenceJoursEvenement getFrequenceJours() {
        return frequenceJours;
    }
}