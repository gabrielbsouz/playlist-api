package br.com.gabs.playlistapi.services.impl;

import br.com.gabs.playlistapi.exceptions.ArtistaNaoEncontradoException;
import br.com.gabs.playlistapi.models.Artista;
import br.com.gabs.playlistapi.repositories.ArtistaRepository;
import br.com.gabs.playlistapi.services.ArtistaService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaServiceImpl implements ArtistaService {

    private final ArtistaRepository repository;

    public ArtistaServiceImpl(ArtistaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Artista> listarArtistas() {

        return repository.findAll();
    }

    @Override
    public Artista cadastrarArtista(Artista artista) {

        return repository.save(artista);
    }

    @Override
    public List<Artista> pesquisarArtistas(String nome) {

        if (repository.existsById(nome)){

            throw new ArtistaNaoEncontradoException("Artista: " + nome + "não foi encontrado!");
        }
        return repository.findByNomeContaining(nome);
    }

    @Override
    public Artista atualizarArtista(String codigo, Artista artista) {

        Artista artistaSalvo = repository.findById(codigo)
                .orElseThrow(() -> new ArtistaNaoEncontradoException("Artista com código: " + codigo + " não foi encontrado!"));

        BeanUtils.copyProperties(artista, artistaSalvo, "codigo");

        return repository.save(artistaSalvo);
    }

    @Override
    public void excluirArtista(String codigo) {

        if (repository.existsById(codigo)){

            throw new ArtistaNaoEncontradoException("Artista com código: " + codigo + "não foi encontrado!");
        }
        repository.deleteById(codigo);
    }
}
