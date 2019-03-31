package mw.rest.MWRest.model;


import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import mw.rest.MWRest.view.View;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    @Getter
    @Setter
    @JsonView({View.UsuarioInteiro.class, View.UsuarioApenas.class})
    private Long id;

    @Column(name = "USR_NOME", length = 20, nullable = false)
    @Getter
    @Setter
    @JsonView({View.UsuarioInteiro.class, View.UsuarioApenas.class, View.UsuarioUtil.class})
    private String nome;

    @Column(name = "USR_USUARIO", unique = true, length = 20, nullable = false)
    @Getter
    @Setter
    @JsonView({View.UsuarioApenas.class, View.UsuarioInteiro.class})
    private String usuario;

    @Column(name = "USR_SENHA", length = 20, nullable = false)
    @Getter
    @Setter
    @JsonView({View.UsuarioInteiro.class, View.UsuarioApenas.class})
    private String senha;

    @Column(name = "USR_EMAIL", length = 20, nullable = false)
    @Getter
    @Setter
    @JsonView({View.UsuarioApenas.class, View.UsuarioInteiro.class,View.UsuarioUtil.class})
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "POSTAGEM_USUARIO",
            joinColumns = {@JoinColumn(name = "USR_ID")},
            inverseJoinColumns = {@JoinColumn(name = "POST_ID")})
    @Getter
    @Setter
    @JsonView({View.UsuarioInteiro.class})
    private List<Postagem> postagens;

    public Usuario(String nome, String usuario, String senha, String email) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
    }

    public Usuario() {
    }
}
