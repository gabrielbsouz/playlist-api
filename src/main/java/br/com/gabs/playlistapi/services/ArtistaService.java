package br.com.gabs.playlistapi.services;

import br.com.gabs.playlistapi.models.Artista;

import java.util.List;

public interface ArtistaService {

    List<Artista> listarArtistas();

    Artista cadastrarArtista(Artista artista);

    List<Artista> pesquisarArtistas(String nome);

    Artista atualizarArtista(String codigo, Artista artista);

    void excluirArtista(String codigo);
}
