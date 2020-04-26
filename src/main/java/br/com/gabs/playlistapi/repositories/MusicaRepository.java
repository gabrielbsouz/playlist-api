package br.com.gabs.playlistapi.repositories;

import br.com.gabs.playlistapi.models.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, String> {

    List<Musica> findByNomeContaining(String nome);
}
