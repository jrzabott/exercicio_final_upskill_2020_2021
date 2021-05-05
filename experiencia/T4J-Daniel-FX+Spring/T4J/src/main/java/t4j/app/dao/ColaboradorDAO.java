package t4j.app.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import t4j.app.model.Colaborador;

public interface ColaboradorDAO extends JpaRepository<Colaborador, String> {

    public Optional<Colaborador> findByEmail(String email);

}
