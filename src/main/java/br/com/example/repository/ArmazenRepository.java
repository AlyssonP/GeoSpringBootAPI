/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.repository;

import br.com.example.model.Armazen;
import br.com.example.model.ArmazenView;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author alyssonp
 */
public interface ArmazenRepository extends JpaRepository<Armazen, Integer>{
    
    @Query(value = "SELECT new br.com.example.model.ArmazenView(a.objectid, a.municipio, a.siglaUf, a.geometria) FROM Armazen a\n" +
                    "INNER JOIN Estado uf ON st_within(a.geometria, uf.geometria) = true\n" +
                    "WHERE uf.sigla = :uf")
    List<ArmazenView> armazensEstado(String uf);
    
    
    @Query(value = "SELECT new br.com.example.model.ArmazenView(a.objectid, a.municipio, a.siglaUf, a.geometria) FROM Armazen a\n" +
                    "INNER JOIN Estado uf ON st_within(a.geometria, uf.geometria) = true\n" +
                    "WHERE uf.nomeRegiao = :regiao")
    List<ArmazenView> armazensRegiao(String regiao);
    
    
    @Query(value = "SELECT distance(geography(a1.geometria), geography(a2.geometria)) FROM Armazen a1, Armazen a2\n" +
                    "WHERE a1.municipio = :municipio1 AND a2.municipio = :municipio2")
    public Double distanciaArmazens(String municipio1, String municipio2);
    
}
