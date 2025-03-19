import java.util.List;

public class ParticipantsEvenement {
    private final List<String> participants;

    public ParticipantsEvenement(List<String> participants) {
        this.participants = participants;
    }

    public List<String> getParticipants() {
        return participants;
    }
}