package t4j.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import t4j.app.dao.TipoRegimentoDAO;
import t4j.app.dto.Mapper;
import t4j.app.dto.RegistoTiposRegimentoDTO;
import t4j.app.dto.TipoRegimentoDTO;
import t4j.app.exception.ConversaoException;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.model.Plataforma;
import t4j.app.model.RegistoTiposRegimento;
import t4j.app.model.TipoRegimento;
import t4j.app.repo.Dados;

@Service
public class TiposRegimentoService {

    @Autowired
    TipoRegimentoDAO tipoRegimentoDAO;
    
    public TiposRegimentoService(){
    }
    
    /**
     * 
     * @return o registo de tipos de regimento
     */
    public RegistoTiposRegimentoDTO findAllTiposRegimento() {
        RegistoTiposRegimentoDTO rtrdto = new RegistoTiposRegimentoDTO();
        List<TipoRegimento> tiposRegimento = new ArrayList<>();
        for (TipoRegimento tipoRegimento : tipoRegimentoDAO.findAll()) {
            tiposRegimento.add(tipoRegimento);
        }
        rtrdto = Mapper.registoTiposRegimento2RegistoTiposRegimentoDTO((ArrayList<TipoRegimento>) tiposRegimento);
        return rtrdto;
    }
    
    /**
     * 
     * @param designacao designação do tipo de regimento que se pretende obter
     * @return o tipo de regimento identificado pela sua designação
     */
    public TipoRegimentoDTO getTipoRegimentoByDesignacao(String designacao) {
        TipoRegimentoDTO trdto = new TipoRegimentoDTO();
        TipoRegimento tipoRegimento = PlataformaService.getPlataforma().getRegistoTiposRegimento().getTipoRegimentoByDesignacao(designacao);
        trdto = Mapper.tipoRegimento2TipoRegimentoDTO(tipoRegimento);
        return trdto;
    }
    
    /**
     * 
     * @return o registo de tipos de regimento
     */
    public static RegistoTiposRegimentoDTO getRegistoTiposRegimento() {
        RegistoTiposRegimentoDTO rtpdto;
        Plataforma plataforma = Dados.carregarDados();
        RegistoTiposRegimento rtp = plataforma.getRegistoTiposRegimento();
        ArrayList<TipoRegimento> tiposRegimento = rtp.getTiposRegimento();
        rtpdto = Mapper.registoTiposRegimento2RegistoTiposRegimentoDTO(tiposRegimento);
        return rtpdto;
    }
    
    /**
     * 
     * @param designacao designação do tipo de regimento que se pretende obter
     * @return o tipo de regimento identificado pela sua designação
     */
    public static TipoRegimentoDTO getTipoRegimento(String designacao) {
        Plataforma plataforma = Dados.carregarDados();
        TipoRegimento tipoRegimento = plataforma.getRegistoTiposRegimento().getTipoRegimentoByDesignacao(designacao);
        if (tipoRegimento == null) {
            return null;
        }
        TipoRegimentoDTO tipoRegimentoDTODTO = Mapper.tipoRegimento2TipoRegimentoDTO(tipoRegimento);
        if (tipoRegimentoDTODTO != null) {
            return tipoRegimentoDTODTO;
        } else {
            throw new ConversaoException("TipoRegimentoDTO");
        }
    }
    
    /**
     * 
     * @param tipoRegimentoDTO tipo de regimento a ser adicionado
     * @return true se adicionou um novo tipo de regimento passado por parâmetro e false se contrário
     */
    @Transactional
    public boolean addTipoRegimento(TipoRegimentoDTO tipoRegimentoDTO) {
        boolean result = false;
        TipoRegimento tipoRegimento = Mapper.tipoRegimentoDTO2TipoRegimento(tipoRegimentoDTO);
        if (tipoRegimento == null) {
            throw new ConversaoException("TipoRegimentoDTO");
        }
        
        Optional<TipoRegimento> tipoRegimentoDB = tipoRegimentoDAO.findByDesignacao(tipoRegimento.getDesignacao());
        if (tipoRegimentoDB.isPresent()) {
            throw new ElementoDuplicadoException("Tipo de Regimento já existe.");
        }
        tipoRegimento = tipoRegimentoDAO.save(tipoRegimento);

        return tipoRegimento != null;
    }
    
    /**
     * 
     * @param designacao designação do tipo de regimento a ser atualizado
     * @param tipoRegimentoDTO tipo de regimento identificado pela sua designação a ser atuualizado
     */
    public static void updateTipoRegimento(String designacao, TipoRegimentoDTO tipoRegimentoDTO){

        TipoRegimento tipoRegimento = Mapper.tipoRegimentoDTO2TipoRegimento(tipoRegimentoDTO);
        Plataforma plataforma = Dados.carregarDados();
        if (tipoRegimento != null) {
            plataforma.getRegistoTiposRegimento().updateTipoRegimento(designacao, tipoRegimento);
            Dados.guardarDados(plataforma);
        } else {
            throw new ConversaoException("TipoRegimentoDTO");
        }
    }
    
    /**
     * 
     * @param designacao designação do tipo de regimento a ser removido
     */
    public static void removeTipoRegimento(String designacao) {
        Plataforma plataforma = Dados.carregarDados();
        plataforma.getRegistoTiposRegimento().removeTipoRegimento(designacao);
        Dados.guardarDados(plataforma);
    }
}
