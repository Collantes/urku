/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.urku.service;

import java.util.List;
import upeu.edu.pe.urku.entity.Genero;

/**
 *
 * @author tpp
 */
public interface GeneroService {

    public List<Genero> findAll();

    public Genero findById(Long id);

    public Genero save(Genero genero);

    public void delete(Genero genero);
}
