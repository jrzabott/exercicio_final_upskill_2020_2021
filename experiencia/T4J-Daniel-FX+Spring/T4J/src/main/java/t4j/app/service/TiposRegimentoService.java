package t4j.app.service;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static t4j.app.converter.TipoRegimentoConverter.listTiposRegimento2ListTiposRegimentoDTO;
import static t4j.app.converter.TipoRegimentoConverter.tipoRegimentoDTO2TipoRegimento;
import t4j.app.dao.TipoRegimentoDAO;
import t4j.app.dto.TipoRegimentoDTO;
import t4j.app.exception.ConversaoException;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.model.TipoRegimento;

@Service
public class TiposRegimentoService {

    /**
     *
     */
    @Autowired
    TipoRegimentoDAO tipoRegimentoDAO;

    /**
     *
     */
    public TiposRegimentoService() {
    }

    /**
     *
     * @return o registo de tipos de regimento
     */
    public ArrayList<TipoRegimentoDTO> findAllTiposRegimento() {
        ArrayList<TipoRegimentoDTO> listatrdto = new ArrayList<>();
        ArrayList<TipoRegimento> tiposRegimento = new ArrayList<>();
        for (TipoRegimento tipoRegimento : tipoRegimentoDAO.findAll()) {
            tiposRegimento.add(tipoRegimento);
        }
        listatrdto = listTiposRegimento2ListTiposRegimentoDTO((ArrayList<TipoRegimento>) tiposRegimento);
        return listatrdto;
    }

    /**
     *
     * @param tipoRegimentoDTO tipo de regimento a ser adicionado
     * @return true se adicionou um novo tipo de regimento passado por parâmetro e false se contrário
     */
    @Transactional
    public boolean addTipoRegimento(TipoRegimentoDTO tipoRegimentoDTO) {
        boolean result = false;
        TipoRegimento tipoRegimento = tipoRegimentoDTO2TipoRegimento(tipoRegimentoDTO);
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
}
