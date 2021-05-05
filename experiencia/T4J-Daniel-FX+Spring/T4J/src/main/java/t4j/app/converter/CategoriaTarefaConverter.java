package t4j.app.converter;

import java.util.ArrayList;
import static t4j.app.converter.AreaAtividadeConverter.areaAtividade2AreaAtividadeDTO;
import static t4j.app.converter.AreaAtividadeConverter.areaAtividadeDTO2AreaAtividade;
import static t4j.app.converter.CaraterCTConverter.caraterCT2CaraterCTDTO;
import t4j.app.dto.AreaAtividadeDTO;
import t4j.app.dto.CaraterCompetenciaTecnicaDTO;
import t4j.app.dto.CategoriaTarefaDTO;
import t4j.app.dto.RegistoCategoriasDTO;
import t4j.app.model.AreaAtividade;
import t4j.app.model.CaraterCompetenciaTecnica;
import t4j.app.model.CategoriaTarefa;
import static t4j.app.converter.CaraterCTConverter.listCaraterCTDTO2ListCaraterCT;

public class CategoriaTarefaConverter {

    /**
     *
     * @param categorias
     * @return
     * @throws NullPointerException
     */
    public static RegistoCategoriasDTO listCategoriaTarefa2ListCategoriaTarefaDTO(ArrayList<CategoriaTarefa> categorias) throws NullPointerException {
        ArrayList<CategoriaTarefaDTO> categoriasDTO = new ArrayList<>();
        for (CategoriaTarefa org : categorias) {
            try {
                CategoriaTarefaDTO cdto = categoriaTarefa2CategoriaTarefaDTO(org);
                categoriasDTO.add(cdto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        RegistoCategoriasDTO rcdto = new RegistoCategoriasDTO();
        rcdto.setCategorias(categoriasDTO);
        return rcdto;
    }

    /**
     *
     * @param categoria
     * @return
     * @throws NullPointerException
     */
    public static CategoriaTarefaDTO categoriaTarefa2CategoriaTarefaDTO(CategoriaTarefa categoria) throws NullPointerException {
        CategoriaTarefaDTO categoriaDTO = new CategoriaTarefaDTO();
        categoriaDTO.setIdCategoria(String.valueOf(categoria.getIdCategoria()));
        categoriaDTO.setDescricao(categoria.getDescricaoCategoria());
        AreaAtividadeDTO areaAtividadeDTO = areaAtividade2AreaAtividadeDTO(categoria.getAreaAtividade());
        categoriaDTO.setAreaAtividade(areaAtividadeDTO);
        ArrayList<CaraterCompetenciaTecnicaDTO> cctdtos = new ArrayList<>();
        for (CaraterCompetenciaTecnica caraterCompetenciaTecnica : categoria.getListaCaraterCompetenciaTecnica()) {
            CaraterCompetenciaTecnicaDTO cctdto = caraterCT2CaraterCTDTO(caraterCompetenciaTecnica);
            cctdtos.add(cctdto);
        }
        categoriaDTO.setCaraterCompetenciaTecnica(cctdtos);
        return categoriaDTO;
    }

    /**
     * 
     * @param categoriaDTO
     * @return
     * @throws NullPointerException 
     */
    public static CategoriaTarefa categoriaTarefaDTO2CategoriaTarefa(CategoriaTarefaDTO categoriaDTO) throws NullPointerException {
        CategoriaTarefa categoria = new CategoriaTarefa();
        AreaAtividade areaAtividade = areaAtividadeDTO2AreaAtividade(categoriaDTO.getAreaAtividade());
        ArrayList<CaraterCompetenciaTecnica> cts = listCaraterCTDTO2ListCaraterCT(categoriaDTO.getCaraterCompetenciaTecnica());
        categoria.setAreaAtividade(areaAtividade);
        categoria.setIdCategoria((categoriaDTO.getIdCategoria() != null && !categoriaDTO.getIdCategoria().isEmpty())
                ? Long.parseLong(categoriaDTO.getIdCategoria())
                : null);
        categoria.setDescricaoCategoria(categoriaDTO.getDescricao());
        categoria.setListaCaraterCompetenciaTecnica(cts);
        return categoria;
    }
}
