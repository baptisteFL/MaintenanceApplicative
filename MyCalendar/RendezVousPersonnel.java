import java.time.LocalDateTime;
import java.util.List;

public class RendezVousPersonnel extends Event {
    public RendezVousPersonnel(TitreEvenement titre, ProprietaireEvenement proprietaire, DateEvenement dateDebut, DureeEvenement duree) {
        super(titre, proprietaire, dateDebut, duree, new LieuEvenement(""), new ParticipantsEvenement(List.of()));
    }

    @Override
    public String description() {
        return getTitre() + " on " + getDateDebut();
    }

    @Override
    public boolean isConflicting(Event other) {
        LocalDateTime fin1 = getDateDebut().plusMinutes(getDuree());
        LocalDateTime fin2 = other.getDateDebut().plusMinutes(other.getDuree());
        return getDateDebut().isBefore(fin2) && fin1.isAfter(other.getDateDebut());
    }
}