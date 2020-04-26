package br.com.gabs.playlistapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class Artista {

    private String codigo;
    private String nome;
    private List<RedeSocial> redesSociais;
}
