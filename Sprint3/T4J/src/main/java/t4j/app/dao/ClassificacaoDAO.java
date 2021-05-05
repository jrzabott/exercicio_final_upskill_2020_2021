package t4j.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import t4j.app.model.Classificacao;

public interface ClassificacaoDAO extends JpaRepository<Classificacao, Long>{
    
}
