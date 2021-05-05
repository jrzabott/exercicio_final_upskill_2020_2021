/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import t4j.app.dao.CompetenciaTecnicaDAO;
import t4j.app.dao.FreeLancerDAO;
import t4j.app.dao.GrauProficienciaDAO;
import t4j.app.dao.HabilitacaoAcademicaDAO;
import t4j.app.dao.ReconhecimentoCTDAO;
import t4j.app.dto.FreeLancerDTO;
import t4j.app.dto.HabilitacaoAcademicaDTO;
import t4j.app.dto.Mapper;
import t4j.app.dto.ReconhecimentoCTDTO;
import t4j.app.dto.UserInfoDTO;
import t4j.app.model.FreeLancer;
import t4j.app.model.HabilitacaoAcademica;
import t4j.app.model.ReconhecimentoCT;
import t4j.app.repo.Roles;
import t4j.app.utils.AlgoritmoGeradorPasswords;

/**
 *
 * @author Home
 */
@Service
public class FreeLancersService {

    @Autowired
    UsersService usersService;
    @Autowired
    FreeLancerDAO freelancerDAO;
    @Autowired
    CompetenciaTecnicaDAO ctdao;
    @Autowired
    GrauProficienciaDAO gpdao;
    @Autowired
    ReconhecimentoCTDAO rctdao;

    @Autowired
    HabilitacaoAcademicaDAO habilitacaoAcademicaDAO;

    public FreeLancersService() {

    }

    @Transactional
    public boolean addFreeLancer(FreeLancerDTO flto) {
        boolean result = false;

        List<HabilitacaoAcademica> habilitacoes = new ArrayList();
        for (HabilitacaoAcademicaDTO hdto : flto.getHabilitacoes()) {
            HabilitacaoAcademica ha = Mapper.habilitacaoAcademicaDTO2HabilitacaoAcademica(hdto);
            ha.setEmailFreelancer(flto.getEmail());
            habilitacoes.add(ha);
        }

        List<ReconhecimentoCT> reconhecimentos = new ArrayList();
        for (ReconhecimentoCTDTO rctdto : flto.getReconhecimentos()) {
            ReconhecimentoCT rct = new ReconhecimentoCT();
            rct.setCodigoCompetenciaTecnica(rctdto.getCodigocompetenciatecnica());
            rct.setDataReconhecimento(rctdto.getDatareconhecimento());
            rct.setEmailFreelancer(flto.getEmail());
            rct.setIdGrauProficiencia(rctdto.getIdgrauproficiencia());

            reconhecimentos.add(rct);
        }

        FreeLancer freelancer = Mapper.freeLancerDTO2FreeLancer(flto);
        freelancer.setHabilitacoes(habilitacoes);
        freelancer = freelancerDAO.save(freelancer);
        habilitacoes = habilitacaoAcademicaDAO.saveAll(habilitacoes);
        reconhecimentos = rctdao.saveAll(reconhecimentos);

        result = freelancer != null;

        if (result) {
            freelancer = freelancerDAO.save(freelancer);

            UserInfoDTO u = Mapper.freeLancerDTO2UserInfoDTO(flto);
            u.setPassword(AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.MIX, 16));
            u.setRolenames(Roles.FREELANCER.name());

            result = usersService.addUtilizador(u);
        }
        return result;
    }

//
//       @Transactional
//    public boolean addHabilitacaoAcademica(HabilitacaoAcademicaDTO haDTO) {
//        boolean result = false;
//
//        HabilitacaoAcademica ha = Mapper.habilitacaoAcademicaDTO2HabilitacaoAcademica(haDTO);
//        if (ha == null) {
//            throw new ConversaoException("HabilitacaoAcademicaDTO");
//        }
//
//        HabilitacaoAcademica haInserida = habilitacaoAcademicaDAO.save(ha);
//        result = haInserida != null;
//        return result;
//    }
}
