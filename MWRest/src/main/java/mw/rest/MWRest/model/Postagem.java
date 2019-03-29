package mw.rest.MWRest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "POSTAGEM")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    @Getter @Setter
    private Long id;

    @Column(name = "POST_TITULO", length = 140, nullable = false)
    @Getter @Setter
    private String titulo;

    @Column(name = "POST_CONTEUDO")
    @Getter @Setter
    private String conteudo;

    @ManyToMany(mappedBy = "postagens", cascade = CascadeType.ALL)
    @Getter @Setter
    private List<Usuario> usuarios = new ArrayList<>();





}

