package br.com.gabs.playlistapi.mappers;

import br.com.gabs.playlistapi.dto.Musica;
import br.com.gabs.playlistapi.forms.MusicaPostRequest;
import br.com.gabs.playlistapi.forms.MusicaPutRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = UuidMapper.class
)
public interface MusicaMapper {

    List<Musica> musicaModelListToMusicaListDTO(List<br.com.gabs.playlistapi.models.Musica> musicaModelList);

    br.com.gabs.playlistapi.models.Musica musicaPostToMusicaModel(MusicaPostRequest request);

    br.com.gabs.playlistapi.models.Musica musicaPutToMusicaModel(MusicaPutRequest request);

    Musica musicaModelToMusicaDTO(br.com.gabs.playlistapi.models.Musica model);
}
