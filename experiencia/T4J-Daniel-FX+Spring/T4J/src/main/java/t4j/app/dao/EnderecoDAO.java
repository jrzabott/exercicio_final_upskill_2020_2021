package t4j.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import t4j.app.model.EnderecoPostal;

@Repository
@Transactional
public interface EnderecoDAO extends JpaRepository<EnderecoPostal, Long> {

}
