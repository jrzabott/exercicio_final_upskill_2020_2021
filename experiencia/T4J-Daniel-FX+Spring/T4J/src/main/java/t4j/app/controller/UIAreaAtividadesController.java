package t4j.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.dto.AreaAtividadeDTO;
import t4j.app.dto.RegistoAreasAtividadesDTO;
import t4j.app.service.AreaAtividadeService;

@Controller
public class UIAreaAtividadesController {

    @Autowired
    private AreaAtividadeService aas;

    /**
     *
     * @param codigoAreaAtividade código da área de atividade a ser registada
     * @param descBreve descrição breve da área de atividade a ser registada
     * @param descDetalhada descrição detalhada da área de atividade a ser
     * registada
     * @return true se registo de uma nova área de atividade efetuado e false se
     * contrário
     */
//    public static boolean registarAreaAtividade(String codigoAreaAtividade, String descBreve, String descDetalhada) {
//        boolean result;
//        AreaAtividadeDTO aadto = new AreaAtividadeDTO();
//        aadto.setCodigo(codigoAreaAtividade);
//        aadto.setDescBreve(descBreve);
//        aadto.setDescDetalhada(descDetalhada);
//
//        result = AreaAtividadeService.addAreaAtividade(aadto);
//        return result;
//    }
    public boolean registarAreaAtividade(String codigoAreaAtividade, String descBreve, String descDetalhada) {
        boolean result;
        AreaAtividadeDTO aadto = new AreaAtividadeDTO();
        aadto.setCodigo(codigoAreaAtividade);
        aadto.setDescBreve(descBreve);
        aadto.setDescDetalhada(descDetalhada);

        result = aas.addAreaAtividade(aadto);
        return result;
    }

    public RegistoAreasAtividadesDTO obterAreasAtividades() {
        RegistoAreasAtividadesDTO raadto = aas.findAllAreasAtividades();
        return raadto;
    }

    public UIAreaAtividadesController() {

    }

}
