package t4j.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import t4j.app.model.Organizacao;

public interface OrganizacaoDAO extends JpaRepository<Organizacao, String> {

}
