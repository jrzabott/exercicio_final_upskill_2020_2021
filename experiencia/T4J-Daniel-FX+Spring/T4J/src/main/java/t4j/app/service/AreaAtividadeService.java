package t4j.app.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static t4j.app.converter.AreaAtividadeConverter.areaAtividadeDTO2AreaAtividade;
import t4j.app.dao.AreaAtividadeDAO;
import t4j.app.dto.AreaAtividadeDTO;
import t4j.app.dto.RegistoAreasAtividadesDTO;
import t4j.app.model.AreaAtividade;
import static t4j.app.converter.AreaAtividadeConverter.listAtividade2ListAreaAtividadeDTO;

@Service
public class AreaAtividadeService {

    /**
     *
     */
    @Autowired
    AreaAtividadeDAO areaAtividadeDAO;

    /**
     *
     */
    public AreaAtividadeService() {
    }

    /**
     *
     * @return
     */
    public RegistoAreasAtividadesDTO findAllAreasAtividades() {
        RegistoAreasAtividadesDTO raadto = new RegistoAreasAtividadesDTO();
        List<AreaAtividade> areaAtividades = new ArrayList<>();
        for (AreaAtividade areaAtividade : areaAtividadeDAO.findAll()) {
            areaAtividades.add(areaAtividade);
        }
        raadto = listAtividade2ListAreaAtividadeDTO((ArrayList<AreaAtividade>) areaAtividades);

        return raadto;
    }

    /**
     *
     * @param areaDTO área de atividade a ser adicionada
     * @return true se adicionou uma nova área de atividade passada por parâmetro e false se contrário
     */
    public boolean addAreaAtividade(AreaAtividadeDTO areaDTO) {
        AreaAtividade area = areaAtividadeDTO2AreaAtividade(areaDTO);
        AreaAtividade aaInserida = areaAtividadeDAO.save(area);
        boolean result = aaInserida != null;
        return result;
    }
}
