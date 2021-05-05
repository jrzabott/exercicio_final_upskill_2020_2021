package t4j.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import t4j.app.dao.CompetenciaTecnicaDAO;
import t4j.app.dto.CompetenciaTecnicaDTO;
import t4j.app.dto.GrauProficienciaDTO;
import t4j.app.dto.Mapper;
import t4j.app.dto.RegistoCompetenciasTecnicasDTO;
import t4j.app.exception.ConversaoException;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.model.CompetenciaTecnica;
import t4j.app.model.GrauProficiencia;
import t4j.app.model.Plataforma;
import t4j.app.model.RegistoCompetenciasTecnicas;
import t4j.app.repo.Dados;

@Service
public class CompetenciasTecnicasService {

    @Autowired
    CompetenciaTecnicaDAO competenciaTecnicaDAO;

    public CompetenciasTecnicasService() {
    }

    /**
     *
     * @param ctDTO competência técnica a ser adicionada
     * @return true se adicionou uma nova competência técnica passada por
     * parâmetro e false se contrário
     */
    @Transactional
    public boolean addCompetenciaTecnica(CompetenciaTecnicaDTO ctDTO) {
        boolean result = false;

        CompetenciaTecnica ct = Mapper.competenciaTecnicaDTO2CompetenciaTecnica(ctDTO);
        if (ct == null) {
            throw new ConversaoException("CompetenciaTecnicaDTO");
        }
        Optional<CompetenciaTecnica> findById = competenciaTecnicaDAO.findById(ct.getCodigoCompetenciaTecnica());
        if (findById.isPresent()) {
            throw new ElementoDuplicadoException(ct.getCodigoCompetenciaTecnica()
                    + ": Já existe uma competência técnica com este código."
            );
        }
        CompetenciaTecnica ctInserida = competenciaTecnicaDAO.save(ct);
        result = ctInserida != null;
        return result;
    }

    /**
     *
     * @return o registo de competências técnicas
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public RegistoCompetenciasTecnicasDTO getRegistoCompetenciasTecnicas() {
        RegistoCompetenciasTecnicasDTO rctDTO = new RegistoCompetenciasTecnicasDTO();
        List<CompetenciaTecnica> competenciaTecnicas;

        competenciaTecnicas = competenciaTecnicaDAO.findAll();

        RegistoCompetenciasTecnicas rct = new RegistoCompetenciasTecnicas();
        competenciaTecnicas.forEach(rct::addCompetenciaTecnica);

        List<CompetenciaTecnica> listaCT;
        listaCT = rct.getCompetenciasTecnicas();
        rctDTO = Mapper.listCompetenciasTecnicas2CompetenciasTecnicasDTO(
                (ArrayList<CompetenciaTecnica>) listaCT
        );
        return rctDTO;
    }

    /**
     *
     * @param codCT código de competência técnica que se pretende
     * @return uma competência técnica identificada pelo seu código de
     * competência técnica
     */
    public static CompetenciaTecnicaDTO getCompetenciaTecnica(String codCT) {
        Plataforma plataforma = Dados.carregarDados();
        CompetenciaTecnica ct = plataforma.getRegistoCompetenciasTecnicas()
                .getCompetenciaTecnicaByCodigoCompetenciaTecnica(codCT);
        if (ct == null) {
            return null;
        }
        CompetenciaTecnicaDTO ctDTO = Mapper.competenciaTecnica2CompetenciaTecnicaDTO(ct);
        if (ctDTO != null) {
            return ctDTO;
        } else {
            throw new ConversaoException("CompetenciaTecnicaDTO");
        }
    }

    /**
     *
     * @param codCT código da competência técnica qe se pretende atualizar
     * @param ctDTO competência técnica identificada pelo seu código de
     * competência técnica a ser atualizada
     */
    public static void updateCompetenciaTecnica(String codCT, CompetenciaTecnicaDTO ctDTO) {
        CompetenciaTecnica ct = Mapper.competenciaTecnicaDTO2CompetenciaTecnica(ctDTO);
        if (ct != null) {
            Plataforma plataforma = Dados.carregarDados();
            plataforma.getRegistoCompetenciasTecnicas().updateCompetenciaTecnica(codCT, ct);
            Dados.guardarDados(plataforma);
        } else {
            throw new ConversaoException("CompetenciaTecnicaDTO");
        }
    }

    /**
     *
     * @param codCT código da competência técnica que se pretende remover
     */
    public static void removeCompetenciaTecnica(String codCT) {
        Plataforma plataforma = Dados.carregarDados();
        plataforma.getRegistoCompetenciasTecnicas().removeCompetenciaTecnica(codCT);
        Dados.guardarDados(plataforma);
    }

    /**
     *
     * @param grauDTO grau de proficiência que se pretende adicionar à
     * competência técnica passada por parâmetro
     * @param ctDTO competência técnica à qual se pretende adicionar uum grau de
     * proficiência
     * @return true se adicionou um novo grau de proficiência a uma competência
     * técnica DTO passada por parâmetro e false se contrário
     */
    public static boolean addGrauProficiencia(GrauProficienciaDTO grauDTO,
            CompetenciaTecnicaDTO ctDTO) {
        Plataforma plataforma = Dados.carregarDados();
        CompetenciaTecnica ct = Mapper.competenciaTecnicaDTO2CompetenciaTecnica(ctDTO);
        GrauProficiencia grau = Mapper.grauDTO2Grau(grauDTO);
        boolean result = ct.addGrauProficiencia(grau);
        Dados.guardarDados(plataforma);
        return result;
    }
   public List<String> getAllCompetenciasTecnicasIDs(){
       List<String> result = new ArrayList<>();
       result = competenciaTecnicaDAO.getAllCompetenciasTecnicasIDs();
       return result;
   }
}
