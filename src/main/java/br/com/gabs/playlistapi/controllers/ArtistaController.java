package br.com.gabs.playlistapi.controllers;

import br.com.gabs.playlistapi.dto.Artista;
import br.com.gabs.playlistapi.mappers.ArtistaMapper;
import br.com.gabs.playlistapi.services.ArtistaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtistaController {

    private final ArtistaService service;
    private final ArtistaMapper mapper;

    public ArtistaController(ArtistaService service, ArtistaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/v1/artistas")
    public List<Artista> listarCantores(){

        List<br.com.gabs.playlistapi.models.Artista> modelList = service.listarArtistas();

        List<Artista> artistas = mapper.artistaModelListToArtistaListDTO(modelList);

        return artistas;
    }
}
