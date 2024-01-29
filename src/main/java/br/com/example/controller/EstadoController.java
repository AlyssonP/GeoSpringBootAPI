/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.controller;

import br.com.example.model.EstadoDTO;
import br.com.example.model.EstadoView;
import br.com.example.repository.EstadoRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alyssonp
 */
@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Geo API", version = "1.0", description = "Dados de geograficos do Brasil"))
public class EstadoController {
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    private EstadoDTO estadoViewSemGeometry(EstadoView estadoView) {
        return new EstadoDTO(
                estadoView.getCodigo(),
                estadoView.getNome(),
                estadoView.getSigla());
    }
    private EstadoDTO estadoViewComGeometry(EstadoView estadoView) {
        return new EstadoDTO(
                estadoView.getCodigo(),
                estadoView.getNome(),
                estadoView.getSigla(),
                estadoView.getGeometria());
    }
    
    
    @GetMapping("/estados")
    public List<EstadoDTO> listarEstados(
            @RequestParam(value = "geometry", defaultValue = "false") boolean geometry){
        
        List<EstadoDTO> response = new ArrayList<>();
        if(geometry) {
            estadoRepository.listarEstados()
                    .forEach(estado -> response.add(estadoViewComGeometry(estado)));
        } else {
             estadoRepository.listarEstados()
                    .forEach(estado -> response.add(estadoViewSemGeometry(estado)));
        }
        return response;
    }
    
    
    @GetMapping("/estados_regiao/{regiao}")
    public List<EstadoDTO> listarEstadosRegiao(
            @PathVariable String regiao,
            @RequestParam(value = "geometry", defaultValue = "false") boolean geometry) {
        List<EstadoDTO> response = new ArrayList<>();
        if(geometry) {
            estadoRepository.listarEstadosRegiao(regiao)
                    .forEach(estado -> response.add(estadoViewComGeometry(estado)));
        } else {
             estadoRepository.listarEstadosRegiao(regiao)
                    .forEach(estado -> response.add(estadoViewSemGeometry(estado)));
        }
        return response;
    }
    
    
    @GetMapping("/estados_vizinhos/{uf}")
    public List<EstadoDTO> estadosVizinhos(
            @PathVariable String uf,
            @RequestParam(value = "geometry", defaultValue = "false") boolean geometry) {
        List<EstadoDTO> response = new ArrayList<>();
        if(geometry) {
            estadoRepository.estadosVizinhos(uf)
                    .forEach(estado -> response.add(estadoViewComGeometry(estado)));
        } else {
             estadoRepository.estadosVizinhos(uf)
                    .forEach(estado -> response.add(estadoViewSemGeometry(estado)));
        }
        return response;
    }
    
    
    @GetMapping("/distancia_estados/{ufA}/{ufB}")
    public Double distanciaEstados(@PathVariable String ufA, @PathVariable String ufB) {
        return estadoRepository.distanciaEstados(ufA, ufB);
    }
}
