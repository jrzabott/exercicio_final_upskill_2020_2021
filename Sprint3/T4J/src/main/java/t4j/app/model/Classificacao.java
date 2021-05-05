package t4j.app.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classificacao")
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class Classificacao implements Serializable {

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * 
     */
    @Column(name = "id_processo_seriacao")
    private Long idProcessoSeriacao;
    
    /**
     * 
     */
    @Column(name = "id_candidatura_vencedora")
    private Long idCandidaturaVencedora;

    /**
     * 
     * @param id
     * @param idProcessoSeriacao
     * @param idCandidaturaVencesora 
     */
    public Classificacao(Long id, Long idProcessoSeriacao, Long idCandidaturaVencedora) {
        this.id = id;
        this.idProcessoSeriacao = idProcessoSeriacao;
        this.idCandidaturaVencedora = idCandidaturaVencedora;
    }

    /**
     * 
     */
    public Classificacao() {
    }
    
    public Classificacao(Classificacao outraClassificacao) {
        setId(outraClassificacao.id);
        setIdProcessoSeriacao(outraClassificacao.idProcessoSeriacao);
        setIdCandidaturaVencedora(outraClassificacao.idCandidaturaVencedora);
    }

    /**
     * 
     * @return 
     */
    public Long getId() {
        return id;
    }
    
    /**
     * 
     * @return 
     */
    public Long getIdProcessoSeriacao() {
        return idProcessoSeriacao;
    }
    
    /**
     * 
     * @return 
     */
    public Long getIdCandidaturaVencedora() {
        return idCandidaturaVencedora;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @param idProcessoSeriacao 
     */
    public void setIdProcessoSeriacao(Long idProcessoSeriacao) {
        this.idProcessoSeriacao = idProcessoSeriacao;
    }

    /**
     * 
     * @param idCandidaturaVencedora 
     */
    public void setIdCandidaturaVencedora(Long idCandidaturaVencedora) {
        this.idCandidaturaVencedora = idCandidaturaVencedora;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Classificacao{id=").append(id);
        sb.append(", idProcessoSeriacao=").append(idProcessoSeriacao);
        sb.append(", idCandidaturaVencedora=").append(idCandidaturaVencedora);
        sb.append('}');
        return sb.toString();
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.idProcessoSeriacao);
        hash = 41 * hash + Objects.hashCode(this.idCandidaturaVencedora);
        return hash;
    }

    /**
     * 
     * @param outroObjeto
     * @return 
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Classificacao outrClassificacao = (Classificacao) outroObjeto;
        return id.equals(outrClassificacao.id)
                && idProcessoSeriacao.equals(outrClassificacao.idProcessoSeriacao)
                && idCandidaturaVencedora.equals(outrClassificacao.idCandidaturaVencedora);
    }
}
