package mw.rest.MWRest.service;

import lombok.Setter;
import mw.rest.MWRest.model.Usuario;
import mw.rest.MWRest.repository.PostagemRepository;
import mw.rest.MWRest.repository.UsuarioRepository;
import mw.rest.MWRest.service.api.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service(value = "usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    @Setter
    private UsuarioRepository usuarioRepository;

    @Autowired
    @Setter
    private PostagemRepository postagemRepository;


    @Override
    @Transactional
    public Usuario inserirUsuario(String nome, String usuario, String senha, String email) {
        Usuario user = new Usuario(nome, usuario, senha, email);
        return usuarioRepository.save(user);
    }

    @Override
    public List<Usuario> buscar(String nome) {
        return (List<Usuario>) usuarioRepository.findByNome(nome);
    }

    @Override
    public Optional<Usuario> buscar(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return (List<Usuario>) usuarioRepository.findAll();
    }
}
