/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.urku.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author tpp
 */
@Data
@Entity
@Table(name = "clasificaciones")
public class Clasificacion implements Serializable {

    @Id
    @Column(name = "clas_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clasId;

    @Column(name = "clas_descripcion")
    private String clasDescripcion;
}
