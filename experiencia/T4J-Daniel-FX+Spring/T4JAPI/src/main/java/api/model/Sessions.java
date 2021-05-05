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
@Table(name = "sessions")
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class Sessions implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login_date")
    private LocalDateTime loginDate;
    @Column(name = "id_context")
    private Long idContext;
    @Column(name = "id_user")
    private Long idUser;

    public Sessions(Long id, LocalDateTime loginDate, Long idContext, Long idUser) {
        this.id = id;
        this.loginDate = loginDate;
        this.idContext = idContext;
        this.idUser = idUser;
    }

    public Sessions() {
    }
    
    public Sessions(Sessions otherSessions) {
        setId(otherSessions.id);
        setLoginDate(otherSessions.loginDate);
        setIdContext(otherSessions.idContext);
        setIdUser(otherSessions.idUser);
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getLoginDate() {
        return loginDate;
    }

    public Long getIdContext() {
        return idContext;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLoginDate(LocalDateTime loginDate) {
        this.loginDate = loginDate;
    }

    public void setIdContext(Long idContext) {
        this.idContext = idContext;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sessions{id=").append(id);
        sb.append(", loginDate=").append(loginDate);
        sb.append(", idContext=").append(idContext);
        sb.append(", idUser=").append(idUser);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.loginDate);
        hash = 89 * hash + Objects.hashCode(this.idContext);
        hash = 89 * hash + Objects.hashCode(this.idUser);
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
        final Sessions other = (Sessions) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.loginDate, other.loginDate)) {
            return false;
        }
        if (!Objects.equals(this.idContext, other.idContext)) {
            return false;
        }
        if (!Objects.equals(this.idUser, other.idUser)) {
            return false;
        }
        return true;
    }
}
