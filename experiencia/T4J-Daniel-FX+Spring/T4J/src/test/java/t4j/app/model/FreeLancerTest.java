/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import t4j.app.exception.ElementoInvalidoException;

/**
 *
 * @author Upskill
 */
public class FreeLancerTest {
    FreeLancer fT, f1, f2, f3;
    EnderecoPostal ep, ep2;
    HabilitacaoAcademica ha, ha2;
    List<HabilitacaoAcademica> listaHA;
    ReconhecimentoCT rct, rct2;
    List<ReconhecimentoCT> listaRCT;
    Object obj;
    
    public FreeLancerTest() {
        String email = "freel@mail.pt";
        ep = new EnderecoPostal("Rua org", "4000-001", "Porto");
        ha = new HabilitacaoAcademica(1L, "1", "Curso", "Instituição", "20", email);
        ha2 = new HabilitacaoAcademica(2L, "2", "Curso 2", "Instituição 2", "19", email);
        rct = new ReconhecimentoCT(1L, LocalDate.of(2021, 01, 01), "Grau1", "CT1", email);
        rct2 = new ReconhecimentoCT(2L, LocalDate.of(2021, 01, 02), "Grau2", "CT2", email);
        listaHA = new ArrayList<>();
        listaHA.add(ha);
        listaRCT = new ArrayList<>();
        listaRCT.add(rct);
        f1 = new FreeLancer(email, "Freelancer", "123456789", "911234567", ep, listaHA, listaRCT);
        f2 = new FreeLancer(f1);
        f3 = new FreeLancer("freel2@mail.pt", "FreelancerB", "123456780", "912345678", ep);
        
        obj = new Object();
    }

    /**
     * Test of getEndereco method, of class FreeLancer.
     */
    @Test
    public void testGetEndereco() {
        System.out.println("getEndereco");
        assertEquals(ep, f1.getEndereco());
    }

    /**
     * Test of getEmail method, of class FreeLancer.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        assertEquals("freel@mail.pt", f1.getEmail());
    }

    /**
     * Test of getNome method, of class FreeLancer.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        assertEquals("Freelancer", f1.getNome());
    }

    /**
     * Test of getNif method, of class FreeLancer.
     */
    @Test
    public void testGetNif() {
        System.out.println("getNif");
        assertEquals("123456789", f1.getNif());
    }

    /**
     * Test of getTelefone method, of class FreeLancer.
     */
    @Test
    public void testGetTelefone() {
        System.out.println("getTelefone");
        assertEquals("911234567", f1.getTelefone());
    }

    /**
     * Test of getHabilitacoes method, of class FreeLancer.
     */
    @Test
    public void testGetHabilitacoes() {
        List<HabilitacaoAcademica> listaHA = new ArrayList<>();
        f1.getHabilitacoes().add(ha);
//        f1.getHabilitacoes().add(ha2);
//        listaHA.add(ha);
//        listaHA.add(ha2);
//        assertEquals(listaHA, f1.getHabilitacoes());
        
    }

    /**
     * Test of getReconhecimentos method, of class FreeLancer.
     */
//    @Test
    public void testGetReconhecimentos() {
    }

    /**
     * Test of setHabilitacoes method, of class FreeLancer.
     */
//    @Test
    public void testSetHabilitacoes() {
    }

    /**
     * Test of setReconhecimentos method, of class FreeLancer.
     */
//    @Test
    public void testSetReconhecimentos() {
    }

    /**
     * Test of setEndereco method, of class FreeLancer.
     */
    @Test
    public void testSetEndereco() {
        System.out.println("setEndereco");
        ep2 = new EnderecoPostal("Rua org2", "4000-002", "Porto");
        f1.setEndereco(ep2);
        assertEquals(ep2, f1.getEndereco());
    }

