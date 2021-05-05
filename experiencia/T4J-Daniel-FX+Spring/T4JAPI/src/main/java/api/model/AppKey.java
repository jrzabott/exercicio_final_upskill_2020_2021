package api.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appkey")
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class AppKey implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "app_key")
    private String appKey;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "timeout")
    private Long timeout;

    public AppKey(Long id, String appKey, String descricao, Long timeout) {
        this.id = id;
        this.appKey = appKey;
        this.descricao = descricao;
        this.timeout = timeout;
    }

    public AppKey() {
    }
    
    public AppKey(AppKey otherAppKey) {
        setId(otherAppKey.id);
        setAppKey(otherAppKey.appKey);
        setDescricao(otherAppKey.descricao);
        setTimeout(otherAppKey.timeout);
    }


    public Long getId() {
        return id;
    }

    public String getAppKey() {
        return appKey;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppKey{id=").append(id);
        sb.append(", appKey=").append(appKey);
        sb.append(", descricao=").append(descricao);
        sb.append(", timeout=").append(timeout);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.appKey);
        hash = 19 * hash + Objects.hashCode(this.descricao);
        hash = 19 * hash + Objects.hashCode(this.timeout);
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
        final AppKey other = (AppKey) obj;
        if (!Objects.equals(this.appKey, other.appKey)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.timeout, other.timeout)) {
            return false;
        }
        return true;
    }
}
