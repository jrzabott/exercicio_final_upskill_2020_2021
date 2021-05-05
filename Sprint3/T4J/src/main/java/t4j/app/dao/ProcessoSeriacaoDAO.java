package t4j.app.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import t4j.app.model.ProcessoSeriacao;

public interface ProcessoSeriacaoDAO extends JpaRepository<ProcessoSeriacao, Long>{

    Optional<ProcessoSeriacao> findByReferenciaAnuncio(String ref);

}
