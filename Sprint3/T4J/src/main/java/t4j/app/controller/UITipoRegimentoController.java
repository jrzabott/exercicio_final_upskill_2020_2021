package t4j.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.dto.RegistoTiposRegimentoDTO;
import t4j.app.dto.TipoRegimentoDTO;
import t4j.app.service.TiposRegimentoService;

@Controller
public class UITipoRegimentoController {

    @Autowired
    private TiposRegimentoService trs;

    public UITipoRegimentoController() {
    }

    public boolean criarTipoRegimento(TipoRegimentoDTO trdto) {
        return trs.addTipoRegimento(trdto);
    }
    
    public RegistoTiposRegimentoDTO getRegistoTiposRegimentoDTO() {
        return trs.findAllTiposRegimento();
    }
}
