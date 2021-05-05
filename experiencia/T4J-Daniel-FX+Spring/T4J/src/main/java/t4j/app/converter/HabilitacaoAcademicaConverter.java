package t4j.app.converter;

import t4j.app.dto.HabilitacaoAcademicaDTO;
import t4j.app.model.HabilitacaoAcademica;

public class HabilitacaoAcademicaConverter {

    /**
     *
     * @param habilitacaoAcademica
     * @return
     * @throws NullPointerException
     */
    public static HabilitacaoAcademicaDTO habilitacaoAcademica2HabilitacaoAcademicaDTO(HabilitacaoAcademica habilitacaoAcademica) throws NullPointerException {
        HabilitacaoAcademicaDTO habilitacaoAcademicaDTO = new HabilitacaoAcademicaDTO();
        habilitacaoAcademicaDTO.setId(habilitacaoAcademica.getId());
        habilitacaoAcademicaDTO.setGrau(habilitacaoAcademica.getGrau());
        habilitacaoAcademicaDTO.setDesignacaocurso(habilitacaoAcademica.getDesignacaocurso());
        habilitacaoAcademicaDTO.setNomeinstituicao(habilitacaoAcademica.getNomeinstituicao());
        habilitacaoAcademicaDTO.setMediacurso(habilitacaoAcademica.getMediacurso());
        habilitacaoAcademicaDTO.setEmailFreelancer(habilitacaoAcademica.getEmailFreelancer());
        return habilitacaoAcademicaDTO;
    }

    /**
     *
     * @param haDTO
     * @return
     * @throws NullPointerException
     */
    public static HabilitacaoAcademica habilitacaoAcademicaDTO2HabilitacaoAcademica(HabilitacaoAcademicaDTO haDTO) throws NullPointerException {
        HabilitacaoAcademica ha = new HabilitacaoAcademica();
        ha.setDesignacaoCurso(haDTO.getDesignacaocurso());
        ha.setGrau(haDTO.getGrau());
        ha.setMediaCurso(haDTO.getMediacurso());
        ha.setNomeInstituicao(haDTO.getNomeinstituicao());
        ha.setEmailFreelancer(haDTO.getEmailFreelancer());
        ha.setId((haDTO.getId() == null) ? null : haDTO.getId());
        return ha;
    }
}
