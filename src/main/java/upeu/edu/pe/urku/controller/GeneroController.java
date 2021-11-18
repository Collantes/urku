/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.urku.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upeu.edu.pe.urku.entity.Genero;
import upeu.edu.pe.urku.service.GeneroService;

/**
 *
 * @author tpp
 */
@RestController
@RequestMapping("api/genero")
@Api(value = "Microservicios de Gestion de Generos", description = "Microservicio de Genero")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @ApiOperation(value = "Lista de Generos")
    @GetMapping
    public ResponseEntity<?> findAll(HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Consulta correcta.");
        result.put("data", generoService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Crea Genero")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Genero genero, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Genero data = generoService.save(genero);

        result.put("success", true);
        result.put("message", "Registro creado correctamente.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Actualiza un Genero")
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Genero genero, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Genero data = generoService.findById(genero.getGeneId());
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe genero con Id: " + genero.getGeneId());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            generoService.save(genero);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos del genero.");
            result.put("data", genero);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Obtiene Datos de la Genero")
    @GetMapping(value = "/{geneId}")
    public ResponseEntity<?> findById(@PathVariable(value = "geneId") Long geneId, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Genero data = generoService.findById(geneId);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe genero con Id: " + geneId);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        result.put("success", true);
        result.put("message", "Se ha encontrado el registro.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina un Genero")
    @DeleteMapping(value = "/{geneId}")
    public ResponseEntity<?> delete(@PathVariable(value = "geneId") Long geneId, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Genero data = generoService.findById(geneId);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con id: " + geneId);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            generoService.delete(data);
            result.put("success", true);
            result.put("message", "Se ha eliminado los datos del registro.");
            result.put("data", data);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
