package br.com.gabs.playlistapi.mappers;

import br.com.gabs.playlistapi.dto.Artista;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = UuidMapper.class
)
public interface ArtistaMapper {

    List<Artista> artistaModelListToArtistaListDTO(List<br.com.gabs.playlistapi.models.Artista> artistaModelList);

    Artista artistaModelToArtistaDTO(br.com.gabs.playlistapi.models.Artista model);
}
