import java.util.ArrayList;
import java.util.List;

public class ParticipantsEvenement {
    private final List<ParticipantEvenement> participants;

    public ParticipantsEvenement(List<ParticipantEvenement> participants) {
        this.participants = participants;
    }

    public List<String> getParticipants() {
        List<String> result = new ArrayList<>();
        for (ParticipantEvenement p : participants) {
            result.add(p.getParticipant());
        }
        return result;
    }
}