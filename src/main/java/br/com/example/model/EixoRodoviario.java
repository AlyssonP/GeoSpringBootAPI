/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.model;

import com.vividsolutions.jts.geom.Geometry;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author alyssonp
 */
@Data
@AllArgsConstructor
@Entity
@Table(name = "eixo_rodoviario_estruturante_2014")
public class EixoRodoviario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    @Column(name = "objectid")
    private Integer objectid;
    @Column(name = "descseg")
    private String descseg;
    @Column(name = "tipopnv")
    private String tipoPavimento;
    @Column(name = "codigo")
    private String codigoEixo;
    @Column(name = "geom")
    private Geometry geometria;
    
}
