/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.model;

import com.vividsolutions.jts.geom.Geometry;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author alyssonp
 */
@Data
public class EstadoDTO implements Serializable{
    private String codigo;
    private String nome;
    private String uf;
    private Geometry geometria;
    
    public EstadoDTO(String codigo, String nome, String uf) {
        this.codigo = codigo;
        this.nome = nome;
        this.uf = uf;
        this.geometria = null;
    }
    
    public EstadoDTO(String codigo, String nome, String uf, Geometry geometria) {
        this.codigo = codigo;
        this.nome = nome;
        this.uf = uf;
        this.geometria = geometria;
    }
}
