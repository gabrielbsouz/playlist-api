package br.com.gabs.playlistapi.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Musica {

    @Id
    @Column(name = "CD_MUSICA")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String codigo;

    @Column(name = "NM_MUSICA")
    private String nome;

    @Column(name = "DT_LANCAMENTO")
    private LocalDate lancamento;

    @ManyToOne(cascade=CascadeType.ALL)
    private Artista artista;
}
