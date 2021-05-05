package t4j.app.converter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static t4j.app.converter.LocalDateConverter.data2DataDTO;
import static t4j.app.converter.LocalDateConverter.dataDTO2Data;
import t4j.app.dto.AnuncioDTO;
import t4j.app.dto.LocalDateDTO;
import t4j.app.model.Anuncio;

public class AnuncioConverter {
    
    /**
     * 
     * @param anuncio
     * @return
     * @throws NullPointerException 
     */
    public static AnuncioDTO anuncio2AnuncioDTO(Anuncio anuncio) throws NullPointerException {
        AnuncioDTO anunciodto = new AnuncioDTO();
        anunciodto.setReferenciaTarefa(anuncio.getReferencia());
        LocalDateDTO datadtoRa = data2DataDTO(anuncio.getDataRegistoAnuncio());
        LocalDateDTO datadtoIp = data2DataDTO(anuncio.getDataInicioPublicitacao());
        LocalDateDTO datadtoFp = data2DataDTO(anuncio.getDataFimPublicitacao());
        LocalDateDTO datadtoIc = data2DataDTO(anuncio.getDataInicioCandidatura());
        LocalDateDTO datadtoFc = data2DataDTO(anuncio.getDataFimCandidatura());
        LocalDateDTO datadtoIs = data2DataDTO(anuncio.getDataInicioSeriacao());
        LocalDateDTO datadtoFs = data2DataDTO(anuncio.getDataFimSeriacao());
        anunciodto.setDataRegistoAnuncio(datadtoRa);
        anunciodto.setDataInicioPublicitacao(datadtoIp);
        anunciodto.setDataFimPublicitacao(datadtoFp);
        anunciodto.setDataInicioCandidatura(datadtoIc);
        anunciodto.setDataFimCandidatura(datadtoFc);
        anunciodto.setDataInicioSeriacao(datadtoIs);
        anunciodto.setDataFimSeriacao(datadtoFs);
        anunciodto.setIdTipoRegimento(anuncio.getIdTipoRegimento());
        return anunciodto;
    }

    /**
     * 
     * @param anuncioDTO
     * @return
     * @throws NullPointerException 
     */
    public static Anuncio anuncioDTO2Anuncio(AnuncioDTO anuncioDTO) throws NullPointerException {
        Anuncio anuncio = new Anuncio();
        anuncio.setReferencia(anuncioDTO.getReferenciaTarefa());
        LocalDate dataRa = dataDTO2Data(anuncioDTO.getDataRegistoAnuncio());
        LocalDate dataIp = dataDTO2Data(anuncioDTO.getDataInicioPublicitacao());
        LocalDate dataFp = dataDTO2Data(anuncioDTO.getDataFimPublicitacao());
        LocalDate dataIc = dataDTO2Data(anuncioDTO.getDataInicioCandidatura());
        LocalDate dataFc = dataDTO2Data(anuncioDTO.getDataFimCandidatura());
        LocalDate dataIs = dataDTO2Data(anuncioDTO.getDataInicioSeriacao());
        LocalDate dataFs = dataDTO2Data(anuncioDTO.getDataFimSeriacao());
        anuncio.setDataRegistoAnuncio(dataRa);
        anuncio.setDataInicioPublicitacao(dataIp);
        anuncio.setDataFimPublicitacao(dataFp);
        anuncio.setDataInicioCandidatura(dataIc);
        anuncio.setDataFimCandidatura(dataFc);
        anuncio.setDataInicioSeriacao(dataIs);
        anuncio.setDataFimSeriacao(dataFs);
        anuncio.setIdTipoRegimento(anuncioDTO.getIdTipoRegimento());
        return anuncio;
    }

    /**
     * 
     * @param anuncios
     * @return
     * @throws NullPointerException 
     */
    public static List<AnuncioDTO> listAnuncios2ListAnunciosDTO(List<Anuncio> anuncios) throws NullPointerException {
        List<AnuncioDTO> anunciosDTO = new ArrayList<>();
        for (Anuncio anuncio : anuncios) {
            try {
                AnuncioDTO adto = anuncio2AnuncioDTO(anuncio);
                anunciosDTO.add(adto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return anunciosDTO;
    }

    /**
     * 
     * @param anunciosDTO
     * @return
     * @throws NullPointerException 
     */
    public static ArrayList<Anuncio> listAnunciosDTO2ListAnuncios(ArrayList<AnuncioDTO> anunciosDTO) throws NullPointerException {
        ArrayList<Anuncio> anuncios = new ArrayList<>();
        for (AnuncioDTO anuncioDTO : anunciosDTO) {
            try {
                Anuncio anuncio = anuncioDTO2Anuncio(anuncioDTO);
                anuncios.add(anuncio);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return anuncios;
    }
}
