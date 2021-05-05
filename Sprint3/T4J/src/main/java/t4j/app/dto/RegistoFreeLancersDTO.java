/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;

/**
 *
 * @author Home
 */
@JacksonXmlRootElement(localName = "FreeLancers")
public class RegistoFreeLancersDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "freelancers")
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
