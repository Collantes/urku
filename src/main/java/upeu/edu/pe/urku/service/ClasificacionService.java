/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.urku.service;

import java.util.List;
import upeu.edu.pe.urku.entity.Clasificacion;

/**
 *
 * @author tpp
 */
public interface ClasificacionService {

    public List<Clasificacion> findAll();

    public Clasificacion findById(Long id);

    public Clasificacion save(Clasificacion clasificacion);

    public void delete(Clasificacion clasificacion);

}
