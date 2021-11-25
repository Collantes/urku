/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.urku.service;

import upeu.edu.pe.urku.entity.Usuario;

/**
 *
 * @author tpp
 */
public interface UsuarioService {

    public Usuario findByUsername(String username);
}
