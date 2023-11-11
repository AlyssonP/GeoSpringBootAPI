/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.model;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.vividsolutions.jts.geom.Geometry;

/**
 *
 * @author alyssonp
 */
@Data
@AllArgsConstructor
public class MunicipioView implements Serializable{
    private String codigo;
    private String nome;
    private String uf;
    private Geometry geometria;
}
