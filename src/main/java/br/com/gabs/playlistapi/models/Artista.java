package br.com.gabs.playlistapi.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Artista {

    @Id
    @Column(name = "CD_ARTISTA")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String codigo;

    @Column(name = "NM_ARTISTA")
    private String nome;

    @OneToMany(cascade=CascadeType.ALL)
    private List<RedeSocial> redesSociais;
}
