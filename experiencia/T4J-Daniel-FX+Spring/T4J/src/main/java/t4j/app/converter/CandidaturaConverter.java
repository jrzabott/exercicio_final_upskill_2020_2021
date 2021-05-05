package t4j.app.converter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static t4j.app.converter.LocalDateConverter.data2DataDTO;
import static t4j.app.converter.LocalDateConverter.dataDTO2Data;
import t4j.app.dto.CandidaturaDTO;
import t4j.app.dto.LocalDateDTO;
import t4j.app.model.Candidatura;

public class CandidaturaConverter {
    
    /**
     * 
     * @param cd
     * @return 
     */
    public static CandidaturaDTO candidatura2CandidaturaDTO(Candidatura cd) {
        CandidaturaDTO cddto = new CandidaturaDTO();
        LocalDateDTO dataCandidaturaDTO = data2DataDTO(cd.getDataCandidatura());
        cddto.setId(String.valueOf(cd.getId()));
        cddto.setDataCandidatura(dataCandidaturaDTO);
        cddto.setValorPretendido(cd.getValorPretendido().toString());
        cddto.setNrDias(cd.getNrDias());
        cddto.setTxtApresentacao(cd.getTxtApresentacao());
        cddto.setTxtMotivacao(cd.getTxtMotivacao());
        cddto.setRefAnuncio(cd.getRefAnuncio());
        cddto.setEmailFreelancer(cd.getEmailFreelancer());
        cddto.setClassificacao((cd.getClassificacao() == null) ? null : String.valueOf(cd.getClassificacao()));
        cddto.setEmailColaboradorClassificou(cd.getEmailColaboradorClassificou());
        return cddto;
    }

    /**
     * 
     * @param cddto
     * @return 
     */
    public static Candidatura candidaturaDTO2Candidatura(CandidaturaDTO cddto) {
        Candidatura cd = new Candidatura();
        LocalDate dataCandidatura = dataDTO2Data(cddto.getDataCandidatura());
        if (cddto.getId() != null) {
            cd.setId(Long.valueOf(cddto.getId()));
        }
        cd.setDataCandidatura(dataCandidatura);
        cd.setValorPretendido((cddto.getValorPretendido() == null) ? null : String.valueOf(cddto.getValorPretendido()));
        cd.setNrDias(cddto.getNrDias());
        cd.setTxtApresentacao(cddto.getTxtApresentacao());
        cd.setTxtMotivacao(cddto.getTxtMotivacao());
        cd.setRefAnuncio(cddto.getRefAnuncio());
        cd.setEmailFreelancer(cddto.getEmailFreelancer());
        cd.setClassificacao((cddto.getClassificacao()==null ? null : Integer.parseInt(cddto.getClassificacao())));
        cd.setEmailColaboradorClassificou(cddto.getEmailColaboradorClassificou());
        return cd;
    }

    /**
     * 
     * @param candidaturas
     * @return
     * @throws NullPointerException 
     */
    public static List<CandidaturaDTO> listCandidaturas2ListCandidaturasDTO(List<Candidatura> candidaturas) throws NullPointerException {
        List<CandidaturaDTO> candidaturasDTO = new ArrayList<>();
        for (Candidatura candidatura : candidaturas) {
            try {
                CandidaturaDTO cdto = candidatura2CandidaturaDTO(candidatura);
                candidaturasDTO.add(cdto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return candidaturasDTO;
    }
    
    /**
     * 
     * @param candidaturasDTO
     * @return
     * @throws NullPointerException 
     */
    public static ArrayList<Candidatura> listCandidaturasDTO2ListCandidaturas(ArrayList<CandidaturaDTO> candidaturasDTO) throws NullPointerException {
        ArrayList<Candidatura> candidaturas = new ArrayList<>();
        for (CandidaturaDTO candidaturaDTO : candidaturasDTO) {
            try {
                Candidatura c = candidaturaDTO2Candidatura(candidaturaDTO);
                candidaturas.add(c);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return candidaturas;
    }
}
