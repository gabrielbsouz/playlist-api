package br.com.gabs.playlistapi.forms;

import br.com.gabs.playlistapi.dto.RedeSocial;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ArtistaPostRequest {

    @NotNull @NotEmpty
    private String nome;
    @Valid
    private List<RedeSocial> redesSociais;
}
