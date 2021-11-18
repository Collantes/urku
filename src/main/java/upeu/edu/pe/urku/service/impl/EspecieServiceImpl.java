/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.urku.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.edu.pe.urku.entity.Especie;
import upeu.edu.pe.urku.repository.EspecieRepository;
import upeu.edu.pe.urku.service.EspecieService;

/**
 *
 * @author tpp
 */
@Service
public class EspecieServiceImpl implements EspecieService {

    @Autowired
    EspecieRepository especieRepository;

    @Override
    public List<Especie> findAll() {
        return (List<Especie>) especieRepository.findAll();
    }

    @Override
    public Especie findById(Long id) {
        return especieRepository.findById(id).orElse(null);
    }

    @Override
    public Especie save(Especie especie) {
        return especieRepository.save(especie);
    }

    @Override
    public void delete(Especie especie) {
        especieRepository.delete(especie);
    }
}
