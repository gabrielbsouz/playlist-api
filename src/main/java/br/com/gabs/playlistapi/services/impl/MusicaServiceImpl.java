package br.com.gabs.playlistapi.services.impl;

import br.com.gabs.playlistapi.exceptions.MusicaNaoEncontradaException;
import br.com.gabs.playlistapi.models.Musica;
import br.com.gabs.playlistapi.repositories.MusicaRepository;
import br.com.gabs.playlistapi.services.MusicaService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaServiceImpl implements MusicaService {

    private final MusicaRepository repository;

    public MusicaServiceImpl(MusicaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Musica> listarMusicas() {

        return repository.findAll();
    }

    @Override
    public Musica cadastrarMusica(Musica musica) {

        return repository.save(musica);
    }

    @Override
    public List<Musica> pesquisarMusicas(String nome) {

        List<Musica> musicas = repository.findByNomeContaining(nome);

        if (musicas.isEmpty()){

            throw new MusicaNaoEncontradaException("Musica: " + nome + " não foi encontrada!");
        }
        return musicas;
    }

    @Override
    public Musica atualizarMusica(String codigo, Musica musica) {

        Musica musicaSalva = repository.findById(codigo)
                .orElseThrow(() -> new MusicaNaoEncontradaException("Musica com código: " + codigo + " não foi encontrada!"));

        BeanUtils.copyProperties(musica, musicaSalva, "codigo");
        return repository.save(musicaSalva);
    }

    @Override
    public void excluirMusica(String codigo) {

        if (!repository.existsById(codigo)){

            throw new MusicaNaoEncontradaException("Musica com código: " + codigo + " não foi encontrada!");
        }
        repository.deleteById(codigo);
    }
}
