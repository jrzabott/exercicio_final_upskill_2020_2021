/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import t4j.app.model.FreeLancer;

/**
 *
 * @author Home
 */
public interface FreeLancerDAO extends JpaRepository<FreeLancer, String> {

}
