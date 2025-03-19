import java.time.LocalDateTime;
import java.util.List;

public class Event {
    private final TypeEvenement type;
    private final TitreEvenement titre;
    private final ProprietaireEvenement proprietaire;
    private final DateEvenement dateDebut;
    private final DureeEvenement duree;
    private final LieuEvenement lieu;
    private final ParticipantsEvenement participants;
    private final FrequenceJoursEvenement frequenceJours;

    public Event(TypeEvenement type, TitreEvenement titre, ProprietaireEvenement proprietaire, DateEvenement dateDebut, DureeEvenement duree,
                 LieuEvenement lieu, ParticipantsEvenement participants, FrequenceJoursEvenement frequenceJours) {
        this.type = type;
        this.titre = titre;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.duree = duree;
        this.lieu = lieu;
        this.participants = participants;
        this.frequenceJours = frequenceJours;
    }

    public String getType() {
        return type.getType();
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

    public int getFrequenceJours() {
        return frequenceJours.getFrequenceJours();
    }

    public String description() {
        return switch (type.getType())
        {
            case "RDV_PERSONNEL" -> "RDV : " + titre.getTitre() + " à " + dateDebut.getDate();
            case "REUNION" -> "Réunion : " + titre.getTitre() + " à " + lieu.getLieu() + " avec " + participants.getParticipants();
            case "PERIODIQUE" ->
                    "Événement périodique : " + titre.getTitre() + " tous les " + frequenceJours.getFrequenceJours() + " jours";
            default -> "";
        };
    }
}