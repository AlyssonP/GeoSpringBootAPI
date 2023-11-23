/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.model;

import com.vividsolutions.jts.geom.Geometry;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author alyssonp
 */
@Data
@AllArgsConstructor
public class EixoRodoviarioView implements Serializable{
    private Integer codigo;
    private String descseg;
    private String tipoPavimento;
    private String codigoEixo;
    private Geometry geometria;
    
}
