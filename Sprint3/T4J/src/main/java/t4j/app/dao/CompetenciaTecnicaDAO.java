/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import t4j.app.model.CompetenciaTecnica;

/**
 *
 * @author user
 */
public interface CompetenciaTecnicaDAO extends JpaRepository<CompetenciaTecnica, String>{
  @Query(value = "Select c.codigo from competenciatecnica c",nativeQuery = true)
  public List<String> getAllCompetenciasTecnicasIDs();
}
