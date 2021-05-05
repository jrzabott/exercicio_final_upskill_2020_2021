package t4j.app.converter;

import java.time.LocalDate;
import java.util.ArrayList;
import static t4j.app.converter.LocalDateConverter.data2DataDTO;
import static t4j.app.converter.LocalDateConverter.dataDTO2Data;
import t4j.app.dto.LocalDateDTO;
import t4j.app.dto.ProcessoSeriacaoDTO;
import t4j.app.model.ProcessoSeriacao;

public class ProcessoSeriacaoConverter {
    
    /**
     * 
     * @param processoSeriacao
     * @return 
     */
    public static ProcessoSeriacaoDTO processoSeriacao2ProcessoSeriacaoDTO(ProcessoSeriacao processoSeriacao) {
        ProcessoSeriacaoDTO processoSeriacaoDTO = new ProcessoSeriacaoDTO();
        processoSeriacaoDTO.setId(processoSeriacao.getId());
        processoSeriacaoDTO.setReferenciaAnuncio(processoSeriacao.getReferenciaAnuncio());
        LocalDateDTO dataDTO = data2DataDTO(processoSeriacao.getDataRealizacao());
        processoSeriacaoDTO.setDataRealizacao(dataDTO);
        return processoSeriacaoDTO;
    }

    /**
     * 
     * @param processoSeriacaoDTO
     * @return 
     */
    public static ProcessoSeriacao processoSeriacaoDTO2ProcessoSeriacao(ProcessoSeriacaoDTO processoSeriacaoDTO) {
        ProcessoSeriacao processoSeriacao = new ProcessoSeriacao();
        processoSeriacao.setId(processoSeriacaoDTO.getId());
        processoSeriacao.setReferenciaAnuncio(processoSeriacaoDTO.getReferenciaAnuncio());
        LocalDate data = dataDTO2Data(processoSeriacaoDTO.getDataRealizacao());
        processoSeriacao.setDataRealizacao(data);
        return processoSeriacao;
    }

    /**
     * 
     * @param processosSeriacao
     * @return
     * @throws NullPointerException 
     */
    public static ArrayList<ProcessoSeriacaoDTO> listProcessoSeriacao2ListProcessoSeriacaoDTO(ArrayList<ProcessoSeriacao> processosSeriacao) throws NullPointerException {
        ArrayList<ProcessoSeriacaoDTO> processosSeriacaoDTO = new ArrayList<>();
        for (ProcessoSeriacao processoSeriacao : processosSeriacao) {
            try {
                ProcessoSeriacaoDTO psdto = processoSeriacao2ProcessoSeriacaoDTO(processoSeriacao);
                processosSeriacaoDTO.add(psdto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return processosSeriacaoDTO;
    }

    /**
     * 
     * @param processosSeriacaoDTO
     * @return
     * @throws NullPointerException 
     */
    public static ArrayList<ProcessoSeriacao> listProcessoSeriacaoDTO2ListProcessoSeriacao(ArrayList<ProcessoSeriacaoDTO> processosSeriacaoDTO) throws NullPointerException {
        ArrayList<ProcessoSeriacao> processosSeriacao = new ArrayList<>();
        for (ProcessoSeriacaoDTO processoSeriacaoDTO : processosSeriacaoDTO) {
            try {
                ProcessoSeriacao processoSeriacao = processoSeriacaoDTO2ProcessoSeriacao(processoSeriacaoDTO);
                processosSeriacao.add(processoSeriacao);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return processosSeriacao;
    }
}
