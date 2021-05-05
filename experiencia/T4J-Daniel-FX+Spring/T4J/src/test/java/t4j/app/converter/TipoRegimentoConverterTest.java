package t4j.app.converter;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import t4j.app.dto.TipoRegimentoDTO;
import t4j.app.model.TipoRegimento;

public class TipoRegimentoConverterTest {
    
    private TipoRegimento tp;
    private TipoRegimentoDTO tpdto;
    private ArrayList<TipoRegimento> tiposRegimento;
    private ArrayList<TipoRegimentoDTO> tiposRegimentoDTO;
    
    public TipoRegimentoConverterTest() {
        tiposRegimento = new ArrayList<>();
        tiposRegimentoDTO = new ArrayList<>();
        tp = new TipoRegimento("designacao", "descricaoRegras");
        tpdto = new TipoRegimentoDTO();
        tpdto.setDesignacao("designacao");
        tpdto.setDescricaoRegras("descricaoRegras");
        tiposRegimento.add(tp);
        tiposRegimentoDTO.add(tpdto);
    }

    /**
     * Test of tipoRegimento2TipoRegimentoDTO method, of class TipoRegimentoConverter.
     */
    @Test
    public void testTipoRegimento2TipoRegimentoDTO() {
        System.out.println("tipoRegimento2TipoRegimentoDTO");
        TipoRegimentoDTO result = TipoRegimentoConverter.tipoRegimento2TipoRegimentoDTO(tp);
        assertEquals(tpdto.toString(), result.toString());
    }

    /**
     * Test of tipoRegimentoDTO2TipoRegimento method, of class TipoRegimentoConverter.
     */
    @Test
    public void testTipoRegimentoDTO2TipoRegimento() {
        System.out.println("tipoRegimentoDTO2TipoRegimento");
        TipoRegimento result = TipoRegimentoConverter.tipoRegimentoDTO2TipoRegimento(tpdto);
        assertEquals(tp.toString(), result.toString());
    }
    
// TODO - Converter Registo para ArrayList
//    /**
//     * Test of listTiposRegimento2ListTiposRegimentoDTO method, of class TipoRegimentoConverter.
//     */
//    @Test
//    public void testListTiposRegimento2ListTiposRegimentoDTO() {
//        System.out.println("listTiposRegimento2ListTiposRegimentoDTO");
//        RegistoTiposRegimentoDTO result = TipoRegimentoConverter.listTiposRegimento2ListTiposRegimentoDTO(tiposRegimento);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of listTiposRegimentoDTO2ListTipoRegimento method, of class TipoRegimentoConverter.
     */
    @Test
    public void testListTiposRegimentoDTO2ListTipoRegimento() {
        System.out.println("listTiposRegimentoDTO2ListTipoRegimento");
        ArrayList<TipoRegimento> result = TipoRegimentoConverter.listTiposRegimentoDTO2ListTipoRegimento(tiposRegimentoDTO);
        assertEquals(tiposRegimento.contains(tp.toString()), result.contains(tp.toString()));
    }
}
