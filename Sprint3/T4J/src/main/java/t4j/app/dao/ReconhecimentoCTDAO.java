/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import t4j.app.model.ReconhecimentoCT;

/**
 *
 * @author user
 */
public interface ReconhecimentoCTDAO extends JpaRepository<ReconhecimentoCT, Long>{
    
//    @Query(value = "SELECT r.ID, r.DATA_RECONHECIMENTO, EMAIL_FREELANCER, ID_GRAU_PROFICIENCIA, CODIGO_COMPETENCIA_TECNICA "
//            + "FROM reconhecimentoct r "
//            + "WHERE r.EMAIL_FREELANCER = :email", nativeQuery = true)
    @Query(value = "SELECT r.ID "
            + "FROM reconhecimentoct r "
            + "WHERE r.EMAIL_FREELANCER = :email", nativeQuery = true)
    public List<Long> findAllByEmailFreelancer(@Param("email") String emailFreelancer);
}
