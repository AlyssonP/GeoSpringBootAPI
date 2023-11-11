package br.com.example.controller;

import java.util.List;
import br.com.example.repository.MunicipioRepository;
import br.com.example.model.MunicipioView;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Geo API", version = "1.0", description = "Dados de geograficos do Brasil"))
public class MunicipioController {
    
    @Autowired
    private MunicipioRepository municipioRepository;
     
    @GetMapping("/municipios_vizinhos/{nome}")
    public List<MunicipioView> municipiosVizinhos(@PathVariable String nome){
        List<MunicipioView> result = municipioRepository.listarMunicipiosVizinhos(nome);
        return result;
    }
   
    @GetMapping("/distancia_entre_municipios/{municipioA}/{municipioB}")
     public Double distanciaEntreMunicipios(@PathVariable String municipioA, @PathVariable String municipioB){
        double result = municipioRepository.distanciaEntreMunicipios(municipioA, municipioB);
        return result;
    }
     
    @GetMapping("/municipios_estado/{uf_estado}")
    public List<MunicipioView> municipiosEstado(@PathVariable String uf_estado) {
        return municipioRepository.municipiosEstado(uf_estado);
    }
     
    @GetMapping("/municipio_frontreira_entre_estados/{uf_estadoA}/{uf_estadoB}")
    public List<MunicipioView> municipiosFronteiraEstado(@PathVariable String uf_estadoA, @PathVariable String uf_estadoB) {
        return municipioRepository.municipiosFronteiraEntreEstados(uf_estadoA, uf_estadoB);
    }
    
    @GetMapping("/municipios_raio_km/{distancia}/{nomeMunicipio}")
    public List<MunicipioView> municipiosRaioKm(@PathVariable String nomeMunicipio, @PathVariable int distancia) {
        return municipioRepository.municipiosRaioKm(nomeMunicipio, distancia*1000);
    }
    
    @GetMapping("/municipios_fronteira_estado/{uf}")
    public List<MunicipioView> municipiosFronteiraEstado(@PathVariable String uf) {
        return municipioRepository.municipiosFronteiraEstado(uf);
    }
    
}