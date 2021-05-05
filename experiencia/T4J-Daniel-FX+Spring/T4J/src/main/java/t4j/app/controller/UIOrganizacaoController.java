package t4j.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.dto.OrganizacaoDTO;
import t4j.app.service.OrganizacoesService;
import t4j.app.ui.CreateOrganizacao;

@Controller
public class UIOrganizacaoController {

    @Autowired
    private OrganizacoesService os;
    @Autowired
    private CreateOrganizacao registarOrganizacaoController;

    public UIOrganizacaoController() {
    }

    /**
     *
     * @param odto organização a ser adicionada
     * @return true se registou uma nova organização e false se contrário
     */
    public boolean registarOrganizacao(OrganizacaoDTO odto) {
//        return OrganizacoesService.addOrganizacao(odto);
        return os.addOrganizacao(odto);
    }
}
