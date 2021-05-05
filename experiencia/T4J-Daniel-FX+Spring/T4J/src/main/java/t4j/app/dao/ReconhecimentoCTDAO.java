package t4j.app.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import t4j.app.model.ReconhecimentoCT;

public interface ReconhecimentoCTDAO extends JpaRepository<ReconhecimentoCT, Long> {

    /**
     *
     * @param emailFreelancer
     * @return
     */
    @Query(value = "SELECT r.ID "
            + "FROM reconhecimentoct r "
            + "WHERE r.EMAIL_FREELANCER = :email", nativeQuery = true)
    public List<Long> findAllByEmailFreelancer(@Param("email") String emailFreelancer);
}
