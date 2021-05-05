package t4j.app.converter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import t4j.app.dto.AnuncioDTO;
import t4j.app.model.Anuncio;

public class AnuncioConverterTest {
    
    private Anuncio a;
    private AnuncioDTO adto;
    private ArrayList<Anuncio> anuncios;
    private ArrayList<AnuncioDTO> anunciosDTO;
    
    public AnuncioConverterTest() {
        anuncios = new ArrayList<>();
        anunciosDTO = new ArrayList<>();
        a = new Anuncio("a1", LocalDate.MIN, LocalDate.MIN, LocalDate.MIN, LocalDate.MIN, LocalDate.MIN, LocalDate.MIN, 1L);
        adto = new AnuncioDTO();
        LocalDate ra = LocalDate.now();
        LocalDate ip = LocalDate.MIN;
        LocalDate fp = LocalDate.MIN;
        LocalDate ic = LocalDate.MIN;
        LocalDate fc = LocalDate.MIN;
        LocalDate is = LocalDate.MIN;
        LocalDate fs = LocalDate.MIN;
        adto.setReferenciaTarefa("a1");
        adto.setDataRegistoAnuncio(LocalDateConverter.data2DataDTO(ra));
        adto.setDataInicioPublicitacao(LocalDateConverter.data2DataDTO(ip));
        adto.setDataFimPublicitacao(LocalDateConverter.data2DataDTO(fp));
        adto.setDataInicioCandidatura(LocalDateConverter.data2DataDTO(ic));
        adto.setDataFimCandidatura(LocalDateConverter.data2DataDTO(fc));
        adto.setDataInicioSeriacao(LocalDateConverter.data2DataDTO(is));
        adto.setDataFimSeriacao(LocalDateConverter.data2DataDTO(fs));
        adto.setIdTipoRegimento(1L);
        anuncios.add(a);
        anunciosDTO.add(adto);
    }

    /**
     * Test of anuncio2AnuncioDTO method, of class AnuncioConverter.
     */
    @Test
    public void testAnuncio2AnuncioDTO() {
        System.out.println("anuncio2AnuncioDTO");
        AnuncioDTO result = AnuncioConverter.anuncio2AnuncioDTO(a);
        assertEquals(adto.toString(), result.toString());
    }

    /**
     * Test of anuncioDTO2Anuncio method, of class AnuncioConverter.
     */
    @Test
    public void testAnuncioDTO2Anuncio() {
        System.out.println("anuncioDTO2Anuncio");
        Anuncio result = AnuncioConverter.anuncioDTO2Anuncio(adto);
        assertEquals(a.toString(), result.toString());
    }

    /**
     * Test of listAnuncios2ListAnunciosDTO method, of class AnuncioConverter.
     */
    @Test
    public void testListAnuncios2ListAnunciosDTO() {
        System.out.println("listAnuncios2ListAnunciosDTO");
        List<AnuncioDTO> result = AnuncioConverter.listAnuncios2ListAnunciosDTO(anuncios);
        assertEquals(anunciosDTO.contains(adto.toString()), result.contains(adto.toString()));
    }

    /**
     * Test of listAnunciosDTO2ListAnuncios method, of class AnuncioConverter.
     */
    @Test
    public void testListAnunciosDTO2ListAnuncios() {
        System.out.println("listAnunciosDTO2ListAnuncios");
        ArrayList<Anuncio> result = AnuncioConverter.listAnunciosDTO2ListAnuncios(anunciosDTO);
        assertEquals(anuncios.contains(a.toString()), result.contains(a.toString()));
    }
}
