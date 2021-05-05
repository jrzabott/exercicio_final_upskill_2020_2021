/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import t4j.app.dto.EnderecoPostalDTO;
import t4j.app.model.EnderecoPostal;

/**
 *
 * @author user
 */
@Repository
@Transactional
public interface EnderecoDAO extends JpaRepository<EnderecoPostal, Long> {

}
