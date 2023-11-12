/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.example.repository;

import br.com.example.model.EstadoView;
import br.com.example.model.MunicipioView;
import br.com.example.model.PontoFronteira;
import br.com.example.model.PontoFronteiraView;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author alyssonp
 */
public interface PontoFronteiraRepository extends JpaRepository<PontoFronteira, Integer>{
    
    @Query(value = "SELECT new br.com.example.model.EstadoView(uf.codigo, uf.nome, uf.sigla, uf.geometria) FROM Estado uf \n" +
                    "INNER JOIN PontoFronteira pf ON st_within(pf.geometria, uf.geometria) = true\n" +
                    "GROUP BY uf.codigo, uf.nome, uf.sigla, uf.geometria")
    List<EstadoView> estadosContemPonto();
    
    
    @Query(value = "SELECT new br.com.example.model.MunicipioView(m.codigo, m.nome, m.sigla, m.geometria) FROM Estado uf \n" +
                    "INNER JOIN PontoFronteira pf ON st_within(pf.geometria, uf.geometria) = true \n" +
                    "INNER JOIN Municipio m ON st_within(pf.geometria, m.geometria) = true \n" +
                    "WHERE uf.sigla = :uf")
    List<MunicipioView> municipiosEstadoContemPonto(String uf);
    
    
    @Query(value = "SELECT new br.com.example.model.PontoFronteiraView(pf.objectId, pf.municipio, pf.nomeUf, pf.siglaUf, pf.geometria) FROM Estado uf \n" +
                    "INNER JOIN PontoFronteira pf ON st_within(pf.geometria, uf.geometria) = true\n" +
                    "WHERE uf.sigla = :uf")
    List<PontoFronteiraView> pontosFronteiraEstado(String uf);
    
    
    @Query(value = "SELECT new br.com.example.model.PontoFronteiraView(pf.objectId, pf.municipio, pf.nomeUf, pf.siglaUf, pf.geometria) FROM Estado uf \n" +
                    "INNER JOIN PontoFronteira pf ON st_within(pf.geometria, uf.geometria) = true\n" +
                    "WHERE uf.nomeRegiao = :regiao")
    List<PontoFronteiraView> pontosFronteiraRegiao(String regiao);
}
