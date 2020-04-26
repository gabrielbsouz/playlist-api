package br.com.gabs.playlistapi.repositories;

import br.com.gabs.playlistapi.models.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistaRepository extends JpaRepository<Artista, String> {

    List<Artista> findByNomeContaining(String nome);
}
