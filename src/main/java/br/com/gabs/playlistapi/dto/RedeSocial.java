package br.com.gabs.playlistapi.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class RedeSocial {

    private String codigo;
    @Valid
    private TipoRedeSocial tipo;
    @NotNull @NotEmpty
    private String nome;
}
