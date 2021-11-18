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
import upeu.edu.pe.urku.entity.Rescatista;
import upeu.edu.pe.urku.service.RescatistaService;

/**
 *
 * @author tpp
 */
@RestController
@RequestMapping("api/rescatista")
@Api(value = "Microservicios de Gestion de Rescatistas", description = "Microservicio de Rescatista")
public class RescatistaController {

    @Autowired
    private RescatistaService rescatistaService;

    @ApiOperation(value = "Lista de Rescatistas")
    @GetMapping
    public ResponseEntity<?> findAll(HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Consulta correcta.");
        result.put("data", rescatistaService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Crea Rescatista")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Rescatista rescatista, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Rescatista data = rescatistaService.save(rescatista);

        result.put("success", true);
        result.put("message", "Registro creado correctamente.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Actualiza un Rescatista")
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Rescatista rescatista, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Rescatista data = rescatistaService.findById(rescatista.getRescId());
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe rescatista con Id: " + rescatista.getRescId());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            rescatistaService.save(rescatista);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos del rescatista.");
            result.put("data", rescatista);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Obtiene Datos de la Rescatista")
    @GetMapping(value = "/{rescId}")
    public ResponseEntity<?> findById(@PathVariable(value = "rescId") Long rescId, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Rescatista data = rescatistaService.findById(rescId);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe rescatista con Id: " + rescId);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        result.put("success", true);
        result.put("message", "Se ha encontrado el registro.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina un Rescatista")
    @DeleteMapping(value = "/{rescId}")
    public ResponseEntity<?> delete(@PathVariable(value = "rescId") Long rescId, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Rescatista data = rescatistaService.findById(rescId);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con id: " + rescId);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            rescatistaService.delete(data);
            result.put("success", true);
            result.put("message", "Se ha eliminado los datos del registro.");
            result.put("data", data);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
