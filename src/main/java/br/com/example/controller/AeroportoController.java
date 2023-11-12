/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.controller;

import br.com.example.model.AeroportoView;
import br.com.example.repository.AeroportoRepository;
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
public class AeroportoController {
    
    @Autowired
    private AeroportoRepository aeroportoRepository;
    
    @GetMapping("/aeroportos")
    public List<AeroportoView> aeroportos() {
        return aeroportoRepository.aeroportos();
    }
    
    @GetMapping("/aeroportos_distancia/{cidade1}/{cidade2}")
    public Double distanciaAeroportos(@PathVariable String cidade1, @PathVariable String cidade2) {
        return aeroportoRepository.distanciaAeroportos(cidade1, cidade2);
    }
    
    @GetMapping("/aeroportos_estado/{uf}")
    public List<AeroportoView> aeroportosEstado(@PathVariable String uf) {
        return aeroportoRepository.aeroportosEstado(uf);
    }
    
    @GetMapping("/aeroportos_regiao/{regiao}")
    public List<AeroportoView> aeroportosRegiao(@PathVariable String regiao) {
        return aeroportoRepository.aeroportosRegiao(regiao);
    }
}
