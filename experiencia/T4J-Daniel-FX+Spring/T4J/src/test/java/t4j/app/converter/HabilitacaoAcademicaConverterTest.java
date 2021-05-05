package t4j.app.converter;

import t4j.app.dto.HabilitacaoAcademicaDTO;
import t4j.app.model.HabilitacaoAcademica;

public class HabilitacaoAcademicaConverterTest {
    
    private HabilitacaoAcademica ha;
    private HabilitacaoAcademicaDTO hadto;
    
    public HabilitacaoAcademicaConverterTest() {
        ha = new HabilitacaoAcademica(1L, "grau", "designacaocurso", "nomeinstituicao", "mediacurso", "email@email.pt");
        hadto = new HabilitacaoAcademicaDTO();
        hadto.setId(1L);
        hadto.setGrau("grau");
        hadto.setDesignacaocurso("designacaocurso");
        hadto.setNomeinstituicao("nomeinstituicao");
        hadto.setMediacurso("mediacurso");
        hadto.setEmailFreelancer("email@email.pt");
    }
    
// TODO - Ver erro???????
//    /**
//     * Test of habilitacaoAcademica2HabilitacaoAcademicaDTO method, of class HabilitacaoAcademicaConverter.
//     */
//    @Test
//    public void testHabilitacaoAcademica2HabilitacaoAcademicaDTO() {
//        System.out.println("habilitacaoAcademica2HabilitacaoAcademicaDTO");
//        HabilitacaoAcademicaDTO result = HabilitacaoAcademicaConverter.habilitacaoAcademica2HabilitacaoAcademicaDTO(ha);
//        assertEquals(hadto.toString(), result.toString());
//    }
//
//    /**
//     * Test of habilitacaoAcademicaDTO2HabilitacaoAcademica method, of class HabilitacaoAcademicaConverter.
//     */
//    @Test
//    public void testHabilitacaoAcademicaDTO2HabilitacaoAcademica() {
//        System.out.println("habilitacaoAcademicaDTO2HabilitacaoAcademica");
//        HabilitacaoAcademica result = HabilitacaoAcademicaConverter.habilitacaoAcademicaDTO2HabilitacaoAcademica(hadto);
//        assertEquals(ha.toString(), result.toString());
//    }
}
