package t4j.app.dto;

import java.time.LocalDate;

public class LocalDateDTO {

    /**
     * 
     */
    private LocalDate localDate;

    /**
     *
     */
    public LocalDateDTO() {
    }

    /**
     * 
     * @return 
     */
    public LocalDate getLocalDate() {
        return localDate;
    }

    /**
     * 
     * @param localDate 
     */
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return localDate.toString();
    }
}
