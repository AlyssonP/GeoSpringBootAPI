/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.example.repository;

import br.com.example.model.Aeroporto;
import br.com.example.model.AeroportoView;
import br.com.example.model.MunicipioView;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author alyssonp
 */
public interface AeroportoRepository extends JpaRepository<Aeroporto, Integer>{
    
    @Query(value = "SELECT new br.com.example.model.AeroportoView(a.objectid, a.municipio, a.nomeUf, uf.sigla,  a.geometria)\n" +
                    "FROM Aeroporto a, Estado uf\n" +
                    "WHERE a.uf = uf.codigo\n" +
                    "ORDER BY uf.sigla")
    List<AeroportoView> aeroportos();
    
    
    @Query(value = "SELECT new br.com.example.model.AeroportoView(a.objectid, a.municipio, a.nomeUf, uf.sigla,  a.geometria) FROM Aeroporto a\n" +
                    "INNER JOIN Estado uf ON st_DWithin(geography(uf.geometria), geography(a.geometria), 10000) = true\n" +
                    "WHERE uf.sigla = :uf")
    List<AeroportoView> aeroportosEstado(String uf);
    
    
    @Query(value = "SELECT new br.com.example.model.AeroportoView(a.objectid, a.municipio, a.nomeUf, uf.sigla,  a.geometria) FROM Aeroporto a, Estado uf\n" +
                    "WHERE a.regiao = :regiao AND a.uf = uf.codigo")
    List<AeroportoView> aeroportosRegiao(String regiao);
    
    
    @Query(value = "SELECT new br.com.example.model.MunicipioView(m.codigo, m.nome, m.sigla, m.geometria) FROM Municipio m\n" +
                    "INNER JOIN Aeroporto a1 ON st_within(a1.geometria, m.geometria) = true\n" +
                    "WHERE a1.regiao = :regiao ")
    List<MunicipioView> municipiosAeroportoRegiao(String regiao);
    
    
    @Query(value = "SELECT count(a.municipio) FROM Aeroporto a\n" +
                    "INNER JOIN Estado uf ON st_DWithin(geography(uf.geometria), geography(a.geometria), 10000) = true\n" +
                    "WHERE uf.sigla = :uf")
    public Integer quantidadeAeroportosEstado(String uf);
    
    
    @Query(value = "SELECT distance(geography(a1.geometria), geography(a2.geometria)) " + 
                    "FROM Aeroporto a1, Aeroporto a2\n" +
                    "WHERE a1.municipio = :cidade1 AND a2.municipio = :cidade2")
    public Double distanciaAeroportos(String cidade1, String cidade2);
}
