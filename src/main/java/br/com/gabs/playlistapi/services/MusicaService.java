package br.com.gabs.playlistapi.services;

import br.com.gabs.playlistapi.models.Musica;

import java.util.List;

public interface MusicaService {

    List<Musica> listarMusicas();

    Musica cadastrarMusica(Musica musica);

    List<Musica> pesquisarMusicas(String nome);

    Musica atualizarMusica(String codigo, Musica musica);

    void excluirMusica(String codigo);
}
