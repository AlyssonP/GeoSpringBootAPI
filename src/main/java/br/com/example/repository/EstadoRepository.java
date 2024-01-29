/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.example.repository;

import br.com.example.model.Estado;
import br.com.example.model.EstadoView;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author alyssonp
 */
public interface EstadoRepository extends JpaRepository<Estado, Integer>{
    
    //@Query(value = "select new br.com.example.model.EstadoView(e.codigo, e.nome, e.sigla, e.geometria) from Estado e")
    @Query(value = "select new br.com.example.model.EstadoView(e.codigo, e.nome, e.sigla, e.geometria) from Estado e ORDER BY e.nome")
    List<EstadoView> listarEstados();
    
    
    //@Query(value = "select new br.com.example.model.EstadoView(e.codigo, e.nome, e.sigla, e.geometria) from Estado e where e.nomeRegiao = :regiao")
    @Query(value = "select new br.com.example.model.EstadoView(e.codigo, e.nome, e.sigla, e.geometria) from Estado e where e.nomeRegiao = :regiao ORDER BY e.nome")
    List<EstadoView> listarEstadosRegiao(String regiao);
    
    
    @Query(value = "SELECT new br.com.example.model.EstadoView(e2.codigo, e2.nome, e2.sigla, e2.geometria) FROM Estado e1\n" +
                    "INNER JOIN Estado e2 ON touches(e1.geometria, e2.geometria) = true\n" +
                    "WHERE e1.sigla = :ufEstado ORDER BY e2.nome")
    List<EstadoView> estadosVizinhos(String ufEstado);
    
    
    @Query(value = "SELECT distance(geography(uf1.geometria), geography(uf2.geometria)) FROM Estado uf1, Estado uf2\n" +
                    "WHERE uf1.sigla = :ufA AND uf2.sigla = :ufB")
    public Double distanciaEstados(String ufA, String ufB);
    
    
}
