/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.urku.service;

import java.util.List;
import upeu.edu.pe.urku.entity.Especie;

/**
 *
 * @author tpp
 */
public interface EspecieService {

    public List<Especie> findAll();

    public Especie findById(Long id);

    public Especie save(Especie especie);

    public void delete(Especie especie);
}
