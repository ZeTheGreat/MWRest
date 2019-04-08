package mw.rest.MWRest.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import mw.rest.MWRest.view.View;

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
    @JsonView({View.UsuarioInteiro.class})
    private Long id;

    @Column(name = "POST_TITULO", length = 140, nullable = false)
    @Getter @Setter
    @JsonView({View.UsuarioInteiro.class})
    private String titulo;

    @Column(name = "POST_CONTEUDO")
    @Getter @Setter
    @JsonView({View.UsuarioInteiro.class})
    private String conteudo;

    //@ManyToMany(mappedBy = "postagens", cascade = CascadeType.ALL)
    //@Getter @Setter
    //private List<Usuario> usuarios = new ArrayList<>();





}

