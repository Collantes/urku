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
import upeu.edu.pe.urku.entity.Clasificacion;
import upeu.edu.pe.urku.service.ClasificacionService;

/**
 *
 * @author tpp
 */
@RestController
@RequestMapping("api/clasificacion")
@Api(value = "Microservicios de Gestion de Clasificaciones", description = "Microservicio de Clasificacion")
public class ClasificacionController {

    @Autowired
    private ClasificacionService clasificacionService;

    @ApiOperation(value = "Lista de Clasificaciones")
    @GetMapping
    public ResponseEntity<?> findAll(HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Consulta correcta.");
        result.put("data", clasificacionService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Crea Clasificacion")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Clasificacion clasificacion, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Clasificacion data = clasificacionService.save(clasificacion);

        result.put("success", true);
        result.put("message", "Registro creado correctamente.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Actualiza una Clasificacion")
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Clasificacion clasificacion, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Clasificacion data = clasificacionService.findById(clasificacion.getClasId());
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe clasificacion con Id: " + clasificacion.getClasId());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            clasificacionService.save(clasificacion);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos de la clasificacion.");
            result.put("data", clasificacion);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Obtiene Datos de la Clasificacion")
    @GetMapping(value = "/{clasId}")
    public ResponseEntity<?> findById(@PathVariable(value = "clasId") Long clasId, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Clasificacion data = clasificacionService.findById(clasId);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe clasificacion con Id: " + clasId);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        result.put("success", true);
        result.put("message", "Se ha encontrado el registro.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina una Clasificacion")
    @DeleteMapping(value = "/{clasId}")
    public ResponseEntity<?> delete(@PathVariable(value = "clasId") Long clasId, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Clasificacion data = clasificacionService.findById(clasId);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con id: " + clasId);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            clasificacionService.delete(data);
            result.put("success", true);
            result.put("message", "Se ha eliminado los datos del registro.");
            result.put("data", data);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
