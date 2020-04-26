package br.com.gabs.playlistapi.dto;

import br.com.gabs.playlistapi.models.Artista;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Musica {

    private String codigo;
    private String nome;
    private LocalDate lancamento;
    private Artista artista;
}
