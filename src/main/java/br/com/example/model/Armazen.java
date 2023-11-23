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
@Table(name = "armazens_2014")
public class Armazen implements Serializable{
    // gid, objectid_1, uf, municipio, cap_ton, geocodigo, geom
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    @Column(name = "objectid")
    private Integer objectid;
    @Column(name = "uf")
    private String siglaUf;
    @Column(name = "municipio")
    private String municipio;
    @Column(name = "cap_ton")
    private Double capTon;
    @Column(name = "geocondigo")
    private Double geoCodigo;
    @Column(name = "geom")
    private Geometry geometria;
    
}
