package t4j.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.dto.ColaboradorDTO;
import t4j.app.dto.RegistoOrganizacoesDTO;
import t4j.app.service.ColaboradoresService;
import t4j.app.service.OrganizacoesService;

@Controller
public class UIColaboradorController {

    /**
     *
     */
    @Autowired
    ColaboradoresService colaboradoresService;

    /**
     *
     */
    public UIColaboradorController() {
    }


    /**
     *
     * @param cdto
     * @return
     */
    public boolean especificarColaborador(ColaboradorDTO cdto) {
        boolean result = colaboradoresService.addColaborador(cdto);
        return result;
    }
}