    /**
     * Test of setEmail method, of class FreeLancer.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        //Testes de sucesso
        String email1 = "freel3@mail.pt";
        f1.setEmail(email1);
        assertEquals(email1, f1.getEmail());
        
        //Testes de insucesso
        String email2 = null;
        Throwable e2 = assertThrows(ElementoInvalidoException.class, () -> f1.setEmail(email2));
        assertEquals(FreeLancer.validaFreelancer.EMAIL_NULL_EXCEPTION, e2.getMessage());
        
        String email3 = " ";
        Throwable e3 = assertThrows(ElementoInvalidoException.class, () -> f1.setEmail(email3));
        assertEquals(FreeLancer.validaFreelancer.EMAIL_INVALID_EXCEPTION, e3.getMessage());
        
        String email4 = String.format("|%254d|", 0);
        Throwable e4 = assertThrows(ElementoInvalidoException.class, () -> f1.setEmail(email4));
        assertEquals(FreeLancer.validaFreelancer.EMAIL_MAX_SIZE_EXCEPTION, e4.getMessage());
    }   

    /**
     * Test of setNome method, of class FreeLancer.
     */
    @Test
    public void testSetNome() {
        //Testes de sucesso
        System.out.println("setNome");
        String nome = "New Freelancer";
        f1.setNome(nome);
        assertEquals(nome, f1.getNome());
        
        //Testes de insucesso
        String nome2 = null;
        Throwable e2 = assertThrows(ElementoInvalidoException.class, () -> f1.setNome(nome2));
        assertEquals(FreeLancer.validaFreelancer.NOME_NULL_EXCEPTION, e2.getMessage());
        
        String nome3 = " ";
        Throwable e3 = assertThrows(ElementoInvalidoException.class, () -> f1.setNome(nome3));
        assertEquals(FreeLancer.validaFreelancer.NOME_EMPTY_EXCEPTION, e3.getMessage());
        
        String nome4 = String.format("|%50d|", 0);
        Throwable e4 = assertThrows(ElementoInvalidoException.class, () -> f1.setNome(nome4));
        assertEquals(FreeLancer.validaFreelancer.NOME_MAX_SIZE_EXCEPTION, e4.getMessage());
        
        String nome5 = "Nome1";
        Throwable e5 = assertThrows(ElementoInvalidoException.class, () -> f1.setNome(nome5));
        assertEquals(FreeLancer.validaFreelancer.NOME_REGEX_EXCEPTION, e5.getMessage());
    }

    /**
     * Test of setNif method, of class FreeLancer.
     */
    @Test
    public void testSetNif() {
        //Testes de sucesso
        System.out.println("setNif");
        String nif = "234567890";
        f1.setNif(nif);
        assertEquals(nif, f1.getNif());
        
        //Testes de insucesso
        String nif2 = null;
        Throwable e2 = assertThrows(ElementoInvalidoException.class, () -> f1.setNif(nif2));
        assertEquals(FreeLancer.validaFreelancer.NIF_NULL_EXCEPTION, e2.getMessage());
        
        String nif3 = " ";
        Throwable e3 = assertThrows(ElementoInvalidoException.class, () -> f1.setNif(nif3));
        assertEquals(FreeLancer.validaFreelancer.NIF_EMPTY_EXCEPTION, e3.getMessage());
        
        String nif4 = String.format("|%9d|", 0);
        Throwable e4 = assertThrows(ElementoInvalidoException.class, () -> f1.setNif(nif4));
        assertEquals(FreeLancer.validaFreelancer.NIF_SIZE_EXCEPTION, e4.getMessage());
        
        String nif5 = "12345678Z";
        Throwable e5 = assertThrows(ElementoInvalidoException.class, () -> f1.setNif(nif5));
        assertEquals(FreeLancer.validaFreelancer.NIF_REGEX_EXCEPTION, e5.getMessage());
    }

    /**
     * Test of setTelefone method, of class FreeLancer.
     */
    @Test
    public void testSetTelefone() {
        //Testes de sucesso
        System.out.println("setTelefone");
        String tlf = "931234567";
        f1.setTelefone(tlf);
        assertEquals(tlf, f1.getTelefone());
        
        //Testes de insucesso
        String tlf2 = null;
        Throwable e2 = assertThrows(ElementoInvalidoException.class, () -> f1.setTelefone(tlf2));
        assertEquals(FreeLancer.validaFreelancer.TELEFONE_NULL_EXCEPTION, e2.getMessage());
        
        String tlf3 = " ";
        Throwable e3 = assertThrows(ElementoInvalidoException.class, () -> f1.setTelefone(tlf3));
        assertEquals(FreeLancer.validaFreelancer.TELEFONE_EMPTY_EXCEPTION, e3.getMessage());
        
        String tlf4 = "1234567";
        Throwable e4 = assertThrows(ElementoInvalidoException.class, () -> f1.setTelefone(tlf4));
        assertEquals(FreeLancer.validaFreelancer.TELEFONE_SIZE_EXCEPTION, e4.getMessage());
        
        String tlf4v2 = "12345678901234567";
        Throwable e4v2 = assertThrows(ElementoInvalidoException.class, () -> f1.setTelefone(tlf4v2));
        assertEquals(FreeLancer.validaFreelancer.TELEFONE_SIZE_EXCEPTION, e4v2.getMessage());
        
        String tlf5 = "12345678Z";
        Throwable e5 = assertThrows(ElementoInvalidoException.class, () -> f1.setTelefone(tlf5));
        assertEquals(FreeLancer.validaFreelancer.TELEFONE_REGEX_EXCEPTION, e5.getMessage());
    }

