package t4j.app.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import t4j.app.model.TipoRegimento;

public interface TipoRegimentoDAO extends JpaRepository<TipoRegimento, String>{

    public Optional<TipoRegimento> findByDesignacao(String designacao);
}
