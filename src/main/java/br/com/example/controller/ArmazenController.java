/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.controller;

import br.com.example.model.ArmazenView;
import br.com.example.repository.ArmazenRepository;
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
public class ArmazenController {
    
    @Autowired
    private ArmazenRepository armazenRepository;
    
    @GetMapping("/armazens_distancia/{municipio1}/{municipio2}")
    public Double distanciaArmazens(@PathVariable String municipio1, @PathVariable String municipio2) {
        return armazenRepository.distanciaArmazens(municipio1, municipio2);
    }
    
    @GetMapping("/armazen_estado/{uf}")
    public List<ArmazenView> armazensEstado(@PathVariable String uf) {
        return armazenRepository.armazensEstado(uf);
    }
    
    
    @GetMapping("/armazen_estado/quantidade/{uf}")
    public Integer quantidadeArmazensEstado(@PathVariable String uf) {
        return armazenRepository.quantidadeArmazensEstado(uf);
    }
    
    @GetMapping("/armazen_regiao/{regiao}")
    public List<ArmazenView> armazensRegiao(@PathVariable String regiao) {
        return armazenRepository.armazensRegiao(regiao);
    }
}
