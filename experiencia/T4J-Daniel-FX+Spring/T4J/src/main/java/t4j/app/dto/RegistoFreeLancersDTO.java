package t4j.app.dto;

import java.util.ArrayList;

/**
 *
 * @author Home
 */
public class RegistoFreeLancersDTO {

    private ArrayList<FreeLancerDTO> freeLancers;

    public RegistoFreeLancersDTO() {
    }

    public ArrayList<FreeLancerDTO> getFreeLancers() {
        return this.freeLancers;
    }

    public void setFreeLancers(ArrayList<FreeLancerDTO> freeLancers) {
        this.freeLancers = freeLancers;
    }
}
