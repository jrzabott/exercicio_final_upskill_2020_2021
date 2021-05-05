package t4j.app.converter;

import java.util.ArrayList;
import t4j.app.dto.AreaAtividadeDTO;
import t4j.app.dto.RegistoAreasAtividadesDTO;
import t4j.app.model.AreaAtividade;

public class AreaAtividadeConverter {
    
    /**
     *
     * @param atividades
     * @return
     * @throws NullPointerException
     */
    public static RegistoAreasAtividadesDTO listAtividade2ListAreaAtividadeDTO(ArrayList<AreaAtividade> atividades) throws NullPointerException {
        ArrayList<AreaAtividadeDTO> atividadesDTO = new ArrayList<>();
        for (AreaAtividade org : atividades) {
            try {
                AreaAtividadeDTO aadto = areaAtividade2AreaAtividadeDTO(org);
                atividadesDTO.add(aadto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        RegistoAreasAtividadesDTO raadto = new RegistoAreasAtividadesDTO();
        raadto.setAtividades(atividadesDTO);
        return raadto;
    }

    /**
     *
     * @param areaAtividade
     * @return
     */
    public static AreaAtividadeDTO areaAtividade2AreaAtividadeDTO(AreaAtividade areaAtividade) {
        AreaAtividadeDTO areaDTO = new AreaAtividadeDTO();
        areaDTO.setCodigo(areaAtividade.getCodigoAreaAtividade());
        areaDTO.setDescBreve(areaAtividade.getDescricaoBreve());
        areaDTO.setDescDetalhada(areaAtividade.getDescricaoDetalhada());
        return areaDTO;
    }

    /**
     *
     * @param areaAtividadeDTO
     * @return
     */
    public static AreaAtividade areaAtividadeDTO2AreaAtividade(AreaAtividadeDTO areaAtividadeDTO) {
        AreaAtividade area = new AreaAtividade();
        area.setCodigoAreaAtividade(areaAtividadeDTO.getCodigo());
        area.setDescricaoBreve(areaAtividadeDTO.getDescBreve());
        area.setDescricaoDetalhada(areaAtividadeDTO.getDescDetalhada());
        return area;
    }
}
