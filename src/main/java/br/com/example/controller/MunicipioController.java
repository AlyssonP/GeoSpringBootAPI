package br.com.example.controller;

import br.com.example.model.MunicipioDTO;
import java.util.List;
import java.util.ArrayList;
import br.com.example.repository.MunicipioRepository;
import br.com.example.model.MunicipioView;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Geo API", version = "1.0", description = "Dados de geograficos do Brasil"))
public class MunicipioController {
    
    @Autowired
    private MunicipioRepository municipioRepository;

    // Formas de visualização dos dados 
    private MunicipioDTO municipioViewTable(MunicipioView municipioView) {
        return new MunicipioDTO(
                        municipioView.getCodigo(), 
                        municipioView.getNome(), 
                        municipioView.getUf());
    }
    private MunicipioDTO municipioViewMap(MunicipioView municipioView) {
        return new MunicipioDTO(
                            municipioView.getCodigo(), 
                            municipioView.getNome(), 
                            municipioView.getUf(), 
                            municipioView.getGeometria());
    }
    
     
    @GetMapping("/municipios_vizinhos/{nome}")
    public List<MunicipioDTO> municipiosVizinhos(
            @PathVariable String nome,
            @RequestParam(value = "visibility", defaultValue = "map") String visibility){
        
        List<MunicipioDTO> response = new ArrayList<MunicipioDTO>();
        if(visibility.equals("table")) {
            municipioRepository.listarMunicipiosVizinhos(nome)
                    .forEach(municipio -> response.add(municipioViewTable(municipio)));
            
        } else {
            municipioRepository.listarMunicipiosVizinhos(nome)
                    .forEach(municipio -> response.add(municipioViewMap(municipio)));
        }
      
        return response;
    };
   
    
    @GetMapping("/distancia_entre_municipios/{municipioA}/{municipioB}")
    public Double distanciaEntreMunicipios(@PathVariable String municipioA, @PathVariable String municipioB){
        double result = municipioRepository.distanciaEntreMunicipios(municipioA, municipioB);
        return result;
    }
    
    
    @GetMapping("/municipios_estado/{uf_estado}")
    public List<MunicipioDTO> municipiosEstado(
            @PathVariable String uf_estado,
            @RequestParam(value = "visibility", defaultValue = "table") String visibility){
        List<MunicipioDTO> response = new ArrayList<MunicipioDTO>();
        if(visibility.equals("table")) {
            municipioRepository.municipiosEstado(uf_estado)
                    .forEach(municipio -> response.add(municipioViewTable(municipio)));
        } else {
            municipioRepository.municipiosEstado(uf_estado)
                    .forEach(municipio -> response.add(municipioViewMap(municipio)));
        }
        
        return response;
    }
    
    
    @GetMapping("/quantidade_municipios_estado/{uf}")
    public Integer quantidadeMunicipiosEstado(@PathVariable String uf) {
        return municipioRepository.quantidadeMunicipiosEstado(uf);
    }
    
    
    @GetMapping("/municipio_frontreira_entre_estados/{uf_estadoA}/{uf_estadoB}")
    public List<MunicipioDTO> municipiosFronteirEntreEstados(
            @PathVariable String uf_estadoA, 
            @PathVariable String uf_estadoB,
            @RequestParam(value = "visibility", defaultValue = "map") String visibility) {
        
        List<MunicipioDTO> response = new ArrayList<MunicipioDTO>();
        if(visibility.equals("table")) {
            municipioRepository.municipiosFronteiraEntreEstados(uf_estadoA, uf_estadoB)
                    .forEach(municipio -> response.add(municipioViewTable(municipio)));
        } else {
            municipioRepository.municipiosFronteiraEntreEstados(uf_estadoA, uf_estadoB)
                    .forEach(municipio -> response.add(municipioViewMap(municipio)));
        }
        return response;
    }
    
    
    @GetMapping("/municipios_raio_km/{distancia}/{nomeMunicipio}")
    public List<MunicipioDTO> municipiosRaioKm(
            @PathVariable String nomeMunicipio, 
            @PathVariable int distancia,
            @RequestParam(value = "visibility", defaultValue = "map") String visibility) {
        List<MunicipioDTO> response = new ArrayList<MunicipioDTO>();
        if(visibility.equals("table")) {
            municipioRepository.municipiosRaioKm(nomeMunicipio, distancia*1000)
                    .forEach(municipio -> response.add(municipioViewTable(municipio)));
        } else {
            municipioRepository.municipiosRaioKm(nomeMunicipio, distancia*1000)
                    .forEach(municipio -> response.add(municipioViewMap(municipio)));
        }
        return response;
    }
    
    
    @GetMapping("/municipios_fronteira_estado/{uf}")
    public List<MunicipioDTO> municipiosFronteiraEstado(
            @PathVariable String uf,
            @RequestParam(value = "visibility", defaultValue = "map") String visibility) {
        List<MunicipioDTO> response = new ArrayList<MunicipioDTO>();
        if(visibility.equals("table")) {
            municipioRepository.municipiosFronteiraEstado(uf)
                    .forEach(municipio -> response.add(municipioViewTable(municipio)));
        } else {
            municipioRepository.municipiosFronteiraEstado(uf)
                    .forEach(municipio -> response.add(municipioViewMap(municipio)));
        }
        return response;
    }
    
    
    @GetMapping("/municipios/{uf1}/fronteira_estados/{uf2}/{uf3}")
    public List<MunicipioDTO> municipiosEstadoVizinhoDoisEstados(
            @PathVariable String uf1, 
            @PathVariable String uf2, 
            @PathVariable String uf3,
            @RequestParam(value = "visibility", defaultValue = "map") String visibility) {
        List<MunicipioDTO> response = new ArrayList<MunicipioDTO>();
        if(visibility.equals("table")) {
            municipioRepository.municipiosEstadoVizinhoDoisEstados(uf1, uf2, uf3)
                    .forEach(municipio -> response.add(municipioViewTable(municipio)));
        } else {
            municipioRepository.municipiosEstadoVizinhoDoisEstados(uf1, uf2, uf3)
                    .forEach(municipio -> response.add(municipioViewMap(municipio)));
        }
        return response;
    }
}