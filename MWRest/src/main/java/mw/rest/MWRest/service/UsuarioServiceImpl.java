package mw.rest.MWRest.service;

import mw.rest.MWRest.model.Usuario;
import mw.rest.MWRest.service.api.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "usuarioService")
public class UsuarioServiceImpl implements UsuarioService {
    @Override
    public Usuario inserirUsuario(String nome, String usuario, String senha, String email) {
        return null;
    }

    @Override
    public List<Usuario> buscar(String nome) {
        return null;
    }

    @Override
    public Usuario buscar(Long id) {
        return null;
    }

    @Override
    public List<Usuario> buscarTodos() {
        return null;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        return null;
    }
}
