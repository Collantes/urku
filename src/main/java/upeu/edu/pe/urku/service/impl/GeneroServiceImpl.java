/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.urku.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.edu.pe.urku.entity.Genero;
import upeu.edu.pe.urku.repository.GeneroRepository;
import upeu.edu.pe.urku.service.GeneroService;

/**
 *
 * @author tpp
 */
@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    GeneroRepository generoRepository;

    @Override
    public List<Genero> findAll() {
        return (List<Genero>) generoRepository.findAll();
    }

    @Override
    public Genero findById(Long id) {
        return generoRepository.findById(id).orElse(null);
    }

    @Override
    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }

    @Override
    public void delete(Genero genero) {
        generoRepository.delete(genero);
    }
}
