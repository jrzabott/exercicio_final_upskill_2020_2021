package t4j.app.converter;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static t4j.app.converter.CategoriaTarefaConverter.categoriaTarefa2CategoriaTarefaDTO;
import t4j.app.dto.TarefaDTO;
import t4j.app.model.AreaAtividade;
import t4j.app.model.CaraterCompetenciaTecnica;
import t4j.app.model.CategoriaTarefa;
import t4j.app.model.CompetenciaTecnica;
import t4j.app.model.GrauProficiencia;
import t4j.app.model.Tarefa;

public class TarefaConverterTest {

    private Tarefa t;
    private TarefaDTO tdto;
    private CategoriaTarefa cat;
    private AreaAtividade areaAtividade;
    private CaraterCompetenciaTecnica cct;
    private CompetenciaTecnica ct;
    private GrauProficiencia gp;
    ArrayList<CaraterCompetenciaTecnica> listaCT;
    ArrayList<GrauProficiencia> listaGP;

    public TarefaConverterTest() {
        listaCT = new ArrayList<>();
        listaGP = new ArrayList<>();
        areaAtividade = new AreaAtividade("codigoAA", "descBreve", "descDetalhada");
        cct = new CaraterCompetenciaTecnica(1L, true, "true", ct, gp);
        cat = new CategoriaTarefa("descricao", areaAtividade, listaCT);
        ct = new CompetenciaTecnica("codigoCT", "descBreve", "descDetalhada", areaAtividade, listaGP);
        gp = new GrauProficiencia(1L, "valorGP", "designacaoGP");
        listaCT.add(cct);
        t = new Tarefa("t1", "designacao", "descInf", "descTec", "123", 12D, cat, "email@email.pt", "123456789");
        tdto = new TarefaDTO();
        tdto.setReferencia("t1");
        tdto.setDesignacao("designacao");
        tdto.setDescricaoInformal("descInf");
        tdto.setDescricaoTecnica("descTec");
        tdto.setDuracaoEstimada("123");
        tdto.setCustoEstimado("12");
        tdto.setCategoria(categoriaTarefa2CategoriaTarefaDTO(cat));
        tdto.setEmailColaborador("email@email.pt");
        tdto.setNifOrganizacao("123456789");

    }

// TODO - Converter Registo para ArrayList
//    /**
//     * Test of listTarefa2ListTarefaDTO method, of class TarefaConverter.
//     */
//    @Test
//    public void testListTarefa2ListTarefaDTO() {
//        System.out.println("listTarefa2ListTarefaDTO");
//        RegistoTarefasDTO result = TarefaConverter.listTarefa2ListTarefaDTO(tarefas);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of tarefa2TarefaDTO method, of class TarefaConverter.
     */
    @Test
    public void testTarefa2TarefaDTO() {
        System.out.println("tarefa2TarefaDTO");
        TarefaDTO result = TarefaConverter.tarefa2TarefaDTO(t);
        String expResult = "TarefaDTO{referencia=t1, designacao=designacao, descricaoInformal=descInf, descricaoTecnica=descTec, duracaoEstimada=123, custoEstimado=12, categoria=CategoriaTarefaDTO{idCategoria=0, descricao=descricao, areaAtividade=AreaAtividadeDTO{codigo=codigoAA, descBreve=descBreve, descDetalhada=descDetalhada}, caraterCompetenciaTecnica=[]}, colaborador=null, emailColaborador=email@email.pt, nifOrganizacao=123456789}";
        assertEquals(expResult, tdto.toString() );
    }

// TOTO - Corrigir
//    /**
//     * Test of tarefaDTO2Tarefa method, of class TarefaConverter.
//     */
//    @Test
//    public void testTarefaDTO2Tarefa() {
//        System.out.println("tarefaDTO2Tarefa");
//        Tarefa result = TarefaConverter.tarefaDTO2Tarefa(tdto);
//        assertEquals(t.toString(), result.toString());
//    }
}
