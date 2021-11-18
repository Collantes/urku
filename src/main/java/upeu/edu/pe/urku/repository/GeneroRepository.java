/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.urku.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.urku.entity.Genero;

/**
 *
 * @author tpp
 */
@Repository
public interface GeneroRepository extends CrudRepository<Genero, Long> {

}
