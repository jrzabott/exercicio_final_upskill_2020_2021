package api.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "contexts")
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class Contexts implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "context")
    private String context;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
    @Column(name = "valido")
    private String valido;

    public Contexts(Long id, String context, LocalDateTime dataCriacao, String valido) {
        this.id = id;
        this.context = context;
        this.dataCriacao = dataCriacao;
        this.valido = valido;
    }

    public Contexts() {
    }
    
    public Contexts(Contexts otherContexts) {
        setId(otherContexts.id);
        setContext(otherContexts.context);
        setDataCriacao(otherContexts.dataCriacao);
        setValido(otherContexts.valido);
    }

    public Long getId() {
        return id;
    }

    public String getContext() {
        return context;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getValido() {
        return valido;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setValido(String valido) {
        this.valido = valido;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contexts{id=").append(id);
        sb.append(", context=").append(context);
        sb.append(", dataCriacao=").append(dataCriacao);
        sb.append(", valido=").append(valido);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.context);
        hash = 97 * hash + Objects.hashCode(this.dataCriacao);
        hash = 97 * hash + Objects.hashCode(this.valido);
        return hash;
    }

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
        final Contexts other = (Contexts) obj;
        if (!Objects.equals(this.context, other.context)) {
            return false;
        }
        if (!Objects.equals(this.valido, other.valido)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return true;
    }
}
