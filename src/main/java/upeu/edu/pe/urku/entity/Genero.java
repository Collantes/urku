/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.urku.entity;

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
@Table(name = "generos")
public class Genero {

    @Id
    @Column(name = "gene_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long geneId;

    @Column(name = "gene_descripcion")
    private String geneDescripcion;

}
