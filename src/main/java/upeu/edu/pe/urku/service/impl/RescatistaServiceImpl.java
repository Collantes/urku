/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.urku.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.edu.pe.urku.entity.Rescatista;
import upeu.edu.pe.urku.repository.RescatistaRepository;
import upeu.edu.pe.urku.service.RescatistaService;

/**
 *
 * @author tpp
 */
@Service
public class RescatistaServiceImpl implements RescatistaService {

    @Autowired
    RescatistaRepository rescatistaRepository;

    @Override
    public List<Rescatista> findAll() {
        return (List<Rescatista>) rescatistaRepository.findAll();
    }

    @Override
    public Rescatista findById(Long id) {
        return rescatistaRepository.findById(id).orElse(null);
    }

    @Override
    public Rescatista save(Rescatista rescatista) {
        return rescatistaRepository.save(rescatista);
    }

    @Override
    public void delete(Rescatista rescatista) {
        rescatistaRepository.delete(rescatista);
    }
}
