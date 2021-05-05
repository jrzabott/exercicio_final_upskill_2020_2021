/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import t4j.app.model.Organizacao;

/**
 *
 * @author user
 */
//@Repository
//public interface OrganizacaoDAO {
public interface OrganizacaoDAO extends JpaRepository<Organizacao, String> {

}
