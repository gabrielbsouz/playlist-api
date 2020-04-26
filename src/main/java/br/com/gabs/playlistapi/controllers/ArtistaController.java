package br.com.gabs.playlistapi.controllers;

import br.com.gabs.playlistapi.dto.Artista;
import br.com.gabs.playlistapi.forms.ArtistaPostRequest;
import br.com.gabs.playlistapi.forms.ArtistaPutRequest;
import br.com.gabs.playlistapi.mappers.ArtistaMapper;
import br.com.gabs.playlistapi.services.ArtistaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class ArtistaController {

    private final ArtistaService service;
    private final ArtistaMapper mapper;

    public ArtistaController(ArtistaService service, ArtistaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/v1/artistas")
    public List<Artista> listarArtistas(){

        List<br.com.gabs.playlistapi.models.Artista> modelList = service.listarArtistas();

        List<Artista> artistas = mapper.artistaModelListToArtistaListDTO(modelList);

        return artistas;
    }

    @PostMapping("/v1/artistas")
    public ResponseEntity<Artista> cadastrarArtista(@Valid @RequestBody ArtistaPostRequest request){

        br.com.gabs.playlistapi.models.Artista model = mapper.artistaPostToArtistaModel(request);

        service.cadastrarArtista(model);

        Artista artista = mapper.artistaModelToArtistaDTO(model);

        return new ResponseEntity<>(artista, HttpStatus.CREATED);
    }

    @GetMapping("/v1/artistas/{nome}")
    public List<Artista> pesquisarArtistas(@PathVariable String nome){

        List<br.com.gabs.playlistapi.models.Artista> modelList = service.pesquisarArtistas(nome);

        List<Artista> artistas = mapper.artistaModelListToArtistaListDTO(modelList);

        return artistas;
    }

    @PutMapping("/v1/artistas/{codigo}")
    public Artista atualizarArtista(@PathVariable UUID codigo, @Valid @RequestBody ArtistaPutRequest request){

        br.com.gabs.playlistapi.models.Artista model = mapper.artistaPutToArtistaModel(request);

        service.atualizarArtista(codigo.toString(), model);

        Artista artista = mapper.artistaModelToArtistaDTO(model);

        return artista;
    }
}
