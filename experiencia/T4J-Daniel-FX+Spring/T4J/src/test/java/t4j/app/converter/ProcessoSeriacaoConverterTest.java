package t4j.app.converter;

import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import t4j.app.dto.ProcessoSeriacaoDTO;
import t4j.app.model.ProcessoSeriacao;

public class ProcessoSeriacaoConverterTest {
    
    private ProcessoSeriacao ps;
    private ProcessoSeriacaoDTO psdto;
    private ArrayList<ProcessoSeriacao> processosSeriacao;
    private ArrayList<ProcessoSeriacaoDTO> processosSeriacaoDTO;
    
    public ProcessoSeriacaoConverterTest() {
        processosSeriacao = new ArrayList<>();
        processosSeriacaoDTO = new ArrayList<>();
        ps = new ProcessoSeriacao(1L, LocalDate.MIN, "referenciaAnuncio");
        psdto = new ProcessoSeriacaoDTO();
        LocalDate dr = LocalDate.MIN;
        psdto.setId(1L);
        psdto.setDataRealizacao(LocalDateConverter.data2DataDTO(dr));
        psdto.setReferenciaAnuncio("referenciaAnuncio");
        processosSeriacao.add(ps);
        processosSeriacaoDTO.add(psdto);
    }

    /**
     * Test of processoSeriacao2ProcessoSeriacaoDTO method, of class ProcessoSeriacaoConverter.
     */
    @Test
    public void testProcessoSeriacao2ProcessoSeriacaoDTO() {
        System.out.println("processoSeriacao2ProcessoSeriacaoDTO");
        ProcessoSeriacaoDTO result = ProcessoSeriacaoConverter.processoSeriacao2ProcessoSeriacaoDTO(ps);
        assertEquals(psdto.toString(), result.toString());
    }

    /**
     * Test of processoSeriacaoDTO2ProcessoSeriacao method, of class ProcessoSeriacaoConverter.
     */
    @Test
    public void testProcessoSeriacaoDTO2ProcessoSeriacao() {
        System.out.println("processoSeriacaoDTO2ProcessoSeriacao");
        ProcessoSeriacao result = ProcessoSeriacaoConverter.processoSeriacaoDTO2ProcessoSeriacao(psdto);
        assertEquals(ps.toString(), result.toString());
    }

    /**
     * Test of listProcessoSeriacao2ListProcessoSeriacaoDTO method, of class ProcessoSeriacaoConverter.
     */
    @Test
    public void testListProcessoSeriacao2ListProcessoSeriacaoDTO() {
        System.out.println("listProcessoSeriacao2ListProcessoSeriacaoDTO");
        ArrayList<ProcessoSeriacaoDTO> result = ProcessoSeriacaoConverter.listProcessoSeriacao2ListProcessoSeriacaoDTO(processosSeriacao);
        assertEquals(processosSeriacaoDTO.contains(psdto.toString()), result.contains(psdto.toString()));
    }

    /**
     * Test of listProcessoSeriacaoDTO2ListProcessoSeriacao method, of class ProcessoSeriacaoConverter.
     */
    @Test
    public void testListProcessoSeriacaoDTO2ListProcessoSeriacao() {
        System.out.println("listProcessoSeriacaoDTO2ListProcessoSeriacao");
        ArrayList<ProcessoSeriacao> result = ProcessoSeriacaoConverter.listProcessoSeriacaoDTO2ListProcessoSeriacao(processosSeriacaoDTO);
        assertEquals(processosSeriacao.contains(ps.toString()), result.contains(ps.toString()));
    }
}
