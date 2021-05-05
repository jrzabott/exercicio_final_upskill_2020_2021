package t4j.app.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "processoseriacao")
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class ProcessoSeriacao implements Serializable {

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * 
     */
    @Column(name = "data_realizacao")
    private LocalDate dataRealizacao;
    
    /**
     * 
     */
    @Column(name = "referencia_anuncio")
    private String referenciaAnuncio;

    /**
     * 
     * @param id
     * @param dataRealizacao
     * @param idAnuncio 
     */
    public ProcessoSeriacao(Long id, LocalDate dataRealizacao, String referenciaAnuncio) {
        this.id = id;
        this.dataRealizacao = dataRealizacao;
        this.referenciaAnuncio = referenciaAnuncio;
    }

    /**
     * 
     */
    public ProcessoSeriacao() {
    }

    /**
     * 
     * @param outroProcessoSeriacao 
     */
    public ProcessoSeriacao(ProcessoSeriacao outroProcessoSeriacao) {
        setId(outroProcessoSeriacao.id);
        setDataRealizacao(outroProcessoSeriacao.dataRealizacao);
        setReferenciaAnuncio(outroProcessoSeriacao.referenciaAnuncio);
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
    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    /**
     * 
     * @return 
     */
    public String getReferenciaAnuncio() {
        return referenciaAnuncio;
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
     * @param dataRealizacao 
     */
    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    /**
     * 
     * @param referenciaAnuncio 
     */
    public void setReferenciaAnuncio(String referenciaAnuncio) {
        this.referenciaAnuncio = referenciaAnuncio;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProcessoSeriacao{id=").append(id);
        sb.append(", dataRealizacao=").append(dataRealizacao);
        sb.append(", idAnuncio=").append(referenciaAnuncio);
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
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.dataRealizacao);
        hash = 29 * hash + Objects.hashCode(this.referenciaAnuncio);
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
        final ProcessoSeriacao other = (ProcessoSeriacao) obj;
        if (!Objects.equals(this.referenciaAnuncio, other.referenciaAnuncio)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataRealizacao, other.dataRealizacao)) {
            return false;
        }
        return true;
    }
}
