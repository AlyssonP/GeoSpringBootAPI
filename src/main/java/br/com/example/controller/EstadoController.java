/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.controller;

import br.com.example.model.EstadoView;
import br.com.example.repository.EstadoRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/estados")
    public List<EstadoView> listarEstados(){
        return estadoRepository.listarEstados();
    }
    
    @GetMapping("/estados_regiao/{regiao}")
    public List<EstadoView> listarEstadosRegiao(@PathVariable String regiao) {
        return estadoRepository.listarEstadosRegiao(regiao);
    }
    
    @GetMapping("/estados_vizinhos/{uf}")
    public List<EstadoView> estadosVizinhos(@PathVariable String uf) {
        return estadoRepository.estadosVizinhos(uf);
    }
}
