package t4j.app.converter;

import java.util.ArrayList;
import t4j.app.dto.TipoRegimentoDTO;
import t4j.app.model.TipoRegimento;

public class TipoRegimentoConverter {
    
    /**
     * 
     * @param tipoRegimento
     * @return 
     */
    public static TipoRegimentoDTO tipoRegimento2TipoRegimentoDTO(TipoRegimento tipoRegimento) {
        TipoRegimentoDTO tipoRegimentodto = new TipoRegimentoDTO();
        tipoRegimentodto.setId(tipoRegimento.getId());
        tipoRegimentodto.setDesignacao(tipoRegimento.getDesignacao());
        tipoRegimentodto.setDescricaoRegras(tipoRegimento.getDescricaoRegras());
        return tipoRegimentodto;
    }

    /**
     * 
     * @param tipoRegimentoDTO
     * @return 
     */
    public static TipoRegimento tipoRegimentoDTO2TipoRegimento(TipoRegimentoDTO tipoRegimentoDTO) {
        TipoRegimento tipoRegimento = new TipoRegimento();
        tipoRegimento.setId(tipoRegimentoDTO.getId());
        tipoRegimento.setDesignacao(tipoRegimentoDTO.getDesignacao());
        tipoRegimento.setDescricaoRegras(tipoRegimentoDTO.getDescricaoRegras());
        return tipoRegimento;
    }

    /**
     * 
     * @param tiposRegimento
     * @return
     * @throws NullPointerException 
     */
    public static ArrayList<TipoRegimentoDTO> listTiposRegimento2ListTiposRegimentoDTO(ArrayList<TipoRegimento> tiposRegimento) throws NullPointerException {
        ArrayList<TipoRegimentoDTO> tiposRegimentoDTO = new ArrayList<>();
        for (TipoRegimento tipoRegimento : tiposRegimento) {
            try {
                TipoRegimentoDTO trdto = tipoRegimento2TipoRegimentoDTO(tipoRegimento);
                tiposRegimentoDTO.add(trdto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return tiposRegimentoDTO;
    }

    /**
     * 
     * @param tiposRegimentoDTO
     * @return
     * @throws NullPointerException 
     */
    public static ArrayList<TipoRegimento> listTiposRegimentoDTO2ListTipoRegimento(ArrayList<TipoRegimentoDTO> tiposRegimentoDTO) throws NullPointerException {
        ArrayList<TipoRegimento> tiposRegimento = new ArrayList<>();
        for (TipoRegimentoDTO tipoRegimentoDTO : tiposRegimentoDTO) {
            try {
                TipoRegimento tipoRegimento = tipoRegimentoDTO2TipoRegimento(tipoRegimentoDTO);
                tiposRegimento.add(tipoRegimento);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return tiposRegimento;
    }
}
