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

/**
 *
 * @author tpp
 */
@Data
@Entity
@Table(name = "rescatistas")
public class Rescatista {

    @Id
    @Column(name = "resc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rescId;

    @Column(name = "resc_nombre")
    private String rescNombre;
}
