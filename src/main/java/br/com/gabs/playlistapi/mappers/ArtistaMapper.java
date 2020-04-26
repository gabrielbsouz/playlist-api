package br.com.gabs.playlistapi.mappers;

import br.com.gabs.playlistapi.dto.Artista;
import br.com.gabs.playlistapi.forms.ArtistaPostRequest;
import br.com.gabs.playlistapi.forms.ArtistaPutRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = UuidMapper.class
)
public interface ArtistaMapper {

    List<Artista> artistaModelListToArtistaListDTO(List<br.com.gabs.playlistapi.models.Artista> artistaModelList);

    br.com.gabs.playlistapi.models.Artista artistaPostToArtistaModel(ArtistaPostRequest request);

    br.com.gabs.playlistapi.models.Artista artistaPutToArtistaModel(ArtistaPutRequest request);

    Artista artistaModelToArtistaDTO(br.com.gabs.playlistapi.models.Artista model);
}
