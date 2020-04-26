package br.com.gabs.playlistapi.controllers;

import br.com.gabs.playlistapi.dto.Musica;
import br.com.gabs.playlistapi.mappers.MusicaMapper;
import br.com.gabs.playlistapi.services.MusicaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MusicaController {

    private final MusicaService service;
    private final MusicaMapper mapper;

    public MusicaController(MusicaService service, MusicaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/v1/musicas")
    public List<Musica> listarMusicas(){

        List<br.com.gabs.playlistapi.models.Musica> musicaListDTO = service.listarMusicas();

        List<Musica> musicas = mapper.musicaModelListToMusicaListDTO(musicaListDTO);

        return musicas;
    }
}
