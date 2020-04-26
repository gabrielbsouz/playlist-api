package br.com.gabs.playlistapi.forms;

import br.com.gabs.playlistapi.dto.Artista;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class MusicaPostRequest {

    @NotNull @NotEmpty
    private String nome;
    @NotNull
    private LocalDate lancamento;
    @Valid
    private Artista artista;
}
