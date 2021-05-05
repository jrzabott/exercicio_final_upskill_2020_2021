package t4j.app.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    
    public ArrayList<TipoRegimentoDTO> getRegistoTiposRegimentoDTO() {
        return trs.findAllTiposRegimento();
    }
}
