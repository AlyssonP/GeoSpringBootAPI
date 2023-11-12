/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.controller;

import br.com.example.model.EstadoView;
import br.com.example.model.MunicipioView;
import br.com.example.model.PontoFronteiraView;
import br.com.example.repository.PontoFronteiraRepository;
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
public class PontoFronteiraController {
    
    @Autowired
    private PontoFronteiraRepository pontoFronteiraRepository;
    
    @GetMapping("/estados_ponto_fronteira")
    public List<EstadoView> estadosContemPonto() {
        return pontoFronteiraRepository.estadosContemPonto();
    }
    
    @GetMapping("/municipios_estado_ponto_fronteira/{uf}")
    public List<MunicipioView> municipiosEstadoContemPonto(@PathVariable String uf) {
        return pontoFronteiraRepository.municipiosEstadoContemPonto(uf);
    }
    
    @GetMapping("/pontos_fronteira_estado/{uf}")
    public List<PontoFronteiraView> pontosFronteiraEstado(@PathVariable String uf) {
        return pontoFronteiraRepository.pontosFronteiraEstado(uf);
    }
    
    @GetMapping("/pontos_fronteira_regiao/{regiao}")
    public List<PontoFronteiraView> pontosFronteiraRegiao(@PathVariable String regiao) {
        return pontoFronteiraRepository.pontosFronteiraRegiao(regiao);
    }
}
