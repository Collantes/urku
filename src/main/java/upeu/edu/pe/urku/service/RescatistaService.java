/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.urku.service;

import java.util.List;
import upeu.edu.pe.urku.entity.Rescatista;

/**
 *
 * @author tpp
 */
public interface RescatistaService {

    public List<Rescatista> findAll();

    public Rescatista findById(Long id);

    public Rescatista save(Rescatista rescatista);

    public void delete(Rescatista rescatista);
}
