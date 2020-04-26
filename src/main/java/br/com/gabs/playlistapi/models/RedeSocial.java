package br.com.gabs.playlistapi.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
public class RedeSocial {

    @Id
    @Column(name = "CD_REDE_SOCIAL")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String codigo;

    @Column(name = "EN_TIPO_REDE_SOCIAL")
    @Enumerated(EnumType.STRING)
    private TipoRedeSocial tipo;

    @Column(name = "NM_REDE_SOCIAL")
    private String nome;
}
