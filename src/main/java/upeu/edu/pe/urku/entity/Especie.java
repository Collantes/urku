/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.urku.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author tpp
 */
@Data
@Entity
@Table(name = "especies")
public class Especie {

    @Id
    @Column(name = "espe_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long espeId;

    @Column(name = "espe_nombre")
    private String espeNombre;

    @Column(name = "espe_observacion")
    private String espeObservacion;

    @Column(name = "espe_lugar_rescate")
    private String espeLugarRescate;

    @Column(name = "espe_fecha")
    private Date espeFecha;

    @ManyToOne
    @JoinColumn(name = "clas_id")
    private Clasificacion clasificacion;

    @ManyToOne
    @JoinColumn(name = "gene_id")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "resc_id")
    private Rescatista rescatista;

    @PrePersist
    public void prePersist() {
        espeFecha = new Date();
    }

}
