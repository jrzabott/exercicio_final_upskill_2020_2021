/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import t4j.app.dao.CaraterCompetenciaTecnicaDAO;
import t4j.app.dao.CategoriaTarefaDAO;
import t4j.app.dao.CompetenciaTecnicaDAO;
import t4j.app.dao.GrauProficienciaDAO;
import t4j.app.dto.CaraterCompetenciaTecnicaDTO;
import t4j.app.dto.CategoriaTarefaDTO;
import t4j.app.dto.Mapper;
import t4j.app.dto.RegistoCategoriasDTO;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.model.CaraterCompetenciaTecnica;
import t4j.app.model.CategoriaTarefa;
import t4j.app.model.CompetenciaTecnica;
import t4j.app.model.GrauProficiencia;

/**
 *
 * @author user
 */
@Service
public class CategoriaTarefasService {

    @Autowired
    CategoriaTarefaDAO categoriaTarefaDAO;
    @Autowired
    CaraterCompetenciaTecnicaDAO caraterCompetenciaTecnicaDAO;
    @Autowired
    GrauProficienciaDAO grauProficienciaDAO;
    @Autowired
    CompetenciaTecnicaDAO competenciaTecnicaDAO;

    public CategoriaTarefasService() {
    }

// TODO - Implementar getMaxId e colocar no controller
    @Transactional
    public Long addCategoriaTarefa(CategoriaTarefaDTO ctdto) {
        Boolean result = false;

        //////////////////////////////////////////////////
        // Não faço uso da versão convertida via DTO.
        // Entretando, ao usar o Mapper, garanto as
        // validações de classe.
        //////////////////////////////////////////////////
        CategoriaTarefa categoriaTarefa = Mapper.categoriaDTO2Categoria(ctdto);

        try {

            List<CaraterCompetenciaTecnica> list = new ArrayList();
            for (CaraterCompetenciaTecnicaDTO cctdto : ctdto.getCaraterCompetenciaTecnica()) {
                CaraterCompetenciaTecnica cct = new CaraterCompetenciaTecnica();

                ////////////////////////////////////////////////////////////////////////////////////
                // Grau de proficiência, precisa ser convertido corretamente para inserção no CCT
                ////////////////////////////////////////////////////////////////////////////////////
                GrauProficiencia gp = new GrauProficiencia();
                gp = Mapper.grauDTO2Grau(cctdto.getGrauProficiencia());
                Optional<GrauProficiencia> gpOptional = Optional.ofNullable(gp);
                if (gpOptional.isPresent() && gpOptional.get().getId() != null) {
                    gpOptional = grauProficienciaDAO.findById(gp.getId());
                    gp = gpOptional.get();
                } else {
                    gp = null;
                }
                cct.setGrauProficiencia(gp);
                // FIM GRAU PROFICIENCIA ///////////////////////////////////////////////////////////

                ////////////////////////////////////////////////////////////////////////////////////
                // O mesmo ocorre com as CompTec: precisam ser convertidas corretamente para
                // inserção no CCT.
                ////////////////////////////////////////////////////////////////////////////////////
                CompetenciaTecnica ct = new CompetenciaTecnica();
                ct = Mapper.competenciaTecnicaDTO2CompetenciaTecnica(cctdto.getCompetenciaTecnica());
                Optional<CompetenciaTecnica> ctOptional = Optional.ofNullable(ct);
                if (ct.getCodigoCompetenciaTecnica() != null && !ct.getCodigoCompetenciaTecnica().isEmpty()) {
                    ctOptional = competenciaTecnicaDAO.findById(ct.getCodigoCompetenciaTecnica());
                }
                if (ctOptional.isPresent()) {
                    cct.setCompetenciaTecnica(ctOptional.get());
                }
                // FIM COMPETENCIA TECNICA /////////////////////////////////////////////////////////

                ////////////////////////////////////////////////////////////////////////////////////
                // Refletir o carater obrigatórios de uma competencia técnica.
                ////////////////////////////////////////////////////////////////////////////////////
                cct.setObrigatorio(cctdto.isObrigatorio());
                list.add(cct);
            }

            ////////////////////////////////////////////////////////////////////////////////////
            // Para os CTs obrigatórios, deve haver um Grau de Profic Minimo selecionado.
            ////////////////////////////////////////////////////////////////////////////////////
            for (CaraterCompetenciaTecnica cct : list) {
                if (cct.isObrigatorio() && (cct.getGrauProficiencia() == null)) {
                    throw new ElementoInvalidoException("Ao selectionar uma CT como obrigatória, deve selecionar um grau mínimo de proficiência para esta CT.");
                }
            }

            ////////////////////////////////////////////////////////////////////////////////////
            // Salvar todos os CaratersCT em Batch...
            ////////////////////////////////////////////////////////////////////////////////////
            list = caraterCompetenciaTecnicaDAO.saveAll((Iterable) list);

            ////////////////////////////////////////////////////////////////////////////////////
            // Montar então a CategTarefa com os valores recém-inseridos...
            ////////////////////////////////////////////////////////////////////////////////////
            categoriaTarefa = new CategoriaTarefa();
            categoriaTarefa.setAreaAtividade(Mapper.areaAtividadeDTO2AreaAtividade(ctdto.getAreaAtividade()));
            categoriaTarefa.setDescricaoCategoria(ctdto.getDescricao());
            categoriaTarefa.setListaCaraterCompetenciaTecnica((ArrayList<CaraterCompetenciaTecnica>) list);

            ////////////////////////////////////////////////////////////////////////////////////
            // Enfim, inserir na tabela a categoria.
            ////////////////////////////////////////////////////////////////////////////////////
            categoriaTarefa = categoriaTarefaDAO.save(categoriaTarefa);

            return categoriaTarefa.getIdCategoria();
        } catch (Exception e) {
            throw new ElementoInvalidoException("CategoriaTarefaDTO\n" + e.getMessage());
        }
    }

    public RegistoCategoriasDTO getRegistoCategorias() {
        RegistoCategoriasDTO rcdto = new RegistoCategoriasDTO();
        List<CategoriaTarefaDTO> listDTO = new ArrayList();

        List<CategoriaTarefa> list = categoriaTarefaDAO.findAll();
        for (CategoriaTarefa categoriaTarefa : list) {
            CategoriaTarefaDTO ctdto = Mapper.categoria2CategoriaDTO(categoriaTarefa);
            if (ctdto != null) {
                listDTO.add(ctdto);
            }
        }

        rcdto.setCategorias((ArrayList<CategoriaTarefaDTO>) listDTO);
        return rcdto;

    }

}
