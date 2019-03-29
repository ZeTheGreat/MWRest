package mw.rest.MWRest.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    @Getter @Setter
    private Long id;

    @Column(name = "USR_NOME", length = 20, nullable = false)
    @Getter @Setter
    private String nome;

    @Column(name = "USR_USUARIO", unique = true, length = 20, nullable = false)
    @Getter @Setter
    private String usuario;

    @Column(name = "USR_SENHA", length = 20, nullable = false)
    @Getter @Setter
    private String senha;

    @Column(name = "USR_EMAIL", length = 20, nullable = false)
    @Getter @Setter
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "POSTAGEM_USUARIO",
    joinColumns = {@JoinColumn(name = "USR_ID")},
    inverseJoinColumns = {@JoinColumn(name = "POST_ID")})
    @Getter @Setter
    private List<Postagem> postagens;
}
