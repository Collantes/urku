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
import upeu.edu.pe.urku.entity.Especie;
import upeu.edu.pe.urku.service.EspecieService;

/**
 *
 * @author tpp
 */
@RestController
@RequestMapping("api/especie")
@Api(value = "Microservicios de Gestion de Especies", description = "Microservicio de Especie")
public class EspecieController {

    @Autowired
    private EspecieService especieService;

    @ApiOperation(value = "Lista de Especies")
    @GetMapping
    public ResponseEntity<?> findAll(HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Consulta correcta.");
        result.put("data", especieService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Crea Especie")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Especie especie, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Especie data = especieService.save(especie);

        result.put("success", true);
        result.put("message", "Registro creado correctamente.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Actualiza un Especie")
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Especie especie, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Especie data = especieService.findById(especie.getEspeId());
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe especie con Id: " + especie.getEspeId());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            especieService.save(especie);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos de la especie.");
            result.put("data", especie);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Obtiene Datos de la Especie")
    @GetMapping(value = "/{espeId}")
    public ResponseEntity<?> findById(@PathVariable(value = "espeId") Long espeId, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Especie data = especieService.findById(espeId);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe especie con Id: " + espeId);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        result.put("success", true);
        result.put("message", "Se ha encontrado el registro.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina una Especie")
    @DeleteMapping(value = "/{espeId}")
    public ResponseEntity<?> delete(@PathVariable(value = "espeId") Long espeId, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Especie data = especieService.findById(espeId);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con id: " + espeId);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            especieService.delete(data);
            result.put("success", true);
            result.put("message", "Se ha eliminado los datos del registro.");
            result.put("data", data);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
