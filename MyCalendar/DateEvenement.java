import java.time.LocalDateTime;

public class DateEvenement {
    private final LocalDateTime date;

    public DateEvenement(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }
}