    /**
     * Test of toString method, of class FreeLancer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String ts1 = "FreeLancer{email=freel@mail.pt, nome=Freelancer, nif=123456789, telefone=911234567, endereco=EnderecoPostal{id=null, morada=Rua org, codigoPostal=4000-001, localidade=Porto}, habilitacoes=[HabilitacaoAcademica{id=1, grau=1, designacaocurso=Curso, nomeinstituicao=Instituição, mediacurso=20, emailFreelancer=freel@mail.pt}], reconhecimentos=[ReconhecimentoCT{id=1, datareconhecimento=2021-01-01, idgrauproficiencia=Grau1, codigocompetenciatecnica=CT1, emailfreelancer=freel@mail.pt}]}";
        assertEquals(ts1, f1.toString());
        
        fT = new FreeLancer();
        String ts2 = "FreeLancer{email=null, nome=null, nif=null, telefone=null, endereco=EnderecoPostal{id=null, morada=null, codigoPostal=null, localidade=null}, habilitacoes=[], reconhecimentos=[]}";
        assertEquals(ts2, fT.toString());
    }


    /**
     * Test of equals method, of class FreeLancer.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(f1, f1);
        assertEquals(f1.hashCode(), f1.hashCode());
        assertEquals(f3, f3);
        assertEquals(f3.hashCode(), f3.hashCode());
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(f1, f2);
        assertEquals(f1.hashCode(), f2.hashCode());
        assertEquals(f2, f1);
        assertEquals(f2.hashCode(), f1.hashCode());
        // Testes de insucesso
        assertNotEquals(f1, f3);
        assertNotEquals(f1.hashCode(), f3.hashCode());
        assertNotEquals(f3, f1);
        assertNotEquals(f3.hashCode(), f1.hashCode());
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(f1, null);
        assertNotEquals(f1, null);
        assertNotEquals(f3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsCoverage() {
        System.out.println("equals: testa todas as propriedades");

        f2.setEmail("freel4@mail.pt");
        assertNotEquals(f1, f2);
        f2.setEmail(f1.getEmail());
        
        f2.setNome("FreelancerC");
        assertNotEquals(f1, f2);
        f2.setNome(f1.getNome());
        
        f2.setNif("345678901");
        assertNotEquals(f1, f2);
        f2.setNif(f1.getNif());
        
        f2.setTelefone("961234567");
        assertNotEquals(f1, f2);
        f2.setTelefone(f1.getTelefone());
        
        ep2 = new EnderecoPostal("Rua org2", "4000-002", "Porto");
        f2.setEndereco(ep2);
        assertNotEquals(f1, f2);
        f2.setEndereco(f1.getEndereco());
        
        List<HabilitacaoAcademica> listaHA = new ArrayList<>();
        listaHA.add(ha2);
        f2.setHabilitacoes(listaHA);
        assertNotEquals(f1, f2);
        f2.setHabilitacoes(f1.getHabilitacoes());
        
        List<ReconhecimentoCT> listaRCT = new ArrayList<>();
        listaRCT.add(rct2);
        f2.setReconhecimentos(listaRCT);
        assertNotEquals(f1, f2);
        f2.setReconhecimentos(f1.getReconhecimentos());
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(f1, obj);
        assertNotEquals(f1.hashCode(), obj.hashCode());
        assertNotEquals(f2, obj);
        assertNotEquals(f2.hashCode(), obj.hashCode());
        assertNotEquals(f3, obj);
        assertNotEquals(f3.hashCode(), obj.hashCode());
    }
    
}
