/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.controller;

import br.com.example.model.PortoView;
import br.com.example.repository.PortoRepository;
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
public class PortoController {
    
    @Autowired
    private PortoRepository portoRepository;
    
    @GetMapping("/portos")
    public List<PortoView> listaPortos() {
        return portoRepository.listaPortos();
    }
    
    @GetMapping("/portos_estado/{uf}")
    public List<PortoView> portosEstado(@PathVariable String uf) {
        return portoRepository.portosEstado(uf);
    }
    
    @GetMapping("/portos_regiao/{regiao}")
    public List<PortoView> portosRegiao(@PathVariable String regiao) {
        return portoRepository.portosRegiao(regiao);
    }
}
