package br.com.gabs.playlistapi.mappers;

import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public class UuidMapper {

    UUID stringToUuid (String elemento){
        return UUID.fromString(elemento);
    }

    String uuidToString(UUID elemento){
        return elemento.toString();
    }
}
