/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import t4j.app.model.CategoriaTarefa;

/**
 *
 * @author user
 */
public interface CategoriaTarefaDAO extends JpaRepository<CategoriaTarefa, String> {

    @Query(nativeQuery = true, value = "SELECT nvel(max(id), 0) + 1 from categoriatarefa")
    long findNextId();

}
