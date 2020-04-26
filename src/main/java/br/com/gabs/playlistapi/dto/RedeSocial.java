package br.com.gabs.playlistapi.dto;

import lombok.Data;

@Data
public class RedeSocial {

    private String codigo;
    private TipoRedeSocial tipo;
    private String nome;
}
