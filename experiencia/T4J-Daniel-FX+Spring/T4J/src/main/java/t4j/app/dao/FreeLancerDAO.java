package t4j.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import t4j.app.model.FreeLancer;

public interface FreeLancerDAO extends JpaRepository<FreeLancer, String> {

}
