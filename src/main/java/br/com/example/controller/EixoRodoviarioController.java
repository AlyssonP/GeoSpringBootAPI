/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.controller;

import br.com.example.model.EixoRodoviarioView;
import br.com.example.repository.EixoRodoviarioRepository;
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
public class EixoRodoviarioController {
    
    @Autowired
    private EixoRodoviarioRepository eixoRodoviarioRepository;
    
    @GetMapping("/eixo_rodoviario/regiao/{regiao}")
    public List<EixoRodoviarioView> eixosRodoviariosRegiao(@PathVariable String regiao) {
        return eixoRodoviarioRepository.eixosRodoviariosRegiao(regiao);
    }
    
    @GetMapping("/eixo_rodoviario/estado/{uf}")
    public List<EixoRodoviarioView> eixosRodoviariosEstado(@PathVariable String uf) {
        return eixoRodoviarioRepository.eixosRodoviariosEstado(uf);
    }
}
