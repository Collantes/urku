/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.urku.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.edu.pe.urku.entity.Clasificacion;
import upeu.edu.pe.urku.repository.ClasificacionRepository;
import upeu.edu.pe.urku.service.ClasificacionService;

/**
 *
 * @author tpp
 */
@Service
public class ClasificacionServiceImpl implements ClasificacionService {

    @Autowired
    ClasificacionRepository clasificacionRepository;

    @Override
    public List<Clasificacion> findAll() {
        return (List<Clasificacion>) clasificacionRepository.findAll();
    }

    @Override
    public Clasificacion findById(Long id) {
        return clasificacionRepository.findById(id).orElse(null);
    }

    @Override
    public Clasificacion save(Clasificacion clasificacion) {
        return clasificacionRepository.save(clasificacion);
    }

    @Override
    public void delete(Clasificacion clasificacion) {
        clasificacionRepository.delete(clasificacion);
    }

}
