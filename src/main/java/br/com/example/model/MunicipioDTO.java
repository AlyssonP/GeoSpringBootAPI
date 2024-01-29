package br.com.example.model;

import com.vividsolutions.jts.geom.Geometry;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author alyssonp
 */

@Data
public class MunicipioDTO implements Serializable{
    private String codigo;
    private String nome;
    private String uf;
    private Geometry geometria;
    
    public MunicipioDTO(String codigo, String nome, String uf) {
        this.codigo = codigo;
        this.nome = nome;
        this.uf = uf;
        this.geometria = null;
    }
    
    public MunicipioDTO(String codigo, String nome, String uf, Geometry geometria) {
        this.codigo = codigo;
        this.nome = nome;
        this.uf = uf;
        this.geometria = geometria;
    }
}
