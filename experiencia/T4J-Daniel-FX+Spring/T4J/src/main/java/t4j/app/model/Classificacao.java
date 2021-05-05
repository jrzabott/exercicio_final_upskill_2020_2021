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
    
    /**
     * 
     * @param outraClassificacao 
     */
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
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.idProcessoSeriacao);
        hash = 31 * hash + Objects.hashCode(this.idCandidaturaVencedora);
        return hash;
    }

    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Classificacao other = (Classificacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.idProcessoSeriacao, other.idProcessoSeriacao)) {
            return false;
        }
        if (!Objects.equals(this.idCandidaturaVencedora, other.idCandidaturaVencedora)) {
            return false;
        }
        return true;
    }
}
