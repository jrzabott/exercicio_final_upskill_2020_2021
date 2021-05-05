package t4j.app.converter;

import t4j.app.dto.ReconhecimentoCTDTO;
import t4j.app.model.ReconhecimentoCT;

public class ReconhecimentoCTConverter {

    /**
     *
     * @param reconhecimentoCT
     * @return
     * @throws NullPointerException
     */
    public static ReconhecimentoCTDTO reconhecimentoCT2ReconhecimentoCTDTO(ReconhecimentoCT reconhecimentoCT) throws NullPointerException {
        ReconhecimentoCTDTO reconhecimentoCTDTO = new ReconhecimentoCTDTO();
        reconhecimentoCTDTO.setId(Long.toString(reconhecimentoCT.getId()));
        reconhecimentoCTDTO.setCodigocompetenciatecnica(reconhecimentoCT.getCodigocompetenciatecnica());
        reconhecimentoCTDTO.setEmailfreelancer(reconhecimentoCT.getEmailfreelancer());
        reconhecimentoCTDTO.setIdgrauproficiencia(reconhecimentoCT.getIdgrauproficiencia());
        reconhecimentoCTDTO.setDatareconhecimento(reconhecimentoCT.getDatareconhecimento());
        return reconhecimentoCTDTO;
    }

    /**
     *
     * @param rctDTO
     * @return
     * @throws NullPointerException
     */
    public static ReconhecimentoCT reconhecimentoCTDTO2ReconhecimentoCT(ReconhecimentoCTDTO rctDTO) throws NullPointerException {
        ReconhecimentoCT rct = new ReconhecimentoCT();
        rct.setCodigoCompetenciaTecnica(rctDTO.getCodigocompetenciatecnica());
        rct.setDataReconhecimento(rctDTO.getDatareconhecimento());
        rct.setEmailFreelancer(rctDTO.getEmailfreelancer());
        rct.setIdGrauProficiencia(rctDTO.getIdgrauproficiencia());
        rct.setId(Long.parseLong(rctDTO.getId()));
        return rct;
    }
}
