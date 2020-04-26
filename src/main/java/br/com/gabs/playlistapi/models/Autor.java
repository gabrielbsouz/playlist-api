package br.com.gabs.playlistapi.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Autor {

    @Id
    @Column(name = "CD_AUTOR")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String codigo;

    @Column(name = "NM_AUTOR")
    private String nome;
}
