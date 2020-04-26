package br.com.gabs.playlistapi.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Playlist {

    @Id
    @Column(name = "CD_PLAYLIST")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String codigo;

    @Column(name = "NM_PLAYLIST")
    private String nome;

    @Column(name = "EN_GENERO")
    private Genero genero;

    @ManyToOne(cascade=CascadeType.ALL)
    private Autor autor;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Musica> musicas;
}
