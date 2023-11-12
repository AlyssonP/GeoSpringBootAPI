/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.example.repository;

import br.com.example.model.Municipio;
import br.com.example.model.PortoView;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author alyssonp
 */
public interface PortoRepository extends JpaRepository<Municipio, Integer>{
    
    @Query(value = "SELECT new br.com.example.model.PortoView(p.objectid, p.municipio, p.nomeUf, uf.sigla,  p.geometria) \n" + 
                    "FROM Porto p, Estado uf\n" +
                    "WHERE p.uf = uf.codigo\n" +
                    "ORDER BY uf.sigla")
    List<PortoView> listaPortos();
    
    
    @Query(value = "SELECT new br.com.example.model.PortoView(p1.objectid, p1.municipio, p1.nomeUf, uf.sigla,  p1.geometria) FROM Porto p1\n" +
                    "INNER JOIN Estado uf ON st_DWithin(geography(uf.geometria), geography(p1.geometria), 20000) = true\n" +
                    "WHERE uf.sigla = :uf")
    List<PortoView> portosEstado(String uf);
    
    
    @Query(value = "SELECT new br.com.example.model.PortoView(p.objectid, p.municipio, p.nomeUf, uf.sigla,  p.geometria) FROM Porto p, Estado uf\n" +
                    "WHERE p.regiao = :regiao AND p.uf = uf.codigo")
    List<PortoView> portosRegiao(String regiao);
    
    
}
