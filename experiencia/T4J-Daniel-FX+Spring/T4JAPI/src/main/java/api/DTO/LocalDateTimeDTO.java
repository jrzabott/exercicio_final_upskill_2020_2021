package api.DTO;

import java.time.LocalDateTime;

public class LocalDateTimeDTO {

    private LocalDateTime localDateTime;

    public LocalDateTimeDTO() {
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return localDateTime.toString();
    }
}
