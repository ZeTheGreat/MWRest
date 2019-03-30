package mw.rest.MWRest.controller;


import lombok.Setter;
import mw.rest.MWRest.model.Usuario;
import mw.rest.MWRest.service.api.UsuarioService;
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
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    @Setter
    private UsuarioService usuarioService;

    @GetMapping(value = "/get/{nome}")
    public ResponseEntity<Collection<Usuario>> buscarUsuarioPorNome(@PathVariable("nome") String nome){
        return new ResponseEntity<Collection<Usuario>>(usuarioService.buscar(nome), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable("id") Long id){
        Usuario usuario = usuarioService.buscar(id);
        if(usuario == null){
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

    }

    @GetMapping(value = "/get/todos")
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
        response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/usuario/getById?id=" + usuario.getId());
        return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
    }
}
