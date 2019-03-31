package mw.rest.MWRest.controller;


import com.fasterxml.jackson.annotation.JsonView;
import lombok.Setter;
import mw.rest.MWRest.model.Usuario;
import mw.rest.MWRest.service.api.UsuarioService;
import mw.rest.MWRest.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/")
    public String hello() {
        return "Olá";
    }

    @GetMapping(value = "/nome/{nome}")
    @JsonView({View.UsuarioUtil.class})
    public ResponseEntity<Collection<Usuario>> buscarUsuarioPorNome(@PathVariable("nome") String nome){
        return new ResponseEntity<Collection<Usuario>>(usuarioService.buscar(nome), HttpStatus.OK);
    }

    @GetMapping(value = "/id/{id}")
    @JsonView({View.UsuarioApenas.class})
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable("id") Long id){
        Usuario usuario = usuarioService.buscar(id);
        if(usuario == null){
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

    }

    @JsonView({View.UsuarioInteiro.class})
    @GetMapping(value = "/todos")
    public ResponseEntity<Collection<Usuario>> buscarTodosUsuarios(){
        List<Usuario> usuarios = usuarioService.buscarTodos();

        if(usuarios.isEmpty()) {
            return new ResponseEntity<Collection<Usuario>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Collection<Usuario>>(usuarios, HttpStatus.OK);
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario, HttpServletRequest request, HttpServletResponse response) {
        usuario = usuarioService.inserirUsuario(usuario);
        //response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/usuario/get?id=" + usuario.getId());
        return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
    }
}
