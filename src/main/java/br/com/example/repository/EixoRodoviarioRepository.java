/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.example.repository;

import br.com.example.model.EixoRodoviario;
import br.com.example.model.EixoRodoviarioView;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author alyssonp
 */
public interface EixoRodoviarioRepository extends JpaRepository<EixoRodoviario, Integer>{
    
    @Query(value = "SELECT new br.com.example.model.EixoRodoviarioView(er.objectid, er.descseg, er.tipoPavimento, er.codigoEixo, er.geometria) FROM EixoRodoviario er\n" +
                    "INNER JOIN Estado uf ON within(er.geometria, uf.geometria) = true\n" +
                    "WHERE uf.nomeRegiao = :regiao")
    List<EixoRodoviarioView> eixosRodoviariosRegiao(String regiao);
    
    @Query(value = "SELECT new br.com.example.model.EixoRodoviarioView(er.objectid, er.descseg, er.tipoPavimento, er.codigoEixo, er.geometria) FROM EixoRodoviario er\n" +
                    "INNER JOIN Estado uf ON within(er.geometria, uf.geometria) = true\n" +
                    "WHERE uf.sigla = :uf")
    List<EixoRodoviarioView> eixosRodoviariosEstado(String uf);
}
