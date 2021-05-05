/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.dto.FreeLancerDTO;
import t4j.app.service.FreeLancersService;

/**
 *
 * @author Home
 */
@Controller
public class UIFreeLancerController {

    @Autowired
    FreeLancersService freeLancersService;

    public UIFreeLancerController() {
    }

    public boolean especificarFreeLancer(FreeLancerDTO flto) {
        boolean result = freeLancersService.addFreeLancer(flto);
        return result;
    }
}
