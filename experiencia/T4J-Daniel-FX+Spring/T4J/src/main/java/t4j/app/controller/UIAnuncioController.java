package t4j.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.dto.AnuncioDTO;
import t4j.app.service.AnunciosService;

@Controller
public class UIAnuncioController {

    @Autowired
    private AnunciosService as;
    
    public UIAnuncioController(){
    }
    
    /**
     * 
     * @param adto anúncio a ser adicionado
     * @return adicionado um novo anúncio
     */
    public boolean publicarTarefa(AnuncioDTO adto) {
        return as.addAnuncio(adto);
    }
}